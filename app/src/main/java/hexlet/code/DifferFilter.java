package hexlet.code;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public class DifferFilter {
    private static final String OLD = "old";
    private static final String NEW = "new";
    private static final String UNCHANGED = "unchanged";

    public static Map<String, Map<String, Object>> getDifferFilter(Map<String, Object> fileParse1,
                                                                   Map<String, Object> fileParse2) {

        Map<String, Map<String, Object>> result = new TreeMap<>();

        List<String> listKey = new ArrayList<>(fileParse1.keySet());
        listKey.addAll(fileParse2.keySet());

        listKey.stream()
                .distinct()
                .sorted()
                .forEach(key -> {
                    Map<String, Object> map = new HashMap<>();
                    if (Objects.equals(fileParse1.get(key), fileParse2.get(key))) {
                        map.put(UNCHANGED, fileParse2.get(key));
                        result.put(key, map);
                    } else if ((fileParse1.containsKey(key) && fileParse2.containsKey(key))) {
                        map.put(OLD, fileParse1.get(key));
                        map.put(NEW, fileParse2.get(key));
                        result.put(key, map);
                    } else if (fileParse1.containsKey(key)) {
                        map.put(OLD, fileParse1.get(key));
                        result.put(key, map);
                    } else if (fileParse2.containsKey(key)) {
                        map.put(NEW, fileParse2.get(key));
                        result.put(key, map);
                    }
                });
        return result;
    }
}
