package task7_5;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Stream;

public class MyUtils {
    public static Stream<String> nameList(Map<String, Stream<String>> map) {
        if (map == null) throw new NullPointerException();

        Stream<String> result = Stream.empty();

        for (Stream<String> entry : map.values()) {
            if (entry != null) {
                result = Stream.concat(result, entry);
            }
        }

        result.filter(Objects::nonNull)
                .map(String::trim) // spaces on start and end
                .map(s -> s.replaceAll("\\s", ""))
                .filter(s -> !s.isEmpty()) // check if empty
                .map(String::toLowerCase)
                .map(s -> s.substring(0,1).toUpperCase() + s.substring(1)) // 1 letter to UpCase
                .distinct()
                .sorted()
                .forEach(System.out::println);

        return result;
    }

    public static void main(String[] args) {
        Map<String, Stream<String>> map = new HashMap<>();
        map.put("Masd", Stream.of("   ", "PeT   ro ", " Ira "));
//        map.put("Web", Stream.of("STepan", "ira ", " Andriy ", "an na"));
//        map.put("Spring", Stream.of("Ivan", "Anna"));

        nameList(map);
    }

}
