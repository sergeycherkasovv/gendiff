package hexlet.code;

import java.util.*;

public class DifferFilter {
    private static final String OLD = "old";
    private static final String NEW = "new";
    private static final String UNCHANGED = "unchanged";
    //private static final String UNCHANGED = "unchanged";

    public static Map<String, Map<String, Object>> getDifferFilter(Map<String, Object> filePath1,
                                                                   Map<String, Object> filePath2) {
        Map<String, Map<String, Object>> result = new TreeMap<>();

        List<String> listKey = new ArrayList<>(filePath1.keySet());
        listKey.addAll(filePath2.keySet());

        listKey.stream()
                .distinct()
                .sorted()
                .forEach(key -> {
                    Map<String, Object> map = new HashMap<>();
                    if (Objects.equals(filePath1.get(key), filePath2.get(key))) {
                        //filePath1.containsValue(filePath2.get(key)) && filePath2.containsValue(filePath1.get(key))
                        map.put(UNCHANGED, filePath2.get(key));
                        result.put(key, map);
                    }  else if ((filePath1.containsKey(key) && filePath2.containsKey(key))) {
                        map.put(OLD, filePath1.get(key));
                        map.put(NEW, filePath2.get(key));
                        result.put(key, map);
                    } else if (filePath1.containsKey(key)) {
                        map.put(OLD, filePath1.get(key));
                        result.put(key, map);
                    } else if (filePath2.containsKey(key)) {
                        map.put(NEW, filePath2.get(key));
                        result.put(key, map);
                    }
                });
        return result;

//        listKey.stream()
//                .distinct()
//                .sorted()
//                .forEach(key -> {
//                    Map<String, Object> map = new HashMap<>();
//                    if ((filePath1.containsKey(key) && filePath2.containsKey(key))
//                            && (filePath1.containsValue(filePath2.get(key)) == false
//                            && filePath2.containsValue(filePath1.get(key)) == false)) {
//                        map.put(OLD, filePath1.get(key));
//                        map.put(NEW, filePath2.get(key));
//                        result.put(key, map);
//                    } else if ((filePath1.containsKey(key) && filePath2.containsKey(key))
//                            && filePath1.containsValue(filePath2.get(key)) == true
//                            && filePath2.containsValue(filePath1.get(key)) == true) {
//                        map.put(UNCHANGED, filePath2.get(key));
//                        result.put(key, map);
//                    } else if(filePath1.containsKey(key) == false && filePath2.containsKey(key) == true) {
//                        map.put(NEW, filePath2.get(key));
//                        result.put(key, map);
//                    } else if (filePath1.containsKey(key) == true && filePath2.containsKey(key) == false) {
//                        map.put(OLD, filePath1.get(key));
//                         result.put(key, map);
//                    }});
//        return result;
    }
}
