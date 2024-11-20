package hexlet.code.formatter;

import hexlet.code.DiffConst;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Plain {
    public static String getPlain(List<Map<Object, Object>> list) throws RuntimeException {
        List<String> result = new ArrayList<>();

        for (Map<Object, Object> map : list) {
            var status = map.get(DiffConst.STATUS);
            var key = map.get(DiffConst.KEY);
            var value1 = map.get(DiffConst.VALUE_ONE);
            var value2 = map.get(DiffConst.VALUE_SECOND);

            switch (status) {
                case DiffConst.DELETED -> result.add("Property '" + key + "' was removed");
                case DiffConst.NEW -> result.add("Property '"
                                                    + key
                                                    + "' was added with value: "
                                                    + getConvertedValue(value2));
                case DiffConst.CHANGED -> result.add("Property '"
                                                        + key
                                                        + "' was updated."
                                                        + " From "
                                                        + getConvertedValue(value1)
                                                        + " to "
                                                        + getConvertedValue(value2));
                case DiffConst.SAME -> { }
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
