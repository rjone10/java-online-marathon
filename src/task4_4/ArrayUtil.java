package task4_4;

class ArrayUtil {
    public static <T> T setAndReturn(T[] array, T change, int index) {
        array[index] = change;
        return change;
    }
}
