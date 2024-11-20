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
            var key = map.get(DiffConst.KEY);

            switch (map.get(DiffConst.STATUS)) {
                case DiffConst.DELETED -> result.add(String.format("  - %s: %s", key, map.get(DiffConst.VALUE_ONE)));
                case DiffConst.NEW -> result.add(String.format("  + %s: %s", key, map.get(DiffConst.VALUE_SECOND)));
                case DiffConst.SAME -> result.add(String.format("    %s: %s", key, map.get(DiffConst.VALUE_SECOND)));
                case DiffConst.CHANGED -> {
                    result.add(String.format("  - %s: %s", key, map.get(DiffConst.VALUE_ONE)));
                    result.add(String.format("  + %s: %s", key, map.get(DiffConst.VALUE_SECOND)));
                }
                default -> throw new RuntimeException("This " + map.get(DiffConst.STATUS) + " was not found");
            }
        }
        result.add("}");

        return String.join("\n", result);
    }
}
