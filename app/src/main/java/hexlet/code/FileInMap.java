package hexlet.code;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.Map;

public class FileInMap {
    public static Map<String, Object> objectMapper(String fileName) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        Map<String, Object> map = mapper.readValue(fileName, new TypeReference<Map<String, Object>>() {
        });
        return map;
    }
}
