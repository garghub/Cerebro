/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cerebro;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.StringReader;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map.Entry;
import java.util.regex.Pattern;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.apache.maven.shared.utils.cli.CommandLineUtils;
import org.apache.maven.shared.utils.cli.Commandline;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

/**
 *
 * @author aayush.garg
 */
public class util {

    LinkedList<String> _listElementSymbol;
    LinkedList<String> _listReservedKeywords;
    HashMap<String, String> _mapUVariableAbstraction;
    HashMap<String, Integer> _mapAbsAbbrCount;
    int _numChildNodesLHS, _numChildNodesGenRHS;
    LinkedList<Boolean> _listIgnore;
    HashMap<String, String> _mapElementSymbol;
    HashMap<String, String> _mapChangedOriginalCodeLine;

    HashMap<String, HashMap<String, LinkedList<String>>> _mapSourceCode;
    HashMap<String, HashMap<Integer, mutant>> _mapFocussedMutants;
    HashMap<String, HashMap<Integer, mutant>> _mapUnfocussedMutants;

    public util() throws Exception {
        try {
            _listReservedKeywords = ReadFileToList(data._datasetPath + "/" + data._reservedKeywordsFileName);
        } catch (Exception ex) {
            throw ex;
        }
    }

    public LinkedList<String> ReadFileToList(String filepath) throws Exception {
        try {
            if (!(FileExists(filepath))) {
                if (data._logging) {
                    System.out.println(filepath + " does not exist!");
                }
                return null;
            } else {
                BufferedReader reader = new BufferedReader(new FileReader(filepath));
                LinkedList list = new LinkedList();
                String line = null;
                while ((line = reader.readLine()) != null) {
                    list.add(line);
                }
                if (list.isEmpty()) {
                    list = null;
                }
                reader.close();
                return list;
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public Boolean FileExists(String filepath) throws Exception {
        try {
            File file = new File(filepath);
            if (file.exists()) {
                return true;
            } else {
                return false;
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public HashMap<Integer, mutant> GetMutantsMap(String filePath) throws Exception {
        try {
            HashMap<Integer, mutant> mapMutants = new HashMap();
            JsonParser jsonParser = new JsonParser();
            FileReader reader = new FileReader(filePath);
            Object obj = jsonParser.parse(reader);
            JsonObject objJson = (JsonObject) obj;
            for (Entry<String, JsonElement> entry : objJson.entrySet()) {
                mutant mut = new mutant();
                mut.id = Integer.parseInt(entry.getKey());
                JsonElement jsonElement = entry.getValue();
                String srcLoc = jsonElement.getAsJsonObject().get("SrcLoc").getAsString();
                if (srcLoc.isEmpty() || srcLoc.contains(":") == false) {
                    continue;
                } else {
                    HashMap<String, String> mapFileNameAndLineNum = GetFileNameAndLineNum(srcLoc);
                    mut.sourceCodeFileName = mapFileNameAndLineNum.get("fileName");
                    mut.sourceCodeLineNum = Integer.parseInt(mapFileNameAndLineNum.get("lineNum"));
                }
                String type = jsonElement.getAsJsonObject().get("Type").getAsString();
                if (type.isEmpty()) {
                    continue;
                } else {
                    if (jsonElement.getAsJsonObject().has("FullID")) {
                        String strMoreInfo = jsonElement.getAsJsonObject().get("FullID").getAsString();
                        String[] arrMoreInfo = strMoreInfo.split(Pattern.quote(":"));
                        if (arrMoreInfo.length >= 4) {
                        }
                    }
                    String[] arrayType = type.split(data._codeReprSeperator);
                    mut.originalCodeRepr = arrayType[0];
                    mut.changedCodeRepr = arrayType.length == 1 ? "" : arrayType[1];
                }
                mapMutants.put(Integer.parseInt(entry.getKey()), mut);
            }
            return mapMutants;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public HashMap<String, String> GetFileNameAndLineNum(String string) {
        try {
            HashMap<String, String> mapToReturn = new HashMap();
            String[] arrayString = string.split("/");
            String fileAndLineNum = arrayString[arrayString.length - 1];
            String[] arrayFileLineNum = fileAndLineNum.split(":");
            mapToReturn.put("fileName", arrayFileLineNum[0]);
            mapToReturn.put("lineNum", arrayFileLineNum[1]);
            return mapToReturn;
        } catch (Exception ex) {
            throw ex;
        }
    }

    //To load labels json, the one where you have subsuming mutant Ids mentioned
    HashMap<Integer, Integer> GetFocussedMutantIDMap(String filePath) throws Exception {
        try {
            HashMap<Integer, Integer> mapToReturn = new HashMap();
            JsonParser jsonParser = new JsonParser();
            FileReader reader = new FileReader(filePath);
            Object obj = jsonParser.parse(reader);
            JsonObject objJson = (JsonObject) obj;
            JsonElement jsonElement;
            for (Entry<String, JsonElement> entry : objJson.entrySet()) {
                if (entry.getKey().equals(data._focussedMutantKeyInInfoFile) == false) {
                    continue;
                }
                int clusterId = 0;
                jsonElement = entry.getValue();
                switch (data._focussedMutants) {
                    case "subsuming":
                        jsonElement = jsonElement.getAsJsonArray().get(1);
                        for (JsonElement element : jsonElement.getAsJsonArray()) {
                            for (JsonElement innerElement : element.getAsJsonArray()) {
                                String stringElement = innerElement.getAsString();
                                if (stringElement.isEmpty()) {
                                    continue;
                                } else {
                                    String[] arrayStringElement = stringElement.split(data._focussedMutantInInfoFileSeparator);
                                    int mutantId = Integer.parseInt(arrayStringElement[arrayStringElement.length - 1]);
                                    if (mapToReturn.containsKey(mutantId) == false) {
                                        mapToReturn.put(mutantId, clusterId);
                                    }
                                }
                            }
                            clusterId++;
                        }
                        break;
                }
            }
            return mapToReturn;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public Boolean CreateDirectory(String dirPath) throws Exception {
        try {
            File file = new File(dirPath);
            if (FileExists(dirPath)) {
                return true;
            } else {
                if (file.mkdirs()) {
                    return true;
                } else {
                    return false;
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void WriteListToFile(String filePath, String fileName, LinkedList fileContent) throws Exception {
        try {
            if (fileContent == null) {
                System.out.println("List to be written to " + filePath + "/" + fileName + " was found null!");
                return;
            }
            if (fileContent.isEmpty()) {
                System.out.println("List to be written to " + filePath + "/" + fileName + " was found empty!");
                return;
            }
            if (FileExists(filePath + "/" + fileName)) {
                System.out.println(filePath + "/" + fileName + " already exists.");
            } else {
                if (CreateDirectory(filePath)) {
                    PrintWriter writer = new PrintWriter(filePath + "/" + fileName, "UTF-8");
                    Iterator it = fileContent.iterator();
                    while (it.hasNext()) {
                        writer.println(it.next());
                    }
                    writer.close();
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void DeleteFile(String filePath) throws Exception {
        try {
            File file = new File(filePath);
            file.delete();
        } catch (Exception ex) {
            System.out.println("Error | util.DeleteFile()");
            ex.printStackTrace();
            throw ex;
        }
    }

    public String GetEssentialXML(String filePath) throws Exception {
        try {
            String fileXML = ExecuteProcess(data.strInitialCommandForsrcml, filePath);
            String returnedString = ReturnEssentialTextFromXML(fileXML, "<function>", "</function>", true);
            return returnedString;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public String ExecuteProcess(String batchFilePath, String codeFilePath) throws Exception {
        try {
            String strOutput = "";
            String commandToExec = batchFilePath + " " + codeFilePath;
            ProcessBuilder builder = new ProcessBuilder("cmd.exe", "/c", commandToExec);
            Process p = builder.start();

            BufferedReader reader
                    = new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line;
            while ((line = reader.readLine()) != null) {
                //System.out.println(line);
                if (strOutput.isEmpty()) {
                    strOutput = line;
                } else {
                    strOutput += "\r\n" + line;
                }
            }

            Integer exitCode = p.waitFor();
            if (false) {
                System.out.println("\n" + commandToExec + " exited with error code: " + exitCode);
            }
            return strOutput;
        } catch (Exception ex) {
            System.out.println("error at codeassertiongenerator.util.ExecuteProcess()");
            throw ex;
        }
    }

    public String ReturnEssentialTextFromXML(String string, String startTag, String endTag, Boolean removeSrcMLStartCommand) throws Exception {
        try {
            String stringReturned = "";
            if (string != null && string.isEmpty() == false) {
                if (removeSrcMLStartCommand) {
                    string = string.substring(string.indexOf('<'));
                }
                stringReturned = string.subSequence(0, string.indexOf(data._srcmlCodeFileExtension + "\">") + (data._srcmlCodeFileExtension + "\">").length()).toString();
                String[] strings = string.split(Pattern.quote(startTag));
                for (int i = 0; i < strings.length; i++) {
                    if (strings[i].contains(endTag)) {
                        stringReturned += "\r\n" + startTag;
                        stringReturned += strings[i].subSequence(0, strings[i].indexOf(endTag) + endTag.length()).toString();
                    }
                }
                stringReturned += "\r\n" + "</unit>";
                stringReturned = RemoveUnwantedTextFromXML(stringReturned, "<comment", "</comment>", false);
            }
            return stringReturned;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public String RemoveUnwantedTextFromXML(String string, String startTag, String endTag, Boolean removeSrcMLStartCommand) throws Exception {
        try {
            String stringWithoutComments = "";
            if (string != null && string.isEmpty() == false) {
                if (removeSrcMLStartCommand) {
                    string = string.substring(string.indexOf('<'));
                }
                //string = string.replaceAll("\r\t", " ").replaceAll("\r", " ").replaceAll("\n", " ").replaceAll("\t", " ").replaceAll(data.strTwoSpaces, " ").trim();
                String[] strings = string.split(Pattern.quote(startTag));
                stringWithoutComments = strings[0];
                for (int i = 1; i < strings.length; i++) {
                    if (strings[i].contains(endTag)) {
                        strings[i] = strings[i].substring(strings[i].indexOf(endTag) + endTag.length());
                    }
                    stringWithoutComments += strings[i];
                }
            }
            return stringWithoutComments;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public String AbstractXML(String unabstractedXML, HashMap<String, String> mapUVariableAbstraction) throws Exception {
        try {
            String xml = unabstractedXML;
            DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.parse(new InputSource(new StringReader(xml)));
            doc.getDocumentElement().normalize();
            ReInitiate(mapUVariableAbstraction);
            GenerateUVariableAbstractionMapping(doc.getChildNodes());
            for (String uVariableName : _mapUVariableAbstraction.keySet()) {
                if (_mapUVariableAbstraction.get(uVariableName).contains(data._mapAbstractionUVariableTypeAbbr.get("literal") + "_")) {
                    String stringToReplace = "<literal type=\"string\">" + uVariableName.replace(data._srcMLNextLineAbbr, "\r\n") + "</literal>";
                    String replacedString = "<literal type=\"string\">" + _mapUVariableAbstraction.get(uVariableName) + "</literal>";
                    xml = xml.replace(stringToReplace, replacedString);
                } else {
                    String stringToReplace = "<name>" + uVariableName + "</name>";
                    String replacedString = "<name>" + _mapUVariableAbstraction.get(uVariableName) + "</name>";
                    xml = xml.replace(stringToReplace, replacedString);
                }
            }
            xml = xml.replace("><", "> <");
            return xml;
        } catch (Exception ex) {
            System.out.println(unabstractedXML);
            throw ex;
        }
    }

    private void GenerateUVariableAbstractionMapping(NodeList nodeList) throws Exception {
        try {
            for (int i = 0; i < nodeList.getLength(); i++) {
                Node node = nodeList.item(i);
                String nodeName = node.getNodeName();
                if (nodeName.equals("name") && data.partialAbstraction.isEmpty()) {
                    if (node.getParentNode() != null && node.getFirstChild() != null) {
                        String uVariableType = node.getParentNode().getNodeName();
                        String uVariableName = node.getFirstChild().getNodeValue();
                        AddUVarTypeNameAbbrMapping(uVariableType, uVariableName);
                    }
                } else if (nodeName.equals("literal")) {
                    String nodeType = node.getAttributes().getNamedItem("type").getNodeValue();
                    if (nodeType.equals("string")) {
                        Node childNode = node.getFirstChild();
                        if (childNode != null) {
                            String uVariableType = node.getNodeName();
                            String uVariableName = childNode.getNodeValue().replace("\n", data._srcMLNextLineAbbr);
                            for (String toReplace : data._mapSrcMLReplacement.keySet()) {
                                uVariableName = uVariableName.replace(toReplace, data._mapSrcMLReplacement.get(toReplace));
                            }
                            AddUVarTypeNameAbbrMapping(uVariableType, uVariableName);
                        }
                    }
                }
                if (node.hasChildNodes()) {
                    GenerateUVariableAbstractionMapping(node.getChildNodes());
                }
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    private void Reset() throws Exception {
        try {
            _mapAbsAbbrCount = new HashMap();
            for (String absAbbr : data._mapAbstractionUVariableTypeAbbr.values()) {
                if (!_mapAbsAbbrCount.containsKey(absAbbr)) {
                    _mapAbsAbbrCount.put(absAbbr, 1);
                }
            }
            _mapUVariableAbstraction = new HashMap();
        } catch (Exception ex) {
            throw ex;
        }
    }

    private void ReInitiate(HashMap<String, String> mapUVariableAbstraction) throws Exception {
        try {
            if (mapUVariableAbstraction != null && mapUVariableAbstraction.isEmpty() == false) {
                _mapUVariableAbstraction = mapUVariableAbstraction;
                if (_mapAbsAbbrCount == null) {
                    _mapAbsAbbrCount = new HashMap();
                }
                for (String absAbbr : data._mapAbstractionUVariableTypeAbbr.values()) {
                    if (!_mapAbsAbbrCount.containsKey(absAbbr)) {
                        _mapAbsAbbrCount.put(absAbbr, 1);
                    }
                }
                for (String abstractedVariableName : mapUVariableAbstraction.values()) {
                    String[] abstractedVariableAbbr = abstractedVariableName.split(Pattern.quote("_"));
                    String absVarAbbr = abstractedVariableAbbr[0];
                    if (data._mapAbstractionUVariableTypeAbbr.containsValue(absVarAbbr)) {
                        _mapAbsAbbrCount.replace(absVarAbbr, _mapAbsAbbrCount.get(absVarAbbr) + 1);
                    }
                }
            } else {
                Reset();
            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public HashMap<String, String> ReturnMapUVariableAbstraction() {
        try {
            return _mapUVariableAbstraction;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public LinkedList<String> ConvertMapToList(HashMap<String, String> map, String separator) throws Exception {
        try {
            LinkedList<String> list = new LinkedList();
            for (String key : map.keySet()) {
                String entry = key + separator + map.get(key);
                list.add(entry);
            }
            return list;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public HashMap<String, String> ConvertListToMap(LinkedList<String> list, String separator) throws Exception {
        try {
            HashMap<String, String> map = new HashMap();
            for (String entry : list) {
                if (entry != null && entry.isEmpty() == false) {
                    String[] arrayEntry = entry.split(Pattern.quote(separator));
                    map.put(arrayEntry[0], arrayEntry[1]);
                }
            }
            return map;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public String ConvertsrcMLToString(String tempFilePath, String tempFileName, String xml) throws Exception {
        try {
            LinkedList<String> listXML = new LinkedList();
            listXML.add(xml);
            WriteListToFile(tempFilePath, tempFileName, listXML);
            String srcMLBatchFilePath = data._datasetPath + "/" + data._srcMLBatchFileName;
            String returnedString = ExecuteProcess(data.strInitialCommandForsrcml, tempFilePath + "/" + tempFileName);
            DeleteFile(tempFilePath + "/" + tempFileName);
            if (returnedString != null) {
                String[] arrayReturnedString = returnedString.split(Pattern.quote("\r\n"));
                returnedString = "";
                for (String string : arrayReturnedString) {
                    String newString = string.replaceAll(data.strTab, " ").replaceAll(data.strTwoSpaces, " ").trim();
                    if (newString.isEmpty()) {
                        continue;
                    }
                    if (returnedString.isEmpty()) {
                        returnedString = newString;
                    } else {
                        returnedString += "\r\n" + newString;
                    }
                }
            }
            return returnedString;
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void WriteStringToFile(String filePath, String fileName, String string) throws Exception {
        try {
            LinkedList<String> listString = new LinkedList();
            listString.add(string);
            WriteListToFile(filePath, fileName, listString);
        } catch (Exception ex) {
            throw ex;
        }
    }

    LinkedList<String> GetListTrimAbsSourceCode(String abstractedSourceCodeDirectoryPath, String abstractedSourceCodeFileName) throws Exception {
        try {
            String srcMLBatchFilePath = data._datasetPath + "/" + data._srcMLBatchFileName;
            String xml = ExecuteProcess(data.strInitialCommandForsrcml, abstractedSourceCodeDirectoryPath + "/" + abstractedSourceCodeFileName);
            if (xml != null) {
                xml = xml.substring(xml.indexOf('<'));
            }
            xml = xml.replace("><", "> <");
            String tempFileName = abstractedSourceCodeFileName.replace(data._srcmlCodeFileExtension, "_temp" + data._srcmlXMLFileExtension);
            String spaceSepAbsOrigSourceCode = ConvertsrcMLToString(abstractedSourceCodeDirectoryPath, tempFileName, xml);
            String[] arraySpaceSepAbsOrigSourceCode = spaceSepAbsOrigSourceCode.split(Pattern.quote("\r\n"));
            LinkedList<String> returnedList = new LinkedList();
            for (String string : arraySpaceSepAbsOrigSourceCode) {
                returnedList.add(string.trim());
            }
            return returnedList;
        } catch (Exception ex) {
            throw ex;
        }
    }

    LinkedList<String> GetListTrimDoubleSpaceRemovedAbstCode(String abstractedSourceCodeDirectoryPath, String abstractedSourceCodeFileName) throws Exception {
        try {
            String srcMLBatchFilePath = data._datasetPath + "/" + data._srcMLBatchFileName;
            String xml = ExecuteProcess(data.strInitialCommandForsrcml, abstractedSourceCodeDirectoryPath + "/" + abstractedSourceCodeFileName);
            if (xml != null) {
                xml = xml.substring(xml.indexOf('<'));
            }
            xml = xml.replace("><", "> <");
            String tempFileName = abstractedSourceCodeFileName.replace(data._srcmlCodeFileExtension, "_temp" + data._srcmlXMLFileExtension);
            String spaceSepAbsOrigSourceCode = ConvertsrcMLToString(abstractedSourceCodeDirectoryPath, tempFileName, xml);
            String[] arraySpaceSepAbsOrigSourceCode = spaceSepAbsOrigSourceCode.split(Pattern.quote("\r\n"));
            LinkedList<String> returnedList = new LinkedList();
            for (String string : arraySpaceSepAbsOrigSourceCode) {
                string = string.replaceAll(data.strTab, " ").replaceAll(data.strTwoSpaces, " ").trim();
                returnedList.add(string.trim());
            }
            return returnedList;
        } catch (Exception ex) {
            throw ex;
        }
    }

    private void AddUVarTypeNameAbbrMapping(String uVariableType, String uVariableName) throws Exception {
        try {
            if (uVariableName != null && _listReservedKeywords.contains(uVariableName) == false && _listReservedKeywords.contains(uVariableName.toLowerCase()) == false
                    && _mapUVariableAbstraction.containsKey(uVariableName) == false && data._reservedSymbols.contains(uVariableName) == false) {
                if (data._mapAbstractionUVariableTypeAbbr.containsKey(uVariableType)) {
                    String abbr = data._mapAbstractionUVariableTypeAbbr.get(uVariableType);
                    _mapUVariableAbstraction.put(uVariableName,
                            abbr + "_" + _mapAbsAbbrCount.get(abbr));
                    Integer oldCount = _mapAbsAbbrCount.get(abbr);
                    _mapAbsAbbrCount.replace(abbr, oldCount + 1);
                } else {
                    if (data._logging) {
                        System.out.println("Found new User Variable Type : " + uVariableType + " | Name : " + uVariableName);
                        throw new Exception("Unhandled variable type encountered");
                    }
                }

            }
        } catch (Exception ex) {
            throw ex;
        }
    }

    public void GetSequenceMappingToOriginalCode(String commitID, String origSourceCodeFileNameWithoutExt, LinkedList<String> listTrimAbsOrigSourceCode) throws Exception {
        try {
            LinkedList<String> listSeq = new LinkedList();
            LinkedList<String> listSeqMap = new LinkedList();
            String commitSeqDataDirectoryPath = data._datasetPath + "/" + data._generatedSequencesDirectory + "/" + commitID;
            String seqFileName = origSourceCodeFileNameWithoutExt + "_" + data._sequenceFileNameExtension;
            String mapFileName = origSourceCodeFileNameWithoutExt + "_" + data._seqMappingFileNameExtension;
            if (FileExists(commitSeqDataDirectoryPath + "/" + seqFileName) == false
                    && FileExists(commitSeqDataDirectoryPath + "/" + mapFileName) == false) {
                String seq = "";
                String linesUsed = "";
                Integer countWordsPerLine = 0;
                for (int i = 0; i < listTrimAbsOrigSourceCode.size(); i++) {
                    String line = listTrimAbsOrigSourceCode.get(i);
                    
                    if (seq.isEmpty()) {
                        seq = line;
                        linesUsed = String.valueOf(i);
                    } else {
                        String newLine = seq + " " + line;
                        String[] arrayline = newLine.split(Pattern.quote(" "));
                        if (false & data._logging) {
                            countWordsPerLine = arrayline.length > countWordsPerLine ? arrayline.length : countWordsPerLine;
                        }
                        if (arrayline.length <= data._seqLen) {
                            seq = newLine;
                            linesUsed += data._elementSymbolSeparator + String.valueOf(i);
                        } else {
                            listSeq.add(seq);
                            listSeqMap.add(linesUsed);
                            seq = line;
                            linesUsed = String.valueOf(i);
                        }
                        if (i == listTrimAbsOrigSourceCode.size() - 1) {
                            listSeq.add(seq);
                            listSeqMap.add(linesUsed);
                        }
                    }
                }
                if (false & data._logging) {
                    System.out.println("Word count per line - " + commitID + " - " + origSourceCodeFileNameWithoutExt + " - " + countWordsPerLine);
                }
                WriteListToFile(commitSeqDataDirectoryPath, mapFileName, listSeqMap);
                WriteListToFile(commitSeqDataDirectoryPath, seqFileName, listSeq);
            }
        } catch (Exception ex) {
            System.err.println("Error | util.GetSequenceMappingToOriginalCode()");
            throw ex;
        }
    }

    public HashMap<String, LinkedList<String>> GetAllSequencePairsWithMutantIdIndexMapping(String commitID, String origSourceCodeFileNameWithoutExt,
            String commitSeqDataDirectoryPath, Boolean tryToIncludeEverything)
            throws Exception {
        try {
            HashMap<String, LinkedList<String>> returnedMap = new HashMap();
            LinkedList<String> listSeqLHS = new LinkedList();
            LinkedList<String> listSeqRHS = new LinkedList();
            LinkedList<String> listMapIndexWithMutantID = new LinkedList();
            String abstractedSourceCodeDirectoryPath = data._datasetPath + "/" + data._abstractedMutantsDirectory + "/" + commitID;
            String origSourceCodeSeqMapFileName = origSourceCodeFileNameWithoutExt + "_" + data._seqMappingFileNameExtension;
            System.out.println("processing " + commitSeqDataDirectoryPath + "/" + origSourceCodeSeqMapFileName + " ...");
            if (FileExists(commitSeqDataDirectoryPath + "/" + origSourceCodeSeqMapFileName) == false) {
                if (false && data._logging) {
                    System.out.println("util.GetAllSequencePairsWithMutantIdIndexMapping() | " + commitSeqDataDirectoryPath + "/" + origSourceCodeSeqMapFileName + " does not exist | Skipping.");
                }
                return returnedMap;
            }
            LinkedList<String> listOrigSourceCodeSeqMapping = ReadFileToList(commitSeqDataDirectoryPath + "/" + origSourceCodeSeqMapFileName);

            File abstractedSourceCodeDirectory = new File(abstractedSourceCodeDirectoryPath);
            for (File abstLHSCodeFile : abstractedSourceCodeDirectory.listFiles()) {
                String abstLHSCodeFileName = abstLHSCodeFile.getName();
                if (abstLHSCodeFileName.contains(data._abstLHSCodeFileExtension) == false) {
                    continue;
                }
                String origCodeFileNameWithMutantID = abstLHSCodeFileName.replace(data._abstLHSCodeFileExtension, "");
                String[] arr = origCodeFileNameWithMutantID.split(Pattern.quote("_"));
                String programName = arr[0];
                int mutantID = Integer.valueOf(arr[1]);
                if (abstLHSCodeFileName.equals(origSourceCodeFileNameWithoutExt + "_" + mutantID + data._abstLHSCodeFileExtension) == false) {
                    continue;
                }
                if (data._logging && false) {
                    System.out.println("util.GetAllSequencePairsWithMutantIdIndexMapping() | " + commitID + " | " + programName + " | " + mutantID);
                }
                String abstRHSCodeFileName = origCodeFileNameWithMutantID + data._abstRHSCodeFileExtension;
                if (FileExists(abstractedSourceCodeDirectoryPath + "/" + abstRHSCodeFileName) == false) {
                    System.out.println("util.GetAllSequencePairsWithMutantIdIndexMapping() | " + commitID + " | " + programName + " | " + mutantID + " | RHS abstracted code file missing, skipping");
                    continue;
                }

                LinkedList<String> abstLHSCodeList = ReadFileToList(abstractedSourceCodeDirectoryPath + "/" + abstLHSCodeFileName);
                LinkedList<String> abstRHSCodeList = ReadFileToList(abstractedSourceCodeDirectoryPath + "/" + abstRHSCodeFileName);

                if (abstLHSCodeList.size() != abstRHSCodeList.size()) {
                    System.out.println("util.GetAllSequencePairsWithMutantIdIndexMapping() | Mismatch in Abstracted LHS(" + abstLHSCodeFileName + ") and RHS Code, skipping");
                    continue;
                }

                int changedCodeLineIndex = -1;

                int indexStart = 0;
                int indexStop = 0;
                if (tryToIncludeEverything) {
                    int indexKleeChange = 0;
                    boolean foundBoth = false;
                    for (int i = 0; i < abstLHSCodeList.size(); i++) {
                        String retrievedLine = abstLHSCodeList.get(i);
                        if (retrievedLine.contains(data._stringkleechange)) {
                            indexKleeChange = i;
                        }
                        if (retrievedLine.contains(data._mutOperatorTypeStartAbbr)) {
                            changedCodeLineIndex = i;
                        }
                        if (indexKleeChange != 0 && changedCodeLineIndex != 0) {
                            foundBoth = true;
                            break;
                        }
                    }
                    if (foundBoth == false) {
                        continue;
                    }
                    if (indexKleeChange <= changedCodeLineIndex) {
                        indexStart = indexKleeChange;
                        indexStop = changedCodeLineIndex;
                    } else {
                        indexStart = changedCodeLineIndex;
                        indexStop = indexKleeChange;
                    }
                } else {
                    for (int i = 0; i < abstLHSCodeList.size(); i++) {
                        String retrievedLine = abstLHSCodeList.get(i);
                        if (retrievedLine.contains(data._mutOperatorTypeStartAbbr)) {
                            changedCodeLineIndex = i;
                            break;
                        }
                    }
                }

                if (changedCodeLineIndex == -1) {
                    System.out.println("util.GetAllSequencePairsWithMutantIdIndexMapping() | Unable to find the changed index from Abstracted LHS(" + abstLHSCodeFileName + "), skipping");
                    continue;
                }
                LinkedList<String> listChangedLineIndices = new LinkedList();
                if (tryToIncludeEverything) {
                    String seqLineIndices = "";
                    for (int i = 0; i < abstLHSCodeList.size(); i++) {
                        if (i >= indexStart && i <= indexStop) {
                            if (seqLineIndices.isEmpty()) {
                                seqLineIndices = Integer.toString(i);
                            } else {
                                seqLineIndices += data._elementSymbolSeparator + Integer.toString(i);
                            }
                        }
                    }

                    listChangedLineIndices.add(seqLineIndices);
                } else {
                    Boolean foundSeqLineIndices = false;
                    for (String seqLineIndices : listOrigSourceCodeSeqMapping) {
                        if (foundSeqLineIndices) {
                            break;
                        }
                        String[] arraySeqLineIndices = seqLineIndices.split(Pattern.quote(data._elementSymbolSeparator));
                        for (String lineIndex : arraySeqLineIndices) {
                            if (foundSeqLineIndices) {
                                break;
                            }
                            int intLineIndex = Integer.parseInt(lineIndex);
                            if (intLineIndex == changedCodeLineIndex) {
                                listChangedLineIndices.add(seqLineIndices);
                                foundSeqLineIndices = true;
                            }
                        }
                    }
                }

                for (String linesCombo : listChangedLineIndices) {
                    String seqLHS = "";
                    String seqRHS = "";
                    String[] arraylinesCombo = linesCombo.split(Pattern.quote(data._elementSymbolSeparator));
                    for (String lineIndex : arraylinesCombo) {
                        int intLineIndex = Integer.parseInt(lineIndex);
                        if (seqLHS.isEmpty()) {
                            seqLHS = abstLHSCodeList.get(intLineIndex);
                            seqRHS = abstRHSCodeList.get(intLineIndex);
                        } else {
                            if (abstLHSCodeList.size() <= intLineIndex) {
                                System.out.println("util.GetAllSequencePairsWithMutantIdIndexMapping() | " + commitID + " | " + programName + " | " + mutantID + " | Skipping non-exisiting index (" + intLineIndex + ")");
                                continue;
                            }
                            seqLHS += " " + abstLHSCodeList.get(intLineIndex);
                            seqRHS += " " + abstRHSCodeList.get(intLineIndex);
                        }
                    }

                    if (seqLHS.isEmpty() || seqRHS.isEmpty()) {
                        continue;
                    }
                    String strMapIndexWithMutantID = listSeqLHS.size() + data._elementSymbolSeparator + mutantID;
                    listSeqLHS.add(seqLHS);
                    listSeqRHS.add(seqRHS);
                    listMapIndexWithMutantID.add(strMapIndexWithMutantID);
                }
            }
            if (listSeqLHS.isEmpty() == false && listSeqRHS.isEmpty() == false) {
                returnedMap.put("lhs", listSeqLHS);
                returnedMap.put("rhs", listSeqRHS);
                returnedMap.put("map", listMapIndexWithMutantID);
            }
            return returnedMap;
        } catch (Exception ex) {
            System.err.println("Error | util.GetAllSequencePairsWithMutantIdIndexMapping() | " + ex.getLocalizedMessage());
            throw ex;
        }
    }

    HashMap<String, String> GetPerformanceScoreForAllMutantsWithIdMapping(LinkedList<String> listlhs, LinkedList<String> listrhs, LinkedList<String> listgenrhs, String modelName,
            String considerIrrelevantChanges, Boolean reverse, LinkedList<String> listTestingMapIndexWithMutantID, String strDatasetNum) throws Exception {
        try {
            if (data._logging) {
                System.out.println("util.GetPerformanceScoreForAllMutantsWithIdMapping() | " + modelName + " | Considering irrelevant changes = " + considerIrrelevantChanges);
            }
            HashMap<String, String> mapAll = new HashMap();
            HashMap<String, String> mapPredPos = new HashMap();
            HashMap<String, String> mapPredNeg = new HashMap();
            HashMap<String, String> mapTruePos = new HashMap();
            HashMap<String, String> mapTrueNeg = new HashMap();
            HashMap<String, String> mapFalsePos = new HashMap();
            HashMap<String, String> mapFalseNeg = new HashMap();
            LinkedList<String> listResultMapWithMutantId = new LinkedList();
            String labelAbbrFocussedMutant = reverse ? data._labelAbbrUnfocussedMutant : data._labelAbbrFocussedMutant;
            String labelAbbrUnfocussedMutant = reverse ? data._labelAbbrFocussedMutant : data._labelAbbrUnfocussedMutant;
            LinkedList<String> listgenrhsnew = new LinkedList();

            int tp = 0;
            int tn = 0;
            int fp = 0;
            int fn = 0;
            int totalSeq = 0;
            int totalSeqWithIrrelevantChanges = 0;

            for (int i = 0; i < listlhs.size(); i++) {
                String lhs = listlhs.get(i);
                String rhs = listrhs.get(i);
                String genrhs = listgenrhs.get(i);

                if ((lhs.contains(data._mutOperatorTypeStartAbbr) && lhs.contains(data._mutOperatorTypeStopAbbr)) == false) {
                    listgenrhsnew.add(genrhs);
                    continue;
                }

                String programName = "";
                String sourceCodeFileName = "";
                int mutantId = -1;
                int clusterId = -1;
                for (String strMap : listTestingMapIndexWithMutantID) {
                    String[] arrStrMap = strMap.split(Pattern.quote(data._elementSymbolSeparator));
                    if (Integer.valueOf(arrStrMap[0]) == i) {
                        String fileNameWithProgramName = arrStrMap[1];
                        String[] fileNameWithProgramNameArray = fileNameWithProgramName.split(Pattern.quote(data._fileNameProgramNameSeparator));
                        sourceCodeFileName = fileNameWithProgramNameArray[0];
                        programName = fileNameWithProgramNameArray[1];
                        mutantId = Integer.valueOf(arrStrMap[2]);
                        if (_mapFocussedMutants.containsKey(programName)) {
                            if (_mapFocussedMutants.get(programName).containsKey(mutantId)) {
                                mutant obj = _mapFocussedMutants.get(programName).get(mutantId);
                                clusterId = obj.clusterId;
                            }
                        }
                        break;
                    }
                }

                totalSeq++;

                HashMap<String, Object> mapPrediction = GetPrediction(lhs, rhs, genrhs, considerIrrelevantChanges, labelAbbrFocussedMutant, labelAbbrUnfocussedMutant);
                String prediction = String.valueOf(mapPrediction.get("prediction"));
                Boolean irrelevantChange = Boolean.valueOf(String.valueOf(mapPrediction.get("irrelevantchange")));
                if (false) {
                    System.out.println(i + " | " + prediction + (irrelevantChange ? " | irrlevantChange" : ""));
                }

                listgenrhsnew.add(genrhs);

                if (irrelevantChange) {
                    switch (considerIrrelevantChanges) {
                        case "asnegatives":
                            totalSeqWithIrrelevantChanges++;
                            break;
                        case "aspositives":
                            totalSeqWithIrrelevantChanges++;
                            break;
                        default:
                            continue;
                    }
                }

                if (mapAll.containsKey(programName)) {
                    mapAll.replace(programName, mapAll.get(programName) + data._elementSymbolSeparator + "\"" + mutantId + "\"");
                } else {
                    mapAll.put(programName, "\"" + mutantId + "\"");
                }
                switch (prediction) {
                    case "tp":
                        tp++;
                        if (mapPredPos.containsKey(programName)) {
                            mapPredPos.replace(programName, mapPredPos.get(programName) + data._elementSymbolSeparator + "\"" + mutantId + "\"");
                        } else {
                            mapPredPos.put(programName, "\"" + mutantId + "\"");
                        }
                        if (mapTruePos.containsKey(programName)) {
                            mapTruePos.replace(programName, mapTruePos.get(programName) + data._elementSymbolSeparator + "\"" + mutantId + "\"");
                        } else {
                            mapTruePos.put(programName, "\"" + mutantId + "\"");
                        }
                        break;
                    case "fn":
                        fn++;
                        if (mapPredNeg.containsKey(programName)) {
                            mapPredNeg.replace(programName, mapPredNeg.get(programName) + data._elementSymbolSeparator + "\"" + mutantId + "\"");
                        } else {
                            mapPredNeg.put(programName, "\"" + mutantId + "\"");
                        }
                        if (mapFalseNeg.containsKey(programName)) {
                            mapFalseNeg.replace(programName, mapFalseNeg.get(programName) + data._elementSymbolSeparator + "\"" + mutantId + "\"");
                        } else {
                            mapFalseNeg.put(programName, "\"" + mutantId + "\"");
                        }
                        break;
                    case "tn":
                        tn++;
                        if (mapPredNeg.containsKey(programName)) {
                            mapPredNeg.replace(programName, mapPredNeg.get(programName) + data._elementSymbolSeparator + "\"" + mutantId + "\"");
                        } else {
                            mapPredNeg.put(programName, "\"" + mutantId + "\"");
                        }
                        if (mapTrueNeg.containsKey(programName)) {
                            mapTrueNeg.replace(programName, mapTrueNeg.get(programName) + data._elementSymbolSeparator + "\"" + mutantId + "\"");
                        } else {
                            mapTrueNeg.put(programName, "\"" + mutantId + "\"");
                        }
                        break;
                    case "fp":
                        fp++;
                        if (mapPredPos.containsKey(programName)) {
                            mapPredPos.replace(programName, mapPredPos.get(programName) + data._elementSymbolSeparator + "\"" + mutantId + "\"");
                        } else {
                            mapPredPos.put(programName, "\"" + mutantId + "\"");
                        }
                        if (mapFalsePos.containsKey(programName)) {
                            mapFalsePos.replace(programName, mapFalsePos.get(programName) + data._elementSymbolSeparator + "\"" + mutantId + "\"");
                        } else {
                            mapFalsePos.put(programName, "\"" + mutantId + "\"");
                        }
                        break;
                }
            }

            HashMap<String, String> mapPerformanceMetrics = GetPerformanceMetrics(tp, tn, fp, fn);
            switch (considerIrrelevantChanges) {
                case "asnegatives":
                    modelName = modelName + "-irrelevantchangesasnegatives";
                    break;
                case "aspositives":
                    modelName = modelName + "-irrelevantchangesaspositives";
                    break;
                default:
                    modelName = modelName + "-discardingirrelevantchanges";
                    break;
            }
            modelName = reverse ? modelName + "-reverse" : modelName;
            mapPerformanceMetrics.put(data._modelColName, modelName);

            double irrelevantChangesPercentage = (totalSeqWithIrrelevantChanges * 100) / totalSeq;
            mapPerformanceMetrics.put(data._IrrelevantChangesPercentageColName, new DecimalFormat("###.##").format(irrelevantChangesPercentage));

            {
                String resultMapWithMutantIdFileName = data._mutantIdBasedScoresDatasetDirectory + "_" + modelName + ".txt";
                String fileDirectoryPath = data._datasetPath + "/" + data.strSmpForTest + "/" + data._sequencesDatasetDirectory + "-" + strDatasetNum // data._generatedSequencesDatasetDirectory 
                        + "/" + data._mutantIdBasedScoresDatasetDirectory;
                DeleteFile(fileDirectoryPath + "/" + resultMapWithMutantIdFileName);
                for (String commitId : mapAll.keySet()) {
                    listResultMapWithMutantId.add("\"" + commitId + "_all\"" + data._focussedMutantInInfoFileSeparator + mapAll.get(commitId));
                }
                for (String commitId : mapPredPos.keySet()) {
                    listResultMapWithMutantId.add("\"" + commitId + "_predictedpositives\"" + data._focussedMutantInInfoFileSeparator + mapPredPos.get(commitId));
                }
                for (String commitId : mapPredNeg.keySet()) {
                    listResultMapWithMutantId.add("\"" + commitId + "_predictednegatives\"" + data._focussedMutantInInfoFileSeparator + mapPredNeg.get(commitId));
                }
                for (String commitId : mapTruePos.keySet()) {
                    listResultMapWithMutantId.add("\"" + commitId + "_truepositives\"" + data._focussedMutantInInfoFileSeparator + mapTruePos.get(commitId));
                }
                for (String commitId : mapTrueNeg.keySet()) {
                    listResultMapWithMutantId.add("\"" + commitId + "_truenegatives\"" + data._focussedMutantInInfoFileSeparator + mapTrueNeg.get(commitId));
                }
                for (String commitId : mapFalsePos.keySet()) {
                    listResultMapWithMutantId.add("\"" + commitId + "_falsepositives\"" + data._focussedMutantInInfoFileSeparator + mapFalsePos.get(commitId));
                }
                for (String commitId : mapFalseNeg.keySet()) {
                    listResultMapWithMutantId.add("\"" + commitId + "_falsenegatives\"" + data._focussedMutantInInfoFileSeparator + mapFalseNeg.get(commitId));
                }
                WriteListToFile(fileDirectoryPath, resultMapWithMutantIdFileName, listResultMapWithMutantId);

            }

            return mapPerformanceMetrics;
        } catch (Exception ex) {
            System.err.println("Error | util.GetPerformanceScoreForAllMutantsWithIdMapping()");
            throw ex;
        }
    }

    HashMap<String, Object> GetPrediction(String lhs, String rhs, String genrhs, String considerIrrelevantChanges,
            String labelAbbrFocussedMutant, String labelAbbrUnfocussedMutant) throws Exception {
        try {
            HashMap<String, Object> returnObj = new HashMap();
            String prediction = "";
            Boolean irrelevantChange = false;
            String mutOprType = lhs.substring(lhs.indexOf(data._mutOperatorTypeStartAbbr), lhs.indexOf(data._mutOperatorTypeStopAbbr) + data._mutOperatorTypeStopAbbr.length());
            String strBeforemutOprType = lhs.substring(0, lhs.indexOf(mutOprType));
            String label = rhs.substring(rhs.indexOf(data._mutOperatorTypeStopAbbr) + data._mutOperatorTypeStopAbbr.length(),
                    rhs.indexOf(data._mutOperatorTypeStopAbbr) + data._mutOperatorTypeStopAbbr.length() + labelAbbrUnfocussedMutant.length());
            Boolean predictedPositive = false;
            if (genrhs.contains(strBeforemutOprType + mutOprType) == false) {
                if (genrhs.contains(mutOprType)) {
                    //experimental
                    int indexOfMutOprType = genrhs.indexOf(mutOprType);
                    int lengthOfMutOprType = (mutOprType).length();
                    String predictedLabel = genrhs.substring(indexOfMutOprType + lengthOfMutOprType,
                            indexOfMutOprType + lengthOfMutOprType + labelAbbrUnfocussedMutant.length());
                    predictedPositive = predictedLabel.equals(labelAbbrFocussedMutant) ? true : false;
                } else {
                    switch (considerIrrelevantChanges) {
                        case "aspositives":
                            irrelevantChange = true;
                            predictedPositive = true;
                            break;
                        default:
                            irrelevantChange = true;
                            break;
                    }
                }
            } else {
                String predictedLabel = genrhs.substring(genrhs.indexOf(strBeforemutOprType + mutOprType) + (strBeforemutOprType + mutOprType).length(),
                        genrhs.indexOf(strBeforemutOprType + mutOprType) + (strBeforemutOprType + mutOprType).length() + labelAbbrUnfocussedMutant.length());
                predictedPositive = predictedLabel.equals(labelAbbrFocussedMutant) ? true : false;
            }

            if (label.equals(labelAbbrFocussedMutant) && predictedPositive) {
                prediction = "tp";
            } else if (label.equals(labelAbbrFocussedMutant) && predictedPositive == false) {
                prediction = "fn";
            } else if (label.equals(labelAbbrUnfocussedMutant) && predictedPositive == false) {
                prediction = "tn";
            } else if (label.equals(labelAbbrUnfocussedMutant) && predictedPositive) {
                prediction = "fp";
            }
            returnObj.put("prediction", prediction);
            returnObj.put("irrelevantchange", irrelevantChange);
            return returnObj;
        } catch (Exception ex) {
            System.out.println("Error | util.GetPrediction()");
            ex.printStackTrace();
            throw ex;
        }
    }

    private HashMap<String, String> GetPerformanceMetrics(Integer tPo, Integer tNe, Integer fPo, Integer fNe) throws Exception {
        try {
            HashMap<String, String> mapMetrics = new HashMap();
            double tP = tPo;
            double tN = tNe;
            double fP = fPo;
            double fN = fNe;
            double total = tP + tN + fP + fN;
            double accuracy = total == 0 ? 0 : (tN + tP) / total;
            double precision = 0;
            double recall = 0;
            double f1 = 0;
            double mcc = -1;
            if (tP == 0) {
                precision = 0;
                recall = 0;
                f1 = 0;
            } else {
                precision = tP / (tP + fP);
                recall = tP / (tP + fN);
                f1 = (2 * precision * recall) / (precision + recall);
            }
            mcc = GetMCC(tP, tN, fP, fN);
            mapMetrics.put(data._accuracyColName, new DecimalFormat("###.##").format(accuracy));
            mapMetrics.put(data._precisionColName, new DecimalFormat("###.##").format(precision));
            mapMetrics.put(data._recallColName, new DecimalFormat("###.##").format(recall));
            mapMetrics.put(data._f1ColName, new DecimalFormat("###.##").format(f1));
            mapMetrics.put(data._mccColName, new DecimalFormat("###.##").format(mcc));
            mapMetrics.put(data._tpColName, Integer.toString(tPo));
            mapMetrics.put(data._tnColName, Integer.toString(tNe));
            mapMetrics.put(data._fpColName, Integer.toString(fPo));
            mapMetrics.put(data._fnColName, Integer.toString(fNe));
            return mapMetrics;
        } catch (Exception ex) {
            System.err.println("Error | util.GetPerformanceMetrics()");
            throw ex;
        }
    }

    private double GetMCC(double tPo, double tNe, double fPo, double fNe) throws Exception {
        try {
            double tp = tPo;
            double tn = tNe;
            double fp = fPo;
            double fn = fNe;
            double mcc = -1;
            double denominator = Math.sqrt((tp + fp) * (fn + tn) * (fp + tn) * (tp + fn));
            if (denominator == Double.NaN) {
                mcc = -1;
            } else {
                denominator = denominator == 0 ? 1 : denominator;
                mcc = (tp * tn - fp * fn) / denominator;
            }
            return mcc;
        } catch (Exception ex) {
            System.err.println("Error | util.GetMCC()");
            throw ex;
        }
    }

    public void WriteArrayListToCSV(String filePath, String fileName, ArrayList<HashMap<String, String>> fileContent) throws Exception {
        try {
            if (CreateDirectory(filePath)) {
                FileWriter writer;
                writer = new FileWriter(filePath + "/" + fileName, false);  //True = Append to file, false = Overwrite
                if (fileContent.size() <= 0) {
                    return;
                }
                for (String key : fileContent.get(0).keySet()) {
                    writer.write(key);
                    writer.write(data._elementSymbolSeparator);
                }
                writer.write("\r\n");
                for (int i = 0; i < fileContent.size(); i++) {
                    HashMap<String, String> verScores = fileContent.get(i);
                    for (String score : verScores.values()) {
                        writer.write(score);
                        writer.write(data._elementSymbolSeparator);
                    }
                    writer.write("\r\n");
                }
                writer.close();
            }
        } catch (Exception ex) {
            System.err.println("Error | util.WriteArrayListToCSV()");
            throw ex;
        }
    }

    public HashMap<String, LinkedList<String>> GetExistingTrainEvalTestMap(String seqDatasetDirectory) throws Exception {
        try {
            HashMap<String, LinkedList<String>> mapExistingTrainEvalTestMap = new HashMap();
            LinkedList<String> listTrainEvalTestMap = ReadFileToList(seqDatasetDirectory + "/" + data._trainEvalTestMappingFileName);
            for (String line : listTrainEvalTestMap) {
                String[] arrayLine = line.split(Pattern.quote(data._elementSymbolSeparator));
                String key = arrayLine[0];
                LinkedList<String> listValues = new LinkedList();
                for (int i = 1; i < arrayLine.length; i++) {
                    listValues.add(arrayLine[i]);
                }
                mapExistingTrainEvalTestMap.put(key, listValues);
            }
            return mapExistingTrainEvalTestMap;
        } catch (Exception ex) {
            System.err.println("Error | util.GetExistingTrainEvalTestMap()");
            throw ex;
        }
    }

    String ConvertListToString(LinkedList<String> list) throws Exception {
        try {
            String returnString = "";
            for (String str : list) {
                if (returnString.isEmpty()) {
                    returnString = str;
                } else {
                    returnString += data._nextLineSeparator + str;
                }
            }
            return returnString;
        } catch (Exception ex) {
            System.err.println("Error | util.ConvertListToStringUsingSpaceSeparator()");
            throw ex;
        }
    }

    LinkedList<String> ConvertStringToList(String code, String seperator) throws Exception {
        try {
            seperator = seperator == null ? "\r\n" : seperator;
            String[] arraySpaceSepAbsOrigSourceCode = code.split(Pattern.quote(seperator));
            LinkedList<String> returnedList = new LinkedList();
            for (int i = 0; i < arraySpaceSepAbsOrigSourceCode.length; i++) {
                returnedList.add(arraySpaceSepAbsOrigSourceCode[i]);
            }
            return returnedList;
        } catch (Exception ex) {
            System.err.println("Error | util.ConvertStringToList()");
            throw ex;
        }
    }

    void WriteAbstractedCodeFileAndMapping(File codefilesFolder, String pathExtension) throws Exception {
        try {
            for (File sourceCodeFile : codefilesFolder.listFiles()) {
                String sourceCodeFileName = sourceCodeFile.getName();
                String sourceCodeFilePath = sourceCodeFile.getPath();
                if (sourceCodeFileName.matches(data._sourceCodeFileExtension) == false) {
                    continue;
                }
                if (data._logging) {
                    System.out.println("processing " + pathExtension + "/" + sourceCodeFileName);
                }
                String abstractedSourceCodeDirectoryPath = data._datasetPath + "/" + data._abstractedMutantsDirectory + "/" + pathExtension;
                String abstractedSourceCodeFileName = sourceCodeFileName.replace(data._srcmlCodeFileExtension, "_" + data._abstractedFileNameExtension + data._srcmlCodeFileExtension);
                String abstractionMappingFileName = sourceCodeFileName.replace(data._srcmlCodeFileExtension, "_" + data._abstractionMappingFileNameExtension);
                if (FileExists(abstractedSourceCodeDirectoryPath + "/" + abstractedSourceCodeFileName)) {
                    continue;
                }
                Boolean handled = false;
                String sourceCode = ConvertListToString(ReadFileToList(sourceCodeFilePath));
                String interimFolderName = codefilesFolder.getName();
                File grandparentDirectory = codefilesFolder.getParentFile().getParentFile();
                for (File someDirectory : grandparentDirectory.listFiles()) {
                    String existingCodeFilePath = someDirectory.getPath() + "/" + interimFolderName + "/" + sourceCodeFileName;
                    if (FileExists(existingCodeFilePath) == false) {
                        continue;
                    }
                    String existingCode = ConvertListToString(ReadFileToList(existingCodeFilePath));
                    if (existingCode.equals(sourceCode) == false) {
                        continue;
                    }
                    String existingAbstractedSourceCodeDirectoryPath = data._datasetPath + "/" + data._abstractedMutantsDirectory + "/" + someDirectory.getName() + "/" + interimFolderName;
                    String existingAbstractedSourceCodeFilePath = existingAbstractedSourceCodeDirectoryPath + "/" + abstractedSourceCodeFileName;
                    String existingAbstractionMappingFilePath = existingAbstractedSourceCodeDirectoryPath + "/" + abstractionMappingFileName;
                    if (FileExists(existingAbstractedSourceCodeFilePath) == false || FileExists(existingAbstractionMappingFilePath) == false) {
                        continue;
                    }
                    LinkedList<String> existingAbstractedSourceCodeList = ReadFileToList(existingAbstractedSourceCodeFilePath);
                    LinkedList<String> existingAbstractionMappingList = ReadFileToList(existingAbstractionMappingFilePath);
                    if (data._logging) {
                        System.out.println("Copying files from " + existingAbstractedSourceCodeDirectoryPath + " to " + abstractedSourceCodeDirectoryPath);
                    }
                    WriteListToFile(abstractedSourceCodeDirectoryPath, abstractedSourceCodeFileName, existingAbstractedSourceCodeList);
                    WriteListToFile(abstractedSourceCodeDirectoryPath, abstractionMappingFileName, existingAbstractionMappingList);
                    handled = true;
                    break;
                }
                if (handled == false) {
                    String originalEssentialXML = GetEssentialXML(sourceCodeFilePath);
                    if (originalEssentialXML == null || originalEssentialXML.isEmpty()) {
                        continue;
                    }
                    HashMap<String, String> mapUVariableAbstraction = null;
                    String existingAbstractionMappingFileName = abstractionMappingFileName.contains("_After")
                            ? abstractionMappingFileName.replace("_After", "_Before")
                            : (abstractionMappingFileName.contains("_Before") ? abstractionMappingFileName.replace("_Before", "_After") : abstractionMappingFileName);
                    if (FileExists(abstractedSourceCodeDirectoryPath + "/" + existingAbstractionMappingFileName)) {
                        LinkedList<String> listUVariableAbstraction = ReadFileToList(abstractedSourceCodeDirectoryPath + "/" + existingAbstractionMappingFileName);
                        mapUVariableAbstraction = ConvertListToMap(listUVariableAbstraction, data._abstractionMappingSeparator);
                    }
                    String abstractedEssentialXML = AbstractXML(originalEssentialXML, mapUVariableAbstraction);
                    String tempFileName = sourceCodeFileName.replace(data._srcmlCodeFileExtension, "_temp" + data._srcmlXMLFileExtension);
                    String abstractedSourceCode = ConvertsrcMLToString(abstractedSourceCodeDirectoryPath, tempFileName, abstractedEssentialXML);
                    WriteStringToFile(abstractedSourceCodeDirectoryPath, abstractedSourceCodeFileName, abstractedSourceCode);

                    mapUVariableAbstraction = ReturnMapUVariableAbstraction();
                    LinkedList<String> listUVariableAbstraction = ConvertMapToList(mapUVariableAbstraction, data._abstractionMappingSeparator);
                    WriteListToFile(abstractedSourceCodeDirectoryPath, abstractionMappingFileName, listUVariableAbstraction);
                }
            }
        } catch (Exception ex) {
            System.err.println("Error | util.WriteAbstractedCodeFileAndMapping()");
            throw ex;
        }
    }

    void WriteSequencesFileAndMapping(File codefilesFolder, String pathExtension) throws Exception {
        try {
            for (File sourceCodeFile : codefilesFolder.listFiles()) {
                String sourceCodeFileName = sourceCodeFile.getName();
                String sourceCodeFilePath = sourceCodeFile.getPath();
                if (sourceCodeFile.getName().matches(data._sourceCodeFileExtension) == false) {
                    continue;
                }
                if (data._logging) {
                    System.out.println("util.WriteSequencesFileAndMapping() | " + sourceCodeFilePath);
                }
                String abstractedSourceCodeDirectoryPath = data._datasetPath + "/" + data._abstractedMutantsDirectory + "/" + pathExtension;
                String origSourceCodeFileNameWithoutExt = sourceCodeFile.getName().replace(data._srcmlCodeFileExtension, "");
                String abstractedSourceCodeFileName = sourceCodeFile.getName().replace(data._srcmlCodeFileExtension, "_" + data._abstractedFileNameExtension + data._srcmlCodeFileExtension);

                String commitSeqDataDirectoryPath = data._datasetPath + "/" + data._generatedSequencesDirectory + "/" + pathExtension;
                String seqFileName = origSourceCodeFileNameWithoutExt + "_" + data._sequenceFileNameExtension;
                String mapFileName = origSourceCodeFileNameWithoutExt + "_" + data._seqMappingFileNameExtension;

                if (FileExists(commitSeqDataDirectoryPath + "/" + mapFileName)
                        && FileExists(commitSeqDataDirectoryPath + "/" + seqFileName) == false) {
                    continue;
                }
                if (FileExists(abstractedSourceCodeDirectoryPath + "/" + abstractedSourceCodeFileName) == false) {
                    System.out.println("Either mapping or the abstracted original source code file or both is/are missing for " + sourceCodeFile.getName());
                    throw new Exception("Missing mapping/oiginal abstracted source-code file.");
                }
                LinkedList<String> listTrimAbsOrigSourceCode = ReadFileToList(abstractedSourceCodeDirectoryPath + "/" + abstractedSourceCodeFileName);
                GetSequenceMappingToOriginalCode(pathExtension, origSourceCodeFileNameWithoutExt, listTrimAbsOrigSourceCode);
            }
        } catch (Exception ex) {
            System.err.println("Error | util.WriteSequencesFileAndMapping()");
            ex.printStackTrace();
            throw ex;
        }
    }

    HashMap<Integer, Integer> LoadMapIndices(String abstCodeCommitDirectoryPath, String indicesFileName) throws Exception {
        try {
            HashMap<Integer, Integer> mapOrigToAbstSentence = new HashMap();
            if (FileExists(abstCodeCommitDirectoryPath + "/" + indicesFileName) == false) {
                return mapOrigToAbstSentence;
            }
            LinkedList<String> listIndices = ReadFileToList(abstCodeCommitDirectoryPath + "/" + indicesFileName);
            for (String str : listIndices) {
                String[] arrStr = str.split(Pattern.quote(data._elementSymbolSeparator));
                String key = arrStr[0];
                String value = arrStr[1];
                if (mapOrigToAbstSentence.containsKey(key) == false) {
                    mapOrigToAbstSentence.put(Integer.valueOf(key), Integer.valueOf(value));
                }
            }
            return mapOrigToAbstSentence;
        } catch (Exception ex) {
            System.err.println("Error | util.LoadMapIndices()");
            ex.printStackTrace();
            throw ex;
        }
    }

    void MatchAndSaveJsons(String dirSimulation, String strDLJsonFileName, String strMLJsonFileName) {
        try {
            HashMap<Integer, mutant> mapMutants = new HashMap();

            //read ML json
            JsonParser jsonParser = new JsonParser();
            FileReader reader = new FileReader(dirSimulation + "/" + strMLJsonFileName);
            Object obj = jsonParser.parse(reader);
            JsonObject objMLJson = (JsonObject) obj;

            //read DL json
            jsonParser = new JsonParser();
            reader = new FileReader(dirSimulation + "/" + strDLJsonFileName);
            obj = jsonParser.parse(reader);
            JsonObject objDLJson = (JsonObject) obj;

            HashMap<String, HashMap<String, String>> mapML = new HashMap();
            for (Entry<String, JsonElement> entry : objMLJson.entrySet()) {
                String strProjectName = entry.getKey();
                JsonObject jsonObject = entry.getValue().getAsJsonObject();
                HashMap<String, String> mapForProject = new HashMap();
                for (Entry<String, JsonElement> innerEntry : jsonObject.entrySet()) {
                    mapForProject.put(innerEntry.getKey(), innerEntry.getValue().getAsString());
                }
                mapML.put(strProjectName, mapForProject);
            }

            HashMap<String, HashMap<String, String>> mapDL = new HashMap();
            for (Entry<String, JsonElement> entry : objDLJson.entrySet()) {
                String strProjectName = entry.getKey();
                JsonArray jsonArray = entry.getValue().getAsJsonArray();
                HashMap<String, String> mapForProject = new HashMap();
                for (int i = 0; i < jsonArray.size(); i++) {
                    mapForProject.put(jsonArray.get(i).getAsString(), jsonArray.get(i).getAsString());
                }
                mapDL.put(strProjectName, mapForProject);
            }

            //cross-checking on basis of key
            for (String strProject : mapML.keySet()) {
                HashMap<String, String> mapForProjectML = mapML.get(strProject);
                String strKeyForDL = strProject + "_all";
                HashMap<String, String> mapForProjectDL = mapDL.get(strKeyForDL);

                for (String strMutantInML : mapForProjectML.keySet()) {
                    if (mapForProjectDL.containsKey(strMutantInML) == false) {
                        mapForProjectDL.put(strMutantInML, strMutantInML);
                        System.out.println("addition in DL: " + strKeyForDL + "-" + strMutantInML);
                    }
                }
                mapDL.replace(strKeyForDL, mapForProjectDL);

                for (String strMutantInDL : mapForProjectDL.keySet()) {
                    if (mapForProjectML.containsKey(strMutantInDL) == false) {
                        mapForProjectML.put(strMutantInDL, "0");
                        System.out.println("addition in ML: " + strProject + "-" + strMutantInDL);
                    }
                }
                mapML.replace(strProject, mapForProjectML);
            }

            System.out.println("writing " + dirSimulation + "/new_" + strMLJsonFileName);
            LinkedList<String> lstML = new LinkedList();
            for (String strProject : mapML.keySet()) {
                String strToBeAdded = "";
                if (lstML.isEmpty()) {
                    lstML.add("{");
                    strToBeAdded = "\"" + strProject + "\"" + ":{";
                } else {
                    strToBeAdded = "," + "\"" + strProject + "\"" + ":{";
                }
                HashMap<String, String> mapForProjectML = mapML.get(strProject);
                String innerStrToBeAdded = "";
                for (String strMutantInML : mapForProjectML.keySet()) {
                    if (innerStrToBeAdded.isEmpty()) {
                        innerStrToBeAdded = "\"" + strMutantInML + "\"" + ":" + mapForProjectML.get(strMutantInML);
                    } else {
                        innerStrToBeAdded += "," + "\"" + strMutantInML + "\"" + ":" + mapForProjectML.get(strMutantInML);
                    }
                }
                strToBeAdded += innerStrToBeAdded + "}";
                lstML.add(strToBeAdded);
            }
            lstML.add("}");
            WriteListToFile(dirSimulation, "new_" + strMLJsonFileName, lstML);

            System.out.println("writing " + dirSimulation + "/new_" + strDLJsonFileName);
            LinkedList<String> lstDL = new LinkedList();
            for (String strProject : mapDL.keySet()) {
                String strToBeAdded = "";
                if (lstDL.isEmpty()) {
                    lstDL.add("{");
                    strToBeAdded = "\"" + strProject + "\"" + ":[";
                } else {
                    strToBeAdded = "," + "\"" + strProject + "\"" + ":[";
                }
                HashMap<String, String> mapForProjectDL = mapDL.get(strProject);
                String innerStrToBeAdded = "";
                for (String strMutantInDL : mapForProjectDL.keySet()) {
                    if (innerStrToBeAdded.isEmpty()) {
                        innerStrToBeAdded = "\"" + strMutantInDL + "\"";
                    } else {
                        innerStrToBeAdded += "," + "\"" + strMutantInDL + "\"";
                    }
                }
                strToBeAdded += innerStrToBeAdded + "]";
                lstDL.add(strToBeAdded);
            }
            lstDL.add("}");
            WriteListToFile(dirSimulation, "new_" + strDLJsonFileName, lstDL);

        } catch (Exception ex) {
            System.out.println("error at util.MatchAndSaveJsons()");
            ex.printStackTrace();
        }
    }
}
