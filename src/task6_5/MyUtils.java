package task6_5;

import java.util.function.Predicate;
import java.util.Set;

class MyUtils {

    static Predicate<Integer> getPredicateFromSet(Set<Predicate<Integer>> predicateSet) {
        return predicateSet.stream().reduce(x -> true, Predicate::and);
    }
}
