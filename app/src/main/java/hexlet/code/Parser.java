package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {
    public static Map<String, Object> getParser(String fileRead, String fileFormat) throws Exception {

        return switch (fileFormat) {
            case ".json" -> getMap(fileRead, new ObjectMapper());
            case ".yml", ".yaml" -> getMap(fileRead, new YAMLMapper());
            default -> {
                throw new RuntimeException("Unexpected format: " + fileFormat);
            }
        };
    }

    public static Map<String, Object> getMap(String fileName, ObjectMapper mapper) throws Exception {
        return mapper.readValue(fileName,
                new TypeReference<Map<String, Object>>() {
                });
    }
}
