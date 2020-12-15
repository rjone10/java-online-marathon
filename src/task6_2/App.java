package task6_2;

import java.util.Arrays;
import java.util.function.Consumer;

public class App {
    static Consumer<double[]> cons = array -> {
        for (int i = 0; i < array.length; i++) {
//            array[i] *= (array[i] > 2) ? 0.8 : 0.9;
            if (i > 2) {
                array[i] *= 0.8;
            } else {
                array[i] *= 0.9;
            }
        }
    };

    public static double[] getChanged(double[] initialArray, Consumer<double[]> consumer) {
        double[] result = Arrays.copyOf(initialArray, initialArray.length);
        consumer.accept(result);
        return result;
    }


    public static void main(String[] args) {
        System.out.println(Arrays.toString(App.getChanged(new double[]{1, 2, 3, -1, -5, 0}, App.cons)));
        System.out.println(Arrays.toString(App.getChanged(new double[]{1, 2.02, 3, -1, -5, 0, 7, 8, 25.88}, App.cons)));

    }
}
