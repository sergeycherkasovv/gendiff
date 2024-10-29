package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLGenerator;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {
    public static Map<String, Object> run(String fileName) throws Exception {
        var read = ReadFile.readFilePath(fileName);
        if(fileName.contains(".yml")) {
            return parseYaml(read);
        }
        if(fileName.contains(".json")) {
            return parseJson(read);
        }
        return Map.of();
    }
    public static Map<String, Object> parseYaml(String fileName) throws Exception {
        ObjectMapper mapper = new YAMLMapper();
        Map<String, Object> map = mapper.readValue(fileName, new TypeReference<Map<String, Object>>() {
        });
        return map;
    }
    public static Map<String, Object> parseJson(String fileName) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(fileName, new TypeReference<Map<String, Object>>() {
        });
        return map;
    }
}
