package task6_6;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.function.Predicate;
import java.util.function.BiFunction;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

class MyUtils {
    public static int findMaxByCondition(List<Integer> numbers, Predicate<Integer> pr) {
        List<Integer> sortedValues = numbers.stream().filter(pr).collect(Collectors.toList());
        return sortedValues.stream().mapToInt(n -> n).max().getAsInt();
    }
}

class User {
    public final List<Integer> values = new ArrayList<Integer>();

    int getFilterdValue(BiFunction<List<Integer>, Predicate<Integer>, Integer> biFunction, Predicate<Integer> pr) {
        return biFunction.apply(values, pr);
    }

    int getMaxValueByCondition(Predicate<Integer> predicate) {
        BiFunction<List<Integer>, Predicate<Integer>, Integer> function =
                (integers, integerPredicate) -> MyUtils.findMaxByCondition(integers, predicate);
        return getFilterdValue(function, predicate);
    }
}
