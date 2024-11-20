package hexlet.code.formatter;

import hexlet.code.FileDifferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String getPlain(List<Map<String, Object>> list) throws RuntimeException {
        List<String> result = new ArrayList<>();

        for (Map<String, Object> map : list) {
            var status = map.get(FileDifferences.STATUS).toString();
            var key = map.get(FileDifferences.KEY);

            switch (status) {
                case FileDifferences.DELETED -> result.add("Property '" + key + "' was removed");
                case FileDifferences.NEW -> result.add("Property '"
                                                    + key
                                                    + "' was added with value: "
                                                    + getConvertedValue(map.get(FileDifferences.VALUE_SECOND)));
                case FileDifferences.CHANGED -> result.add("Property '"
                                                        + key
                                                        + "' was updated."
                                                        + " From "
                                                        + getConvertedValue(map.get(FileDifferences.VALUE_ONE))
                                                        + " to "
                                                        + getConvertedValue(map.get(FileDifferences.VALUE_SECOND)));
                case FileDifferences.SAME -> { }
                default -> throw new RuntimeException("This status was not found");
            }
        }

        return String.join("\n", result);
    }

    public static String getConvertedValue(Object value) {
        if (value instanceof Object[] || value instanceof List || value instanceof Map) {
            return "[complex value]";
        } else if (value == null) {
            return "null";
        } else if (value instanceof String) {
            return "'" + value + "'";
        }
        return value.toString();
    }
}
