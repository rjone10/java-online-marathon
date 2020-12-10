package task4_5;

import java.util.*;

class Array<T> {
    private T[] array;

    public Array(T[] array) {
        this.array = array;
    }

    public T get(int index) {
        return array[index];
    }

    public int length() {
        return array.length;
    }
}

class ArrayUtil {
    static double averageValue(Array<? extends Number> array) {
        double result = 0;
        for (int i = 0; i < array.length(); i++) {
            result += array.get(i).doubleValue();
        }
        return result / array.length();
    }

    public static void main(String[] args) {
        ArrayUtil.averageValue(new Array<Integer>(new Integer[]{1, 2, 3, 4, 5}));
        ArrayUtil.averageValue(new Array<Double>(new Double[]{1.0, 3.0, 5.0}));
        ArrayUtil.averageValue(new Array<Number>(new Float[]{2.0f, 4.0f}));
    }
}
