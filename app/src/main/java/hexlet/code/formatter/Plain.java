package hexlet.code.formatter;

import hexlet.code.DifferFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String getPlain(List<Map<String, Object>> list) {
        List<String> result = new ArrayList<>();

        for (Map<String, Object> map : list ) {
            var status = map.get(DifferFilter.STATUS).toString();
            var key = map.get(DifferFilter.KEY);

            switch (status) {
                case DifferFilter.DELETED -> result.add("Property '" + key + "' was removed");
                case DifferFilter.NEW -> result.add("Property '"
                                                    + key
                                                    + "' was added with value: "
                                                    + filters(map.get(DifferFilter.VALUE_SECOND)));
                case DifferFilter.CHANGED -> result.add("Property '"
                                                        + key
                                                        + "' was updated."
                                                        + " From " + filters(map.get(DifferFilter.VALUE_ONE))
                                                        + " to " + filters(map.get(DifferFilter.VALUE_SECOND)));
                case DifferFilter.SAME -> {}
                default -> throw new RuntimeException("This status was not found");
            }
        }

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
