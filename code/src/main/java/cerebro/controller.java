/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cerebro;

import cerebro.util;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.regex.Pattern;

/**
 *
 * @author aayush.garg
 */
public class controller {

    util _util;

    public controller(String task, String srcLang, Integer seqLen, String abstractionType) throws Exception {
        try {
            InitializeDataVars(task, srcLang, seqLen, abstractionType);
            _util = new util();
        } catch (Exception ex) {
            System.out.println("error at controller.<init>()");
            ex.printStackTrace();
        }
    }

    private void InitializeDataVars(String task, String srcLang, Integer seqLen, String abstractionType) throws Exception {
        try {
            data.taskToPerform = task;
            data._language = srcLang;
            data._datasetPath = data.dirDataset + "/" + data._focussedMutants + "-mutant-prediction-" + data._language;
            data._sourceCodeFileExtension = ".*\\." + data._language + "$";
            data._srcmlCodeFileExtension = "." + data._language;
            data._abstRHSCodeFileExtension = "_rhs_abs" + data._srcmlCodeFileExtension;
            data._abstLHSCodeFileExtension = "_lhs_abs" + data._srcmlCodeFileExtension;
            data._focussedCommitIds = data._language == "c"
                    ? new LinkedList<String>(Arrays.asList(
                            "base64", "basename", "chcon", "chgrp", "chmod", "tee", "chroot", "cksum", "comm", "date",
                            "df", "dirname", "mkfifo", "expr", "factor", "false", "groups", "join", "link", "logname",
                            "ls", "md5sum", "mkdir", "echo", "touch", "mktemp", "nproc", "numfmt", "pathchk", "printf",
                            "pwd", "realpath", "rmdir", "truncate", "sha512sum", "sleep", "stdbuf", "sum", "sync",
                            "chown", "mknod", "sha256sum", "tty", "uname", "uptime", "users", "wc", "whoami"
                    )) : new LinkedList<String>(Arrays.asList(
                            "cli",
                            "collections",
                            "text",
                            "net",
                            "csv",
                            "io",
                            "lang",
                            "codec",
                            "joda",
                            "jsoup"
                    ));
            data._seqLen = seqLen;
            switch (abstractionType) {
                case "full":
                    data.partialAbstraction = "";
                    break;
                case "partial":
                    data.partialAbstraction = "pa-";
                    break;
            }
            data._generatedSequencesDirectory = data.partialAbstraction + "generated-sequences-" + data._seqLen;
            data._sequencesDatasetDirectory = data.partialAbstraction + "smp-" + data._language + "-" + data._seqLen;
            data._abstractedMutantsDirectory = data.partialAbstraction + "abstracted-mutants";
        } catch (Exception ex) {
            System.out.println("error at file2mappedabsseqs.controller.InitializeDataVars()");
            throw ex;
        }
    }

    public void PerformTasks() throws Exception {
        try {
            switch (data.taskToPerform) {
                case "prep":
                    LoadData();
                    GenerateAbstractedCodeFileAndMapping();
                    GenerateAllAbstractedMutantsByAppending();
                    GenerateOriginalCodeSequences();
                    GenerateAllPairedMutantSequences();
                    for (String strDatasetNum : data.lstDatasetNums) {
                        GenerateTrainingEvaluationTestingDatasets(strDatasetNum);
                    }
                    break;
                case "test":
                    LoadData();
                    for (String strDatasetNum : data.lstDatasetNums) {
                        GetPerformanceMetricsForAllMutants(strDatasetNum);
                    }
                    break;
                case "combinetosimulate":
                    CombineToSimulate();
                    break;
            }
        } catch (Exception ex) {
            System.out.println("error at controller.PerformTasks()");
            ex.printStackTrace();
        }
    }

    private void LoadData() throws Exception {
        try {
            String dataDirectoryPath = data._datasetPath + "/" + data._availableDataDirectory;
            File availableDataDirectory = new File(dataDirectoryPath);
            for (File sourceCodeDirectory : availableDataDirectory.listFiles()) {
                String commitID = sourceCodeDirectory.getName();
                if (data._focussedCommitIds.contains(commitID)) {
                    LoadAllData(commitID);
                }
            }
        } catch (Exception ex) {
            System.out.println("Error | controller.LoadData()");
            ex.printStackTrace();
            throw ex;
        }
    }

    private void LoadAllData(String commitID) throws Exception {
        try {
            String commitDataPath = data._datasetPath + "/" + data._availableDataDirectory + "/" + commitID;
            System.out.println("processing " + commitDataPath);
            File commitDataDirectory = new File(commitDataPath);
            HashMap<String, LinkedList<String>> mapSourceCode = new HashMap();
            HashMap<Integer, mutant> mapMutants = new HashMap();
            HashMap<Integer, Integer> mapFocussedMutantIDs = new HashMap();
            for (File fileInCommitDataDirectory : commitDataDirectory.listFiles()) {
                if (fileInCommitDataDirectory.getName().matches(data._sourceCodeFileExtension)) {
                    LinkedList<String> listSourceCodeLines = _util.ReadFileToList(fileInCommitDataDirectory.getPath());
                    mapSourceCode.put(fileInCommitDataDirectory.getName(), listSourceCodeLines);
                } else if (fileInCommitDataDirectory.getName().matches(data._mutantInfoFileExtension)) {
                    mapMutants = _util.GetMutantsMap(fileInCommitDataDirectory.getPath());
                } else if (fileInCommitDataDirectory.getName().matches(data._mutantLabelFileExtension)) {
                    mapFocussedMutantIDs = _util.GetFocussedMutantIDMap(fileInCommitDataDirectory.getPath());
                }
            }
            HashMap<Integer, mutant> mapFocussedMutants = new HashMap();
            for (Integer focussedMutantID : mapFocussedMutantIDs.keySet()) {
                if (mapMutants.containsKey(focussedMutantID)) {
                    mutant obj = mapMutants.get(focussedMutantID);
                    obj.clusterId = mapFocussedMutantIDs.get(focussedMutantID);
                    mapFocussedMutants.put(focussedMutantID, obj);
                }
            }
            HashMap<Integer, mutant> mapUnfocussedMutants = new HashMap();
            for (Integer mutantID : mapMutants.keySet()) {
                if (mapFocussedMutants.containsKey(mutantID) == false) {
                    mapUnfocussedMutants.put(mutantID, mapMutants.get(mutantID));
                }
            }
            if (_util._mapSourceCode == null) {
                _util._mapSourceCode = new HashMap();
            }
            if (_util._mapFocussedMutants == null) {
                _util._mapFocussedMutants = new HashMap();
            }
            if (_util._mapUnfocussedMutants == null) {
                _util._mapUnfocussedMutants = new HashMap();
            }
            _util._mapSourceCode.put(commitID, mapSourceCode);
            _util._mapFocussedMutants.put(commitID, mapFocussedMutants);
            _util._mapUnfocussedMutants.put(commitID, mapUnfocussedMutants);
            System.out.println("controller.LoadAllData() | " + commitID + " | Focussed Mutants(%): " + (mapFocussedMutants.size() * 100) / (mapFocussedMutants.size() + mapUnfocussedMutants.size()));
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    private void GenerateAbstractedCodeFileAndMapping() throws Exception {
        try {
            String dataDirectoryPath = data._datasetPath + "/" + data._availableDataDirectory;
            File availableDataDirectory = new File(dataDirectoryPath);
            for (File commitDirectory : availableDataDirectory.listFiles()) {
                String commitID = commitDirectory.getName();
                if (data._focussedCommitIds.contains(commitID) == false) {
                    continue;
                }
                _util.WriteAbstractedCodeFileAndMapping(commitDirectory, commitID);
            }
        } catch (Exception ex) {
            System.err.println("Error | controller.GenerateAbstractedCodeFileAndMapping()");
            ex.printStackTrace();
            throw ex;
        }
    }

    private void GenerateAllAbstractedMutantsByAppending() throws Exception {
        try {
            String abstractedMutantsDirectoryPath = data._datasetPath + "/" + data._abstractedMutantsDirectory;
            File abstractedMutantsDirectory = new File(abstractedMutantsDirectoryPath);
            for (File abstCommitDirectory : abstractedMutantsDirectory.listFiles()) {
                String commitID = abstCommitDirectory.getName();
                if (data._focussedCommitIds.contains(commitID) == false) {
                    continue;
                }
                String abstCodeCommitDirectoryPath = abstractedMutantsDirectoryPath + "/" + commitID;
                HashMap<String, LinkedList<String>> mapFileNameWithCodeList = _util._mapSourceCode.get(commitID);
                for (String codeFileName : mapFileNameWithCodeList.keySet()) {
                    Boolean mapIndicesRequiresChange = false;
                    String abstCodeFileName = codeFileName.replace(data._srcmlCodeFileExtension, "_" + data._abstractedFileNameExtension + data._srcmlCodeFileExtension);
                    String origCodeFileNameWithoutExt = abstCodeFileName.split(Pattern.quote("_"))[0];

                    String indicesFileName = origCodeFileNameWithoutExt + "_" + data._indicesMappingFileNameExtension;
                    HashMap<Integer, Integer> mapOrigToAbstSentence = _util.LoadMapIndices(abstCodeCommitDirectoryPath, indicesFileName);

                    String origCodeFileName = origCodeFileNameWithoutExt + data._srcmlCodeFileExtension;
                    LinkedList<String> origCodeList = _util._mapSourceCode.get(commitID).get(origCodeFileName);
                    LinkedList<String> origAbstCodeList = _util.ReadFileToList(abstCodeCommitDirectoryPath + "/" + abstCodeFileName);

                    for (String rtype : data.mutationTypes) {
                        HashMap<Integer, mutant> mapMutants = rtype.equals(data._focussedMutantType) ? _util._mapFocussedMutants.get(commitID) : _util._mapUnfocussedMutants.get(commitID);
                        for (int mutantID : mapMutants.keySet()) {
                            mutant mut = mapMutants.get(mutantID);
                            //Explicit matching of code file name and mutant's code file name
                            if (mut.sourceCodeFileName.equals(codeFileName) == false) {
                                continue;
                            }
                            String abstMutRhsCodeFileName = origCodeFileNameWithoutExt + "_" + mutantID + data._abstRHSCodeFileExtension;
                            String abstMutLhsCodeFileName = origCodeFileNameWithoutExt + "_" + mutantID + data._abstLHSCodeFileExtension;

                            if (_util.FileExists(abstCodeCommitDirectoryPath + "/" + abstMutRhsCodeFileName) && _util.FileExists(abstCodeCommitDirectoryPath + "/" + abstMutLhsCodeFileName)) {
                                continue;
                            }

                            LinkedList<String> mutAbstCodeListRHS = new LinkedList();
                            LinkedList<String> mutAbstCodeListLHS = new LinkedList();

                            if (data._logging) {
                                System.out.println("processing " + commitID + " | " + mutantID + "|" + codeFileName);
                            }

                            int origdiffIndex = mut.sourceCodeLineNum - 1;
                            int absdiffIndex = -1;
                            String strMutOpTypeRHS = " " + data._mutOperatorTypeStartAbbr + mut.originalCodeRepr
                                    + (mut.changedCodeRepr.isEmpty() ? "" : data._codeReprSeperator + mut.changedCodeRepr)
                                    + data._mutOperatorTypeStopAbbr
                                    + (rtype.equals(data._focussedMutantType) ? data._labelAbbrFocussedMutant : data._labelAbbrUnfocussedMutant);
                            String strMutOpTypeLHS = " " + data._mutOperatorTypeStartAbbr + mut.originalCodeRepr
                                    + (mut.changedCodeRepr.isEmpty() ? "" : data._codeReprSeperator + mut.changedCodeRepr)
                                    + data._mutOperatorTypeStopAbbr + "[]";

                            if (mapOrigToAbstSentence.containsKey(origdiffIndex)) {
                                absdiffIndex = mapOrigToAbstSentence.get(origdiffIndex);
                            }

                            if (absdiffIndex == -1) {
                                String abstractionMappingFileName = origCodeFileNameWithoutExt + "_" + data._abstractionMappingFileNameExtension;
                                if (_util.FileExists(abstCodeCommitDirectoryPath + "/" + abstractionMappingFileName) == false) {
                                    System.out.println("Abstraction Mapping File Missing | " + abstCodeCommitDirectoryPath + "/" + abstractionMappingFileName);
                                    break;
                                }
                                LinkedList<String> listUVariableAbstraction = _util.ReadFileToList(abstCodeCommitDirectoryPath + "/" + abstractionMappingFileName);
                                HashMap<String, String> mapUVariableAbstraction = _util.ConvertListToMap(listUVariableAbstraction, data._abstractionMappingSeparator);

                                LinkedList<String> tempMutRhsCodeList = new LinkedList();
                                for (int i = 0; i < origCodeList.size(); i++) {
                                    if (i == origdiffIndex) {
                                        tempMutRhsCodeList.add(strMutOpTypeRHS);
                                    } else {
                                        tempMutRhsCodeList.add(origCodeList.get(i));
                                    }
                                }
                                String tempMutRhsCodeFileName = abstMutRhsCodeFileName.replace(data._srcmlCodeFileExtension, "_temp" + data._srcmlCodeFileExtension);
                                _util.WriteListToFile(abstCodeCommitDirectoryPath, tempMutRhsCodeFileName, tempMutRhsCodeList);

                                String mutantEssentialXML = _util.GetEssentialXML(abstCodeCommitDirectoryPath + "/" + tempMutRhsCodeFileName);
                                _util.DeleteFile(abstCodeCommitDirectoryPath + "/" + tempMutRhsCodeFileName);
                                if (mutantEssentialXML == null || mutantEssentialXML.isEmpty()) {
                                    continue;
                                }

                                tempMutRhsCodeFileName = tempMutRhsCodeFileName.replace(data._srcmlCodeFileExtension, data._srcmlXMLFileExtension);
                                String abstractedEssentialXML = _util.AbstractXML(mutantEssentialXML, mapUVariableAbstraction);
                                String abstractedSourceCode = _util.ConvertsrcMLToString(abstCodeCommitDirectoryPath, tempMutRhsCodeFileName, abstractedEssentialXML);

                                tempMutRhsCodeList = new LinkedList();
                                tempMutRhsCodeList = _util.ConvertStringToList(abstractedSourceCode, null);
                                for (int i = 0; i < origAbstCodeList.size(); i++) {
                                    if (i > tempMutRhsCodeList.size() - 1) {
                                        break;
                                    }
                                    if (origAbstCodeList.get(i).equals(tempMutRhsCodeList.get(i)) == false) {
                                        absdiffIndex = i;
                                        break;
                                    }
                                }

                                if (absdiffIndex != -1) {
                                    mapOrigToAbstSentence.put(origdiffIndex, absdiffIndex);
                                    mapIndicesRequiresChange = true;
                                } else {
                                    if (false && data._logging) {
                                        System.out.println("Error | controller.GenerateAllAbstractedMutantsByAppending() | Unable to find Mutation Operator Type RHS String in Abstracted Mutant Code file!");
                                    }
                                    continue;
                                }
                            }

                            for (int i = 0; i < origAbstCodeList.size(); i++) {
                                if (i == absdiffIndex) {
                                    mutAbstCodeListRHS.add(origAbstCodeList.get(i) + strMutOpTypeRHS);
                                    mutAbstCodeListLHS.add(origAbstCodeList.get(i) + strMutOpTypeLHS);
                                } else {
                                    mutAbstCodeListRHS.add(origAbstCodeList.get(i));
                                    mutAbstCodeListLHS.add(origAbstCodeList.get(i));
                                }
                            }
                            _util.WriteListToFile(abstCodeCommitDirectoryPath, abstMutRhsCodeFileName, mutAbstCodeListRHS);
                            _util.WriteListToFile(abstCodeCommitDirectoryPath, abstMutLhsCodeFileName, mutAbstCodeListLHS);
                        }
                    }

                    //Write indices mapping to file in the commit directory
                    if (mapIndicesRequiresChange == false) {
                        continue;
                    }
                    _util.DeleteFile(abstCodeCommitDirectoryPath + "/" + indicesFileName);
                    LinkedList<String> listIndices = new LinkedList();
                    for (int origDiffIndex : mapOrigToAbstSentence.keySet()) {
                        listIndices.add(origDiffIndex + data._elementSymbolSeparator + mapOrigToAbstSentence.get(origDiffIndex));
                    }
                    _util.WriteListToFile(abstCodeCommitDirectoryPath, indicesFileName, listIndices);
                }
            }
        } catch (Exception ex) {
            System.err.println("Error | controller.GenerateAllAbstractedMutantsByAppending()");
            ex.printStackTrace();
            throw ex;
        }
    }

    private void GenerateOriginalCodeSequences() throws Exception {
        try {
            String dataDirectoryPath = data._datasetPath + "/" + data._availableDataDirectory;
            File availableDataDirectory = new File(dataDirectoryPath);
            for (File commitDirectory : availableDataDirectory.listFiles()) {
                String commitID = commitDirectory.getName();
                if (data._focussedCommitIds.contains(commitID) == false) {
                    continue;
                }
                if (data._logging) {
                    System.out.println("processing to generate sequences for " + commitID);
                }

                _util.WriteSequencesFileAndMapping(commitDirectory, commitID);
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    private void GenerateAllPairedMutantSequences() throws Exception {
        try {
            Integer biggestSeqLen = 0;
            Integer secondBiggestSeqLen = 0;
            String dataDirectoryPath = data._datasetPath + "/" + data._availableDataDirectory;
            File availableDataDirectory = new File(dataDirectoryPath);
            Boolean tryToIncludeEverything = false;
            for (File commitDirectory : availableDataDirectory.listFiles()) {
                String commitID = commitDirectory.getName();
                if (data._focussedCommitIds.contains(commitID) == false) {
                    continue;
                }
                if (data._logging) {
                    System.out.println(commitID);
                }
                for (File sourceCodeFile : commitDirectory.listFiles()) {
                    if (sourceCodeFile.getName().matches(data._sourceCodeFileExtension) == false) {
                        continue;
                    }
                    String commitSeqDataDirectoryPath = data._datasetPath + "/" + data._generatedSequencesDirectory + "/" + commitID;
                    String origSourceCodeFileNameWithoutExt = sourceCodeFile.getName().replace(data._srcmlCodeFileExtension, "");
                    String lhsSeqsFileName = tryToIncludeEverything ? origSourceCodeFileNameWithoutExt + "_" + data._lhsBigSeqsFileNameExtension
                            : origSourceCodeFileNameWithoutExt + "_" + data._lhsSeqsFileNameExtension;
                    String rhsSeqsFileName = tryToIncludeEverything ? origSourceCodeFileNameWithoutExt + "_" + data._rhsBigSeqsFileNameExtension
                            : origSourceCodeFileNameWithoutExt + "_" + data._rhsSeqsFileNameExtension;
                    String mapFileName = origSourceCodeFileNameWithoutExt + "_" + data._mutantIdIndexMapFileNameExtension;
                    if (_util.FileExists(commitSeqDataDirectoryPath + "/" + lhsSeqsFileName)
                            && _util.FileExists(commitSeqDataDirectoryPath + "/" + rhsSeqsFileName)) {
                        continue;
                    }
                    HashMap<String, LinkedList<String>> returnedMap = _util.GetAllSequencePairsWithMutantIdIndexMapping(commitID, origSourceCodeFileNameWithoutExt, commitSeqDataDirectoryPath, tryToIncludeEverything);
                    if (returnedMap.isEmpty() == false) {
                        LinkedList<String> listSeqLHS = returnedMap.get("lhs");
                        LinkedList<String> listSeqRHS = returnedMap.get("rhs");
                        LinkedList<String> listMapIndexWithMutantID = returnedMap.get("map");
                        _util.WriteListToFile(commitSeqDataDirectoryPath, lhsSeqsFileName, listSeqLHS);
                        _util.WriteListToFile(commitSeqDataDirectoryPath, rhsSeqsFileName, listSeqRHS);
                        _util.WriteListToFile(commitSeqDataDirectoryPath, mapFileName, listMapIndexWithMutantID);

                        if (false && data._logging) {
                            for (String seqRHS : listSeqRHS) {
                                String[] arraySeqRHS = seqRHS.split(Pattern.quote(" "));
                                if (arraySeqRHS.length > biggestSeqLen) {
                                    secondBiggestSeqLen = biggestSeqLen;
                                    biggestSeqLen = arraySeqRHS.length;
                                }
                            }
                            System.out.println("controller.GenerateAllPairedMutantSequences() | Sequence Length Calculation | " + biggestSeqLen + ", " + secondBiggestSeqLen);
                        }
                    }
                }
            }
        } catch (Exception ex) {
            System.err.println("Error | controller.GenerateAllPairedMutantSequences() | " + ex.getLocalizedMessage());
            throw ex;
        }
    }

    private void GenerateTrainingEvaluationTestingDatasets(String strDatasetNum) throws Exception {
        try {
            String seqDatasetDirectory = data._datasetPath + "/" + data.strSmpForTest + "/" + data._sequencesDatasetDirectory + "-" + strDatasetNum;
            if (_util.FileExists(seqDatasetDirectory + "/" + data._trainingDatasetDirectory)
                    || _util.FileExists(seqDatasetDirectory + "/" + data._validationDatasetDirectory)
                    || _util.FileExists(seqDatasetDirectory + "/" + data._testingDatasetDirectory)) {
                System.out.println("Aborting creation of sequence-dataset, directory already exists!");
                System.out.println("Please remove " + seqDatasetDirectory + " directory and try again.");
                return;
            }

            HashMap<String, String> mapTrainEvalTestMap = new HashMap();

            String dataDirectoryPath = data._datasetPath + "/" + data._availableDataDirectory;
            String seqDirectoryPath = data._datasetPath + "/" + data._generatedSequencesDirectory;
            File availableDataDirectory = new File(dataDirectoryPath);
            int commitCount = availableDataDirectory.listFiles().length;
            int maxTestingSetCount = Math.floorDiv(commitCount, data._percentageValTestSet);
            int maxEvaluationSetCount = maxTestingSetCount;
            Boolean useBigSeqs = false;

            int currentTestingSetCount = 0;
            int currentEvaluationSetCount = 0;
            int currentTrainingSetCount = 0;

            HashMap<String, LinkedList<String>> mapExistingTrainEvalTestMap;
            HashMap<String, Integer> mapCommitTurn = new HashMap();
            mapExistingTrainEvalTestMap = _util.GetExistingTrainEvalTestMap(seqDatasetDirectory);

            for (File commitDirectory : availableDataDirectory.listFiles()) {
                String commitID = commitDirectory.getName();
                if (data._focussedCommitIds.contains(commitID) == false) {
                    continue;
                }
                int turn = 3;

                for (String key : mapExistingTrainEvalTestMap.keySet()) {
                    LinkedList<String> listValues = mapExistingTrainEvalTestMap.get(key);
                    if (listValues.contains(commitID)) {
                        turn = data._mapTrainEvalTest.get(key);
                        break;
                    }
                }

                if (data._logging) {
                    System.out.println(commitID + ", turn(0,1,2): " + turn);
                }
                mapCommitTurn.put(commitID, turn);
            }

            Integer[] turns = {2, 1, 0};
            for (int turn : turns) {
                LinkedList<String> listTrainingLHS = new LinkedList();
                LinkedList<String> listTrainingRHS = new LinkedList();

                LinkedList<String> listEvaluationLHS = new LinkedList();
                LinkedList<String> listEvaluationRHS = new LinkedList();

                LinkedList<String> listTestingLHS = new LinkedList();
                LinkedList<String> listTestingRHS = new LinkedList();

                LinkedList<String> listTrainingMapIndexWithMutantID = new LinkedList();
                LinkedList<String> listEvaluationMapIndexWithMutantID = new LinkedList();
                LinkedList<String> listTestingMapIndexWithMutantID = new LinkedList();
                for (File commitDirectory : availableDataDirectory.listFiles()) {
                    String commitID = commitDirectory.getName();
                    if (data._focussedCommitIds.contains(commitID) == false) {
                        continue;
                    }
                    if (mapCommitTurn.get(commitID) != turn) {
                        continue;
                    }
                    for (File sourceCodeFile : commitDirectory.listFiles()) {
                        if (sourceCodeFile.getName().matches(data._sourceCodeFileExtension) == false) {
                            continue;
                        }
                        String commitSeqDataDirectoryPath = seqDirectoryPath + "/" + commitID;
                        String origSourceCodeFileNameWithoutExt = sourceCodeFile.getName().replace(data._srcmlCodeFileExtension, "");

                        String allOriginalSeqFileName = origSourceCodeFileNameWithoutExt + "_" + data._sequenceFileNameExtension;
                        String lhsSeqsFileName = useBigSeqs ? origSourceCodeFileNameWithoutExt + "_" + data._lhsBigSeqsFileNameExtension
                                : origSourceCodeFileNameWithoutExt + "_" + data._lhsSeqsFileNameExtension;
                        String rhsSeqsFileName = useBigSeqs ? origSourceCodeFileNameWithoutExt + "_" + data._rhsBigSeqsFileNameExtension
                                : origSourceCodeFileNameWithoutExt + "_" + data._rhsSeqsFileNameExtension;
                        String mapFileName = origSourceCodeFileNameWithoutExt + "_" + data._mutantIdIndexMapFileNameExtension;

                        if (_util.FileExists(commitSeqDataDirectoryPath + "/" + allOriginalSeqFileName) == false
                                && _util.FileExists(commitSeqDataDirectoryPath + "/" + lhsSeqsFileName) == false
                                && _util.FileExists(commitSeqDataDirectoryPath + "/" + rhsSeqsFileName) == false
                                && _util.FileExists(commitSeqDataDirectoryPath + "/" + mapFileName) == false) {
                            continue;
                        }
                        LinkedList<String> listAllOriginalSeq = useBigSeqs ? null : _util.ReadFileToList(commitSeqDataDirectoryPath + "/" + allOriginalSeqFileName);
                        LinkedList<String> listLHSSeqs = _util.ReadFileToList(commitSeqDataDirectoryPath + "/" + lhsSeqsFileName);
                        LinkedList<String> listRHSSeqs = _util.ReadFileToList(commitSeqDataDirectoryPath + "/" + rhsSeqsFileName);
                        LinkedList<String> listMapIndexWithMutantID = _util.ReadFileToList(commitSeqDataDirectoryPath + "/" + mapFileName);

                        if (listLHSSeqs == null || listRHSSeqs == null) {
                            continue;
                        }

                        if (turn == 0) {
                            //training
                            if (useBigSeqs == false) {
                                for (String originalSeq : listAllOriginalSeq) {
                                    if (listLHSSeqs.contains(originalSeq)) {
                                        int index = listLHSSeqs.indexOf(originalSeq);
                                        listTrainingLHS.add(originalSeq);
                                        listTrainingRHS.add(listRHSSeqs.get(index));
                                    } else {
                                        listTrainingLHS.add(originalSeq);
                                        listTrainingRHS.add(originalSeq);
                                    }
                                }
                            }
                            for (int i = 0; i < listLHSSeqs.size(); i++) {
                                int mutantId = -1;
                                for (String strMap : listMapIndexWithMutantID) {
                                    String[] arrStrMap = strMap.split(Pattern.quote(data._elementSymbolSeparator));
                                    if (Integer.valueOf(arrStrMap[0]) == i) {
                                        mutantId = Integer.valueOf(arrStrMap[1]);
                                    }
                                }
                                String newMapString = listTrainingLHS.size() + data._elementSymbolSeparator + origSourceCodeFileNameWithoutExt + "_" + commitID + data._elementSymbolSeparator + mutantId;
                                listTrainingLHS.add(listLHSSeqs.get(i));
                                listTrainingRHS.add(listRHSSeqs.get(i));
                                listTrainingMapIndexWithMutantID.add(newMapString);
                            }

                            if (mapTrainEvalTestMap.containsKey(data._trainingDatasetDirectory)) {
                                mapTrainEvalTestMap.replace(data._trainingDatasetDirectory,
                                        mapTrainEvalTestMap.get(data._trainingDatasetDirectory) + data._elementSymbolSeparator + commitID);
                            } else {
                                mapTrainEvalTestMap.put(data._trainingDatasetDirectory,
                                        commitID);
                            }
                            currentTrainingSetCount++;
                        }

                        if (turn == 1) {
                            //validation
                            if (useBigSeqs == false) {
                                for (String originalSeq : listAllOriginalSeq) {
                                    if (listLHSSeqs.contains(originalSeq)) {
                                        int index = listLHSSeqs.indexOf(originalSeq);
                                        listEvaluationLHS.add(originalSeq);
                                        listEvaluationRHS.add(listRHSSeqs.get(index));
                                    } else {
                                        listEvaluationLHS.add(originalSeq);
                                        listEvaluationRHS.add(originalSeq);
                                    }
                                }
                            }
                            for (int i = 0; i < listLHSSeqs.size(); i++) {
                                int mutantId = -1;
                                for (String strMap : listMapIndexWithMutantID) {
                                    String[] arrStrMap = strMap.split(Pattern.quote(data._elementSymbolSeparator));
                                    if (Integer.valueOf(arrStrMap[0]) == i) {
                                        mutantId = Integer.valueOf(arrStrMap[1]);
                                    }
                                }
                                String newMapString = listEvaluationLHS.size() + data._elementSymbolSeparator + origSourceCodeFileNameWithoutExt + "_" + commitID + data._elementSymbolSeparator + mutantId;
                                listEvaluationLHS.add(listLHSSeqs.get(i));
                                listEvaluationRHS.add(listRHSSeqs.get(i));
                                listEvaluationMapIndexWithMutantID.add(newMapString);
                            }

                            if (mapTrainEvalTestMap.containsKey(data._validationDatasetDirectory)) {
                                mapTrainEvalTestMap.replace(data._validationDatasetDirectory,
                                        mapTrainEvalTestMap.get(data._validationDatasetDirectory) + data._elementSymbolSeparator + commitID);
                            } else {
                                mapTrainEvalTestMap.put(data._validationDatasetDirectory,
                                        commitID);
                            }
                            currentEvaluationSetCount++;
                        }

                        if (turn == 2) {
                            //testing
                            if (useBigSeqs == false) {
                                for (String originalSeq : listAllOriginalSeq) {
                                    if (listLHSSeqs.contains(originalSeq)) {
                                        int index = listLHSSeqs.indexOf(originalSeq);
                                        listTestingLHS.add(originalSeq);
                                        listTestingRHS.add(listRHSSeqs.get(index));
                                    } else {
                                        listTestingLHS.add(originalSeq);
                                        listTestingRHS.add(originalSeq);
                                    }
                                }
                            }
                            for (int i = 0; i < listLHSSeqs.size(); i++) {

                                int mutantId = -1;
                                for (String strMap : listMapIndexWithMutantID) {
                                    String[] arrStrMap = strMap.split(Pattern.quote(data._elementSymbolSeparator));
                                    if (Integer.valueOf(arrStrMap[0]) == i) {
                                        mutantId = Integer.valueOf(arrStrMap[1]);
                                    }
                                }
                                String newMapString = listTestingLHS.size() + data._elementSymbolSeparator + origSourceCodeFileNameWithoutExt + "_" + commitID + data._elementSymbolSeparator + mutantId;
                                listTestingLHS.add(listLHSSeqs.get(i));
                                listTestingRHS.add(listRHSSeqs.get(i));
                                listTestingMapIndexWithMutantID.add(newMapString);
                            }

                            if (mapTrainEvalTestMap.containsKey(data._testingDatasetDirectory)) {
                                mapTrainEvalTestMap.replace(data._testingDatasetDirectory,
                                        mapTrainEvalTestMap.get(data._testingDatasetDirectory) + data._elementSymbolSeparator + commitID);
                            } else {
                                mapTrainEvalTestMap.put(data._testingDatasetDirectory,
                                        commitID);
                            }
                            currentTestingSetCount++;
                        }

                    }
                }

                switch (turn) {
                    case 0:
                        //Appending to LHS of training list
                        listEvaluationLHS = _util.ReadFileToList(seqDatasetDirectory + "/" + data._validationDatasetDirectory + "/" + data._lhsFileName);
                        for (String evalLHS : listEvaluationLHS) {
                            listTrainingLHS.add(evalLHS);
                        }
                        _util.WriteListToFile(seqDatasetDirectory + "/" + data._trainingDatasetDirectory, data._lhsFileName, listTrainingLHS);
                        listEvaluationLHS = new LinkedList();
                        listTrainingLHS = new LinkedList();

                        //Appending to RHS of training list
                        listEvaluationRHS = _util.ReadFileToList(seqDatasetDirectory + "/" + data._validationDatasetDirectory + "/" + data._rhsFileName);
                        for (String evalRHS : listEvaluationRHS) {
                            listTrainingRHS.add(evalRHS);
                        }
                        _util.WriteListToFile(seqDatasetDirectory + "/" + data._trainingDatasetDirectory, data._rhsFileName, listTrainingRHS);
                        _util.WriteListToFile(seqDatasetDirectory + "/" + data._trainingDatasetDirectory, data._mutantIdMapFileName, listTrainingMapIndexWithMutantID);
                        break;
                    case 1:
                        _util.WriteListToFile(seqDatasetDirectory + "/" + data._validationDatasetDirectory, data._lhsFileName, listEvaluationLHS);
                        _util.WriteListToFile(seqDatasetDirectory + "/" + data._validationDatasetDirectory, data._rhsFileName, listEvaluationRHS);
                        _util.WriteListToFile(seqDatasetDirectory + "/" + data._validationDatasetDirectory, data._mutantIdMapFileName, listEvaluationMapIndexWithMutantID);
                        break;
                    case 2:
                        _util.WriteListToFile(seqDatasetDirectory + "/" + data._testingDatasetDirectory, data._lhsFileName, listTestingLHS);
                        _util.WriteListToFile(seqDatasetDirectory + "/" + data._testingDatasetDirectory, data._rhsFileName, listTestingRHS);
                        _util.WriteListToFile(seqDatasetDirectory + "/" + data._testingDatasetDirectory, data._mutantIdMapFileName, listTestingMapIndexWithMutantID);
                        break;
                }
            }

            if (data._logging) {
                System.out.println("Count | Training: " + currentTrainingSetCount + ", Evaluation: " + currentEvaluationSetCount + ", Testing: " + currentTestingSetCount);
            }
        } catch (Exception ex) {
            System.err.println("Error | controller.GenerateTrainingEvaluationTestingDatasets()");
            ex.printStackTrace();
            throw ex;
        }
    }

    private void GetPerformanceMetricsForAllMutants(String strDatasetNum) throws Exception {
        try {
            String seqDatasetDirectory = data._datasetPath + "/" + data.strSmpForTest + "/" + data._sequencesDatasetDirectory + "-" + strDatasetNum;
            String testDirectoryPath = seqDatasetDirectory + "/" + data._testingDatasetDirectory;
            String lhFilePath = testDirectoryPath + "/" + data._lhsFileName;
            String rhsFilePath = testDirectoryPath + "/" + data._rhsFileName;
            String mutantIdMappingFilePath = testDirectoryPath + "/" + data._mutantIdMapFileName;
            String scoresFileDirectory = seqDatasetDirectory + "/" + data._scoresDatasetDirectory;
            if (_util.FileExists(scoresFileDirectory)) {
                System.out.println(scoresFileDirectory + " already exists!");
                System.out.println("Please remove the directory and try again.");
            } else {
                LinkedList<String> listlhs = _util.ReadFileToList(lhFilePath);
                LinkedList<String> listrhs = _util.ReadFileToList(rhsFilePath);
                LinkedList<String> listTestingMapIndexWithMutantID = _util.ReadFileToList(mutantIdMappingFilePath);
                ArrayList<HashMap<String, String>> arrayPerformanceMetrics = new ArrayList();
                File testDirectory = new File(testDirectoryPath);
                for (File genrhsFile : testDirectory.listFiles()) {
                    String genrhsFileName = genrhsFile.getName();
                    if (genrhsFileName.contains(data._generatedrhsFileNameAbbr) && genrhsFileName.contains(data._afterIgnoringNodeMapChangeAbbr) == false) {
                        String genrhsFilePath = genrhsFile.getPath();
                        String modelName = genrhsFileName.replace(data._generatedrhsFileNameAbbr, "").split(Pattern.quote("."))[0];
                        LinkedList<String> listgenrhs = _util.ReadFileToList(genrhsFilePath);
                        Boolean[] arrReverse = new Boolean[]{false};
                        for (Boolean reverse : arrReverse) {
                            HashMap<String, String> mapPerformanceMetrics = _util.GetPerformanceScoreForAllMutantsWithIdMapping(listlhs, listrhs, listgenrhs,
                                    modelName, "asnegatives", reverse, listTestingMapIndexWithMutantID, strDatasetNum);
                            arrayPerformanceMetrics.add(mapPerformanceMetrics);
                        }
                    }
                }
                _util.WriteArrayListToCSV(scoresFileDirectory, data._scoresFileNameExtension, arrayPerformanceMetrics);
            }
        } catch (Exception ex) {
            System.err.println("Error | controller.GetPerformanceMetricsForAllMutants()");
            throw ex;
        }
    }

    private void CombineToSimulate() {
        try {
            String dirSimulation = data._datasetPath + "/" + data.strSimulation + "/" + data._sequencesDatasetDirectory;
            if (_util.FileExists(dirSimulation) == false) {
                return;
            }
            String strLang = "";
            if (data._language.length() > 1) {
                strLang = data._language.substring(0, 1).toUpperCase() + data._language.substring(1, data._language.length());
            } else {
                strLang = data._language.toUpperCase();
            }
            String strMLJsonFileName = "SupervisedML_Predictions_" + strLang + ".json";
            if (_util.FileExists(dirSimulation + "/" + strMLJsonFileName) == false) {
                System.out.println("\n" + strMLJsonFileName + " is required for cross-checking all sizes");
                return;
            }
            String strDLJsonFileName = "DL_Predictions_" + strLang + ".json";
            if (_util.FileExists(dirSimulation + "/" + strDLJsonFileName) == false) {
                SaveCombinedDLOutputJson(dirSimulation, strDLJsonFileName, strMLJsonFileName);
            }
            //paring jsons to match sizes
            _util.MatchAndSaveJsons(dirSimulation, strDLJsonFileName, strMLJsonFileName);
        } catch (Exception ex) {
            System.out.println("error at controller.CombineToSimulate()");
            ex.printStackTrace();
        }
    }

    private void SaveCombinedDLOutputJson(String dirSimulation, String strDLJsonFileName, String strMLJsonFileName) throws Exception {
        try {
            LinkedList<String> lstCombinedOutput = new LinkedList();
            File folderSimulation = new File(dirSimulation);
            for (File fileTxt : folderSimulation.listFiles()) {
                if (fileTxt.getName().equals(strMLJsonFileName)) {
                    continue;
                }
                LinkedList<String> lstContent = _util.ReadFileToList(fileTxt.getPath());
                for (String strSentence : lstContent) {
                    if (strSentence.trim().isEmpty()) {
                        continue;
                    }
                    strSentence = strSentence.replace(":", ":[");
                    if (data._language.length() > 1) {
                        for (String strToReplace : data._mapUsedBeforeSimulation.keySet()) {
                            if (strSentence.contains(strToReplace)) {
                                strSentence = strSentence.replace(strToReplace, data._mapUsedBeforeSimulation.get(strToReplace));
                            }
                        }
                    }
                    strSentence += "]";
                    if (lstCombinedOutput.isEmpty()) {
                        lstCombinedOutput.add("{");
                        lstCombinedOutput.add(strSentence);
                    } else {
                        lstCombinedOutput.add("," + strSentence);
                    }
                }
            }
            lstCombinedOutput.add("}");
            _util.WriteListToFile(dirSimulation, strDLJsonFileName, lstCombinedOutput);
            System.out.println("finished writing " + dirSimulation + "/" + strDLJsonFileName);
        } catch (Exception ex) {
            System.out.println("error at controller.SaveCombinedDLOutputJson()");
            throw ex;
        }
    }
}
