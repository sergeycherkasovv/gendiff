package hexlet.code.formatter;

import hexlet.code.DifferFilter;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


public class Stylish {
    private static final Integer COUNT_EMPTY_LINE = 2;

    public static String getStylish(List<Map<String, Object>> list) {
        List<String> result = new ArrayList<>();
        var emptyString = " ".repeat(COUNT_EMPTY_LINE);

        result.add("{");
        for (Map<String, Object> map: list) {
            var status = map.get(DifferFilter.STATUS).toString();
            var plus = emptyString + "+ " + map.get(DifferFilter.KEY) + ": " + map.get(DifferFilter.VALUE_SECOND);
            var minus = emptyString + "- " + map.get(DifferFilter.KEY) + ": " + map.get(DifferFilter.VALUE_ONE);
            var same = emptyString.repeat(COUNT_EMPTY_LINE)
                    + map.get(DifferFilter.KEY)
                    + ": "
                    + map.get(DifferFilter.VALUE_SECOND);

            switch (status) {
                case DifferFilter.DELETED -> result.add(minus);
                case DifferFilter.NEW -> result.add(plus);
                case DifferFilter.SAME -> result.add(same);
                case DifferFilter.CHANGED -> { result.add(minus);
                                                result.add(plus); }
                default -> throw new RuntimeException("This status was not found");
            }
        }
        result.add("}");

        return String.join("\n", result);
    }
}
