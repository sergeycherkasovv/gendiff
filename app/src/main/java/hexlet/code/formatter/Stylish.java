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
            if (value.containsKey("+") && value.containsKey("-")) {
                result.add(MINUS + "  " + key + ": " + value.get("-"));
                result.add(PLUS + "  " + key + ": " + value.get("+"));
            } else if(value.containsKey("-")) {
                result.add(MINUS + "  " + key + ": " + value.get("-"));
            } else if (value.containsKey("+")) {
                result.add(PLUS + "  " + key + ": " + value.get("+"));
            }  else {
                result.add("   " + key + ": " + value.get(" "));
            }

        });
        result.add("}");

        return String.join("\n", result);
    }
}
