package hexlet.code;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DifferOld {
    private static final String MINUS = "-";
    private static final String PLUS = "+";

    public static String generate(Map<String, Object> filePath1,
                                  Map<String, Object> filePath2,
                                  String formatName) throws Exception {
        List<String> result = new ArrayList<>();

        List<String> listKey = new ArrayList<>(filePath1.keySet());
        listKey.addAll(filePath2.keySet());

        listKey.stream()
                .distinct()
                .sorted()
                .forEach(key -> {
                    if (filePath1.containsKey(key) && !filePath2.containsKey(key)) {
                        result.add(MINUS + " " + key + ": " + (filePath1.get(key)).toString());
                    } else if (!filePath1.containsKey(key) && filePath2.containsKey(key)) {
                        result.add(PLUS + " " + key + ": " + filePath2.get(key).toString());
                    } else if (filePath1.get(key).equals(filePath2.get(key))) {
                        result.add(" " + " " + key + ": " + filePath1.get(key).toString());
                    } else if (!filePath1.get(key).equals(filePath2.get(key))) {
                        result.add(MINUS + " " + key + ": " + filePath1.get(key).toString());
                        result.add(PLUS + " " + key + ": " + filePath2.get(key).toString());
                    }
                });

        return show(result);
    }

    public static String generate(Map<String, Object> filePath1, Map<String, Object> filePath2) throws Exception {
        return generate(filePath1, filePath2, "String formatName");
    }

    public static String show(List<String> list) {
        var result = new StringBuilder();

        result.append("{");
        list.forEach(item -> {
            result.append("\n");
            result.append("  " + item);
        });
        result.append("\n");
        result.append("}");

        return result.toString();
    }
}
