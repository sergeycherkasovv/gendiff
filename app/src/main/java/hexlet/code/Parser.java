package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {
    public static Map<String, Object> getParser(String fileRead, String fileFormat) throws Exception {

        return switch (fileFormat) {
            case ".json" -> run(fileRead, new ObjectMapper());
            case ".yml", ".yaml" -> run(fileRead, new YAMLMapper());
            default -> throw new RuntimeException("Unexpected value: "
                    + fileRead.substring(fileRead.lastIndexOf(".")));
        };
    }

    public static Map<String, Object> run(String fileName, ObjectMapper mapper) throws Exception {
        return mapper.readValue(fileName,
                new TypeReference<Map<String, Object>>() {
                });
    }
}
