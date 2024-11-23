package hexlet.code.formatter;

import com.fasterxml.jackson.databind.ObjectMapper;
import hexlet.code.constants.Keys;

import java.util.List;
import java.util.Map;

public class Json {
    public static String getJson(List<Map<Keys, Object>> list) throws Exception {
        ObjectMapper mapper = new ObjectMapper();
        return mapper.writeValueAsString(list);
    }
}
