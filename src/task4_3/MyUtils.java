package task4_3;

import java.util.*;

public class MyUtils {

    public boolean listMapCompare(List<String> list, Map<String, String> map) {
        List<String> mapValues = new ArrayList<>(map.values());
        List<String> sub = new ArrayList<>();
        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String string = it.next();
            if (map.containsValue(string)) {
                sub.add(string);
            }
        }
        return sub.equals(list) && list.containsAll(mapValues);
    }
}