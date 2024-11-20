package hexlet.code.formatter;

import hexlet.code.DiffConst;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Stylish {

    public static String getStylish(List<Map<Object, Object>> list) throws RuntimeException {
        List<String> result = new ArrayList<>();

        result.add("{");
        for (Map<Object, Object> map: list) {
            var status = map.get(DiffConst.STATUS);
            var key = map.get(DiffConst.KEY);
            var value1 = map.get(DiffConst.VALUE_ONE);
            var value2 = map.get(DiffConst.VALUE_SECOND);

            switch (status) {
                case DiffConst.DELETED -> result.add(String.format("  - %s: %s", key, value1));
                case DiffConst.NEW -> result.add(String.format("  + %s: %s", key, value2));
                case DiffConst.SAME -> result.add(String.format("    %s: %s", key, value2));
                case DiffConst.CHANGED -> {
                    result.add(String.format("  - %s: %s", key, value1));
                    result.add(String.format("  + %s: %s", key, value2));
                }
                default -> throw new RuntimeException("This status was not found");
            }
        }
        result.add("}");

        return String.join("\n", result);
    }
}
