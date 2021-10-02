/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cerebro;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;

/**
 *
 * @author aayush.garg
 */
public class data {

    static String dirDataset = "D:/ag/github/Cerebro/dataset";
    static String taskToPerform;
    static String taskPrep = "prep";
    static String taskTest = "test";
    static String taskCombineToSimulate = "combinetosimulate";
    static String strSmpForTest = "smp";
    static String strSimulation = "simulation";
    static LinkedList<String> lstSupportedTasks = new LinkedList<String>(Arrays.asList(taskPrep, taskTest, taskCombineToSimulate));
    static LinkedList<String> lstSupportedSrcLangs = new LinkedList<String>(Arrays.asList("c", "java"));
    static LinkedList<String> lstSupportedAbstractionTypes = new LinkedList<String>(Arrays.asList("full", "partial"));
    static String partialAbstraction;
    static String _focussedMutants = "subsuming";
    static Boolean _noChangeAsNegative = false;
    static String strTab = "[\\t ]";
    static String strTwoSpaces = "\\s{2,}";
    static Boolean _genUse = false;
    static String _language;
    static String _datasetPath;
    static String _sourceCodeFileExtension;
    static String _srcmlCodeFileExtension;
    static String _abstRHSCodeFileExtension;
    static String _abstLHSCodeFileExtension;
    static LinkedList<String> _focussedCommitIds;
    static String _availableDataDirectory = "source-code-with-mutant-info";
    static String _abstractedMutantsDirectory;
    static String _generatedSequencesDirectory;
    static Integer _seqLen;

    static String _mapElementSymbolFileName = "element-symbol-mapping.txt";
    static String _elementSymbolSeparator = ",";
    static String _mutantInfoFileExtension = ".*\\_info.json$";
    static String _mutantLabelFileExtension = ".*\\_label.json$";
    static String _srcMLBatchFileName = "srcML.bat";
    static String _generatedMutantsDirectory = "generated-mutants";
    static String _codeReprSeperator = "!";
    static String _eitherSideCodeReprSeperator = "\\$";
    static String _srcmlXMLFileExtension = ".xml";
    static Boolean _logging = Boolean.TRUE;
    static String _reservedKeywordsFileName = "reserved-keywords.txt";
    static String _abstractedFileNameExtension = "abs";
    static String _abstractionMappingFileNameExtension = "absmap.txt";
    static HashMap<String, String> _mapAbstractionUVariableTypeAbbr = new HashMap() {
        {
            put("call", "fn");
            put("function", "fn");
            put("function_decl", "fn");
            put("decl", "vr");
            put("name", "vr");
            put("expr", "vl");
            put("type", "tp");
            put("macro", "mc");
            put("cpp:ifdef", "vr");
            put("cpp:ifndef", "vr");
            put("cpp:pragma", "vr");
            put("enum", "em");
            put("cpp:macro", "mc");
            put("goto", "lb");
            put("label", "lb");
            put("struct", "st");
            put("struct_decl", "st");
            put("typedef", "tp");
            put("union", "tp");
            put("super", "tp");
            put("extends", "tp");
            put("literal", "lr");
            put("sizeof", "vt");
            put("argument", "vt");
            put("parameter", "vt");
            put("cpp:undef", "df");
            put("annotation", "df");
        }
    };
    static LinkedList<String> _reservedSymbols = new LinkedList<String>(Arrays.asList(
            ",", "(", "%", "'", "^", "-", "<", ")", "[", "&", "!",
            "/", ">", ";", "]", "{", "*", "~", ".", "$", "#", "}", "/", "+", "_", ":", "?", "\"", "|", "+=", "-=", "*=", "/=",
            "%=", "==", "!=", ">=", "<=", "&&", "||", "<<", ">>", "##"
    ));
    static String _srcMLNextLineAbbr = "(NL)";
    static String _seqMappingFileNameExtension = "seqmap.txt";
    static String _sequenceFileNameExtension = "seq.txt";
    static String _abstractionMappingSeparator = "\t,\t";
    static String _originalSeqsFileNameExtension = "originalseqs.txt";
    static String _mutantSeqsFileNameExtension = "mutantseqs.txt";
    static String _sequencesDatasetDirectory;
    static String _trainingDatasetDirectory = "train";
    static String _validationDatasetDirectory = "eval";
    static String _testingDatasetDirectory = "test";
    static String _lhsFileName = "lhs.txt";
    static String _rhsFileName = "rhs.txt";
    static String _trainEvalTestMappingFileName = "trainevaltestmap.txt";
    static String _generatedrhsFileNameAbbr = "genrhs-";
    static String _scoresDatasetDirectory = "scores";
    static String _mutantIdBasedScoresDatasetDirectory = "mutantidbasedscores";
    static String _scoresFileNameExtension = "scores.csv";
    static String _accuracyColName = "accuracy";
    static String _precisionColName = "precision";
    static String _recallColName = "recall";
    static String _f1ColName = "f1";
    static String _mccColName = "mcc";
    static String _modelColName = "model";
    static String _IrrelevantChangesPercentageColName = "irrelevantchangespercentage";
    static HashMap<String, String> _mapSrcMLReplacement = new HashMap() {
        {
            put(">", "&gt;");
            put("<", "&lt;");
            put("&", "&amp;");
        }
    };
    static HashMap<String, String> _mapSrcMLReplacementToSymbols = new HashMap() {
        {
            put("&gt;", ">");
            put("&lt;", "<");
            put("&amp;", "&");
        }
    };
    static HashMap<String, Integer> _mapTrainEvalTest = new HashMap() {
        {
            put("train", 0);
            put("eval", 1);
            put("test", 2);
        }
    };
    static String _tempDirectory = "temp";
    static String _afterIgnoringNodeMapChangeAbbr = "-m";
    static String _tpColName = "tp";
    static String _tnColName = "tn";
    static String _fpColName = "fp";
    static String _fnColName = "fn";
    static Integer _percentageValTestSet = 10;
    static String _focussedMutantKeyInInfoFile = _focussedMutants.equals("subsuming") ? "subsume" : null;
    static String _focussedMutantInInfoFileSeparator = ":";
    static String _nextLineSeparator = "\\r\\n";
    static String _focussedMutantType = _focussedMutants.equals("subsuming") ? "S" : null;
    static String _unfocussedMutantType = "N";
    static String[] mutationTypes = new String[]{_focussedMutantType, _unfocussedMutantType};
    static String _lhsSeqsFileNameExtension = "lhsseqs.txt";
    static String _rhsSeqsFileNameExtension = "rhsseqs.txt";
    static String _lhsRelSeqsFileNameExtension = "lhsrelseqs.txt";
    static String _rhsRelSeqsFileNameExtension = "rhsrelseqs.txt";
    static String _lhsBigSeqsFileNameExtension = "lhsbigseqs.txt";
    static String _rhsBigSeqsFileNameExtension = "rhsbigseqs.txt";
    static String _roundDirectoryNameAbbr = "round";
    static String _mutOperatorTypeStartAbbr = "MST[";
    static String _mutOperatorTypeStopAbbr = "]MSP";
    static String _labelAbbrFocussedMutant = _noChangeAsNegative ? "[" + _focussedMutantType : "[" + _focussedMutantType + "]";
    static String _labelAbbrUnfocussedMutant = _noChangeAsNegative ? "[]" : "[" + _unfocussedMutantType + "]";
    static String _stringkleechange = "klee_change";
    static String _indicesMappingFileNameExtension = "indicesmap.txt";
    static String _mutantIdIndexMapFileNameExtension = "mutantidindexmap.txt";
    static String _mutantIdMapFileName = "mutantidmap.txt";
    static String _fileNameProgramNameSeparator = "_";
    static String strInitialCommandForsrcml = "srcml";
    static String[] lstDatasetNums = new String[]{"01", "02", "03", "04", "05"};
    static HashMap<String, String> _mapUsedBeforeSimulation = new HashMap() {
        {
            put("text_", "commons-text_");
            put("codec_", "commons-codec_");
            put("cli_", "commons-cli_");
            put("csv_", "commons-csv_");
            put("net_", "commons-net_");
            put("collections_", "commons-collections_");
            put("io_", "commons-io_");
            put("lang_", "commons-lang_");
            put("joda_", "joda-time_");
        }
    };
}
