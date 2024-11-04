package hexlet.code.formatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Stylish {
    private static final String MINUS = "-";
    private static final String PLUS = "+";

    public static String getStylish(Map<String, Map<String, Object>> list) {
        List<String> result = new ArrayList<>();

        result.add("{");
        list.forEach((key, value) -> {
            if (value.containsKey(PLUS) && value.containsKey(MINUS)) {
                result.add(MINUS + "  " + key + ": " + value.get(MINUS));
                result.add(PLUS + "  " + key + ": " + value.get(PLUS));
            } else if (value.containsKey(MINUS)) {
                result.add(MINUS + "  " + key + ": " + value.get(MINUS));
            } else if (value.containsKey(PLUS)) {
                result.add(PLUS + "  " + key + ": " + value.get(PLUS));
            } else {
                result.add("   " + key + ": " + value.get(" "));
            }

        });
        result.add("}");

        return String.join("\n", result);
    }
}
