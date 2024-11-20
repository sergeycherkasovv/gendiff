package hexlet.code.formatter;

import hexlet.code.FileDifferences;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Stylish {
    private static final Integer COUNT_EMPTY_LINE = 2;

    public static String getStylish(List<Map<String, Object>> list) throws RuntimeException {
        List<String> result = new ArrayList<>();
        var emptyString = " ".repeat(COUNT_EMPTY_LINE);

        result.add("{");
        for (Map<String, Object> map: list) {
            var status = map.get(FileDifferences.STATUS).toString();
            var plus = emptyString + "+ " + map.get(FileDifferences.KEY) + ": " + map.get(FileDifferences.VALUE_SECOND);
            var minus = emptyString + "- " + map.get(FileDifferences.KEY) + ": " + map.get(FileDifferences.VALUE_ONE);
            var same = emptyString.repeat(COUNT_EMPTY_LINE)
                    + map.get(FileDifferences.KEY)
                    + ": "
                    + map.get(FileDifferences.VALUE_SECOND);

            var key = map.get(FileDifferences.KEY);
            var value1 = map.get(FileDifferences.VALUE_ONE);
            var value2 = map.get(FileDifferences.VALUE_SECOND);

            switch (status) {
                case FileDifferences.DELETED -> result.add(String.format("  - %s: %s", key, value1));
                case FileDifferences.NEW -> result.add(String.format("  + %s: %s", key, value2));
                case FileDifferences.SAME -> result.add(String.format("    %s: %s", key, value2));
                case FileDifferences.CHANGED -> {
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
