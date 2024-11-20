package hexlet.code.formatter;

import hexlet.code.constants.Keys;
import hexlet.code.constants.Status;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Stylish {

    public static String getStylish(List<Map<Object, Object>> list) throws RuntimeException {
        List<String> result = new ArrayList<>();

        result.add("{");
        for (Map<Object, Object> map: list) {
            var key = map.get(Keys.KEY);

            switch (map.get(Status.STATUS)) {
                case Status.DELETED -> result.add(String.format("  - %s: %s", key, map.get(Keys.VALUE_ONE)));
                case Status.NEW -> result.add(String.format("  + %s: %s", key, map.get(Keys.VALUE_SECOND)));
                case Status.SAME -> result.add(String.format("    %s: %s", key, map.get(Keys.VALUE_SECOND)));
                case Status.CHANGED -> {
                    result.add(String.format("  - %s: %s", key, map.get(Keys.VALUE_ONE)));
                    result.add(String.format("  + %s: %s", key, map.get(Keys.VALUE_SECOND)));
                }
                default -> throw new RuntimeException("This " + map.get(Status.STATUS) + " was not found");
            }
        }
        result.add("}");

        return String.join("\n", result);
    }
}
