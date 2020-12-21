package task7_7;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class MyUtils {
    public static Stream<Integer> duplicateElements(Stream<Integer> stream) {
        Set<Integer> set = new TreeSet<>();
        return stream.filter(integer -> !set.add(integer))
                .collect(Collectors.toSet())
                .stream()
                .sorted();
    }

    public static void main(String[] args) {
        duplicateElements(Stream.of(-2, 1, null, -12, -3, -8, -2, -3, null, -2, -1, 1));
    }
}
