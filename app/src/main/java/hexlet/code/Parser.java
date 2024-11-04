package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.yaml.YAMLMapper;

import java.util.Map;

public class Parser {
    public static Map<String, Object> run(String fileName) throws Exception {
        var read = ReadFile.readFilePath(fileName);

        return switch (fileName.substring(fileName.lastIndexOf("."))) {
            case ".json" -> getParse(read, new ObjectMapper());
            case ".yml", ".yaml" -> getParse(read, new YAMLMapper());
            default -> throw new Exception("Unexpected value: "
                    + fileName.substring(fileName.lastIndexOf(".")));
        };
    }

    public static Map<String, Object> getParse(String fileName, ObjectMapper mapper) throws Exception {
        return mapper.readValue(fileName,
                new TypeReference<Map<String, Object>>() {
                });
    }
}
