package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class DifferNew {
    private static final String OLD = "old";
    private static final String NEW = "new";
    private static final String INTACT = "intact";

    public static String generate(String filepath1,
                                  String filepath2,
                                  String formatName) throws Exception {
        var fileParse1 = Parser.run(filepath1);
        var fileParse2 = Parser.run(filepath2);

        if (fileParse1.isEmpty()) {
            throw new Exception("The file " + "'" + filepath1 + "'" + " is empty");
        } else if (fileParse2.isEmpty()) {
            throw new Exception("The file " + "'" + filepath2 + "'" + " is empty");
        }

        var result = differFilter(fileParse1, fileParse2);
        return Formatter.formatter(result, formatName);
    }

    public static String generate(String filepath1,
                                  String filepath2) throws Exception {
        return generate(filepath1, filepath2, "stylish");
    }


    public static Map<String, Map<String, Object>> differFilter(Map<String, Object> filePath1,
                                                                Map<String, Object> filePath2) {
        Map<String, Map<String, Object>> result = new TreeMap<>();

        List<String> listKey = new ArrayList<>(filePath1.keySet());
        listKey.addAll(filePath2.keySet());

        listKey.stream()
                .distinct()
                .forEach(key -> {
                    Map<String, Object> map = new HashMap<>();
                    if (filePath1.containsValue(filePath2.get(key)) && filePath2.containsValue(filePath1.get(key))) {
                        map.put(INTACT, filePath2.get(key));
                        result.put(key, map);
                    } else if (filePath1.containsKey(key) && filePath2.containsKey(key)) {
                        map.put(OLD, filePath1.get(key));
                        map.put(NEW, filePath2.get(key));
                        result.put(key, map);
                    } else if (filePath1.containsKey(key)) {
                        map.put(OLD, filePath1.get(key));
                        result.put(key, map);
                    } else if (filePath2.containsKey(key)) {
                        map.put(NEW, filePath2.get(key));
                        result.put(key, map);
                    } else {
                        //map.put(" ", filePath1.get(key));
                        //result.put(key, map);
                    }
                });
        System.out.println(result);
        return result;
    }
}
