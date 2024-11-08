package hexlet.code.formatter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Plain {
    private static final String OLD = "old";
    private static final String NEW = "new";

    public static String getPlain(Map<String, Map<String, Object>> list) {
        List<String> result = new ArrayList<>();

        list.forEach((key, value) -> {
            if (value.containsKey(NEW) && value.containsKey(OLD)) {
                result.add("Property '"
                        + key
                        + "' was updated."
                        + " From " + filters(value.get(OLD))
                        + " to " + filters(value.get(NEW)));
            } else if (value.containsKey(OLD)) {
                result.add("Property '" + key + "' was removed");
            } else if (value.containsKey(NEW)) {
                result.add("Property '" + key + "' was added with value: " + filters(value.get(NEW)));
            }
        });

        return String.join("\n", result);
    }

    public static String filters(Object value) {
        if (value instanceof Object[] || value instanceof List || value instanceof Map) {
            return "[complex value]";
        } else if (value == null) {
            return "null";
        } else if (value instanceof Boolean) {
            return value.toString();
        } else if (value instanceof String) {
            return "'" + value + "'";
        }
        return value.toString();
    }
}
