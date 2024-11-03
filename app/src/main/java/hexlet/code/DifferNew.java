package hexlet.code;

import hexlet.code.formatter.Stylish;

import java.util.*;
import java.util.stream.Collectors;

public class DifferNew {
    private static final String MINUS = "-";
    private static final String PLUS = "+";

    public static String generate(String filepath1,
                                  String filepath2,
                                  String formatName) throws Exception {
        var fileParse1 = Parser.run(filepath1);
        var fileParse2 = Parser.run(filepath2);

        if (fileParse1.isEmpty() || fileParse2.isEmpty()) {
            throw new Exception();
        }

        var result = generateConstuctor(fileParse1, fileParse2);
        return Stylish.stylish(result);
    }

    public static String generate(String filepath1,
                                  String filepath2) throws Exception {
        return generate(filepath1, filepath2, "String formatName");
    }


    public static Map<String, Map<String, Object>> generateConstuctor(Map<String, Object> filePath1,
                                                                       Map<String, Object> filePath2) {
        Map<String, Map<String, Object>> result = new HashMap<>();

        List<String> listKey = new ArrayList<>(filePath1.keySet());
        listKey.addAll(filePath2.keySet());

        listKey.stream()
                .distinct()
                .sorted()
                .forEach(key -> {
                    Map<String, Object> map = new HashMap<>();
                    if (filePath1.containsValue(filePath2.get(key)) && filePath2.containsValue(filePath1.get(key))){
                        map.put(" ", filePath1.get(key));
                        result.put(key, map);
                    } else if (filePath1.containsKey(key) && filePath2.containsKey(key)) {
                        map.put(MINUS, filePath1.get(key));
                        map.put(PLUS, filePath2.get(key));
                        result.put(key, map);
                    } else if (filePath1.containsKey(key)) {
                        map.put(MINUS, filePath1.get(key));
                        result.put(key, map);
                    } else if (filePath2.containsKey(key)) {
                        map.put(PLUS, filePath2.get(key));
                        result.put(key, map);
                    }
                });
        return result;
    }
}
