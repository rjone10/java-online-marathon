package task6_1;

import java.util.Arrays;
import java.util.function.Predicate;

public class MyUtils {

    public static int getCount(int[] array, Predicate<Integer> predicate) {
        int counter = 0;
        for (int i = 0; i < array.length; i++) {
            if (predicate.test(array[i])) {
                counter++;
            }
        }
        return counter;
    }
}
