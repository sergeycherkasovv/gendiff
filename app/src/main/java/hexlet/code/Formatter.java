package hexlet.code;

import hexlet.code.constants.Keys;
import hexlet.code.formatter.Json;
import hexlet.code.formatter.Plain;
import hexlet.code.formatter.Stylish;

import java.util.List;
import java.util.Map;

public class Formatter {
    public static String getFormatter(List<Map<Keys, Object>> differMap, String format) throws Exception {
        return switch (format) {
            case "stylish" -> Stylish.getStylish(differMap);
            case "plain" -> Plain.getPlain(differMap);
            case "json" -> Json.getJson(differMap);
            default -> throw new RuntimeException("Unexpected value: " + format);
        };
    }
}
