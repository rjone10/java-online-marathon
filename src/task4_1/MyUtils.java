package task4_1;

import java.util.*;

public class MyUtils {

    public static Map<String, List<String>> createNotebook(Map<String, String> phones) {
        Map<String, List<String>> result = new HashMap<>();
        if (phones == null) {
            return result;
        }
        if (phones.isEmpty()) {
            return result;
        }
        for (Map.Entry<String, String> entry : phones.entrySet()) {
            if (!result.containsKey(entry.getValue()) && entry.getKey() != null) {
                List<String> list = new LinkedList<>();
                list.add(entry.getKey());
                result.put(entry.getValue(), list);
            } else {
                for (Map.Entry<String, List<String>> iterationResult : result.entrySet()) {
                    if ((entry.getKey() != null && entry.getValue() == null) ||
                            (entry.getKey() != null && iterationResult.getKey().equals(entry.getValue()))) {
                        List<String> list = iterationResult.getValue();
                        if (!list.contains(entry.getKey())) {
                            list.add(entry.getKey());
                        }
                        iterationResult.setValue(list);
                        break;
                    }
//                        else if (iterationResult.getKey().equals(entry.getValue())) {
//                            List<String> list = iterationResult.getValue();
//                            if (!list.contains(entry.getKey())) {
//                                list.add(entry.getKey());
//                            }
//                            iterationResult.setValue(list);
//                            break;
//                        }
                }
            }
        }
        System.out.println();
        return result;
    }

    public static void main(String[] args) {
        Map<String, String> phones = new HashMap<>();
//        phones.put("0967654321", "Petro");
//        phones.put("0967654321", "Petro");
        phones.put("0677654321", null);
        phones.put(null, null);
        phones.put("0970011223", null);
//        phones.put("0631234567", "Ivan");
        createNotebook(phones);
    }
}
