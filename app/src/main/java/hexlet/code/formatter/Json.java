package hexlet.code.formatter;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.List;
import java.util.Map;

public class Json {
    public static String getJson(List<Map<String, Object>> list) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(list);
    }
}
