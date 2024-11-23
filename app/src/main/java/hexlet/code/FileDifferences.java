package hexlet.code;

import hexlet.code.constants.Keys;
import hexlet.code.constants.Status;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class FileDifferences {

    public static List<Map<Object, Object>> MapComparator(Map<String, Object> fileParse1,
                                                          Map<String, Object> fileParse2) {

        List<String> listKey = new ArrayList<>();
        listKey.addAll(fileParse1.keySet());
        listKey.addAll(fileParse2.keySet());

        return listKey.stream()
                .distinct()
                .sorted()
                .map(key -> {
                    Map<Object, Object> map = new HashMap<>();
                    if (Objects.equals(fileParse1.get(key), fileParse2.get(key))) {
                        map.put(Status.STATUS, Status.SAME);
                        map.put(Keys.KEY, key);
                        map.put(Keys.VALUE_SECOND, fileParse2.get(key));
                    } else if ((fileParse1.containsKey(key) && fileParse2.containsKey(key))) {
                        map.put(Status.STATUS, Status.CHANGED);
                        map.put(Keys.KEY, key);
                        map.put(Keys.VALUE_ONE, fileParse1.get(key));
                        map.put(Keys.VALUE_SECOND, fileParse2.get(key));
                    } else if (fileParse1.containsKey(key) && !fileParse2.containsKey(key)) {
                        map.put(Status.STATUS, Status.DELETED);
                        map.put(Keys.KEY, key);
                        map.put(Keys.VALUE_ONE, fileParse1.get(key));
                    } else if (fileParse2.containsKey(key) && !fileParse1.containsKey(key)) {
                        map.put(Status.STATUS, Status.NEW);
                        map.put(Keys.KEY, key);
                        map.put(Keys.VALUE_SECOND, fileParse2.get(key));
                    }
                    return map;
                })
                .toList();
    }
}
