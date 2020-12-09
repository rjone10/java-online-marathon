package task3_3;

public class Solution {
    public static void execute(int a, int b, Strategy strategy) {
        double result = strategy.doOperations(a, b);
        System.out.println(result);
    }

    interface Strategy {
        double doOperations(int a, int b);
    }

    public static void addAtoB(int a, int b) {

        execute(6, 3, (a1, b1) -> a1 + b1);

    }

    public static void subtractBfromA(int a, int b) {

        Strategy strategy = (a1, b1) -> (a - b);

    }

    public static void multiplyAbyB(int a, int b) {

        Strategy strategy = (a1, b1) -> (a * b);

    }

    public static void divideAbyB(int a, int b) {

        Strategy strategy = (a1, b1) -> (a / b);

    }

}
