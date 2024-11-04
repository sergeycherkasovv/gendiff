package hexlet.code;

import hexlet.code.formatter.Json;
import hexlet.code.formatter.Stylish;

import java.util.Map;

public class Formatter {
    public static String formatter(Map<String, Map<String, Object>> differMap, String format) throws Exception {
        return switch (format) {
            case "stylish" -> Stylish.getStylish(differMap);
            case "plain" -> "Plain.plain";
            case "json" -> Json.getJson(differMap);
            default -> throw new Exception("Unexpected value: " + format);
        };
    }
}
