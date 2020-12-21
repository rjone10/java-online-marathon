package task8_2;

import java.util.function.BinaryOperator;

public class ParallelCalculator implements Runnable {
    int result;

    BinaryOperator<Integer> binaryOperator;
    int operand1, operand2;

    public ParallelCalculator(BinaryOperator<Integer> binaryOperator, int operand1, int operand2) {
        this.binaryOperator = binaryOperator;
        this.operand1 = operand1;
        this.operand2 = operand2;
    }

    @Override
    public void run() {
        result = binaryOperator.apply(operand1, operand2);
    }
}

class Accountant {
    public static synchronized int sum(int x, int y){
        ParallelCalculator parallelCalculator = new ParallelCalculator(Integer::sum, x, y);
        Thread thread = new Thread(parallelCalculator);
        thread.start();
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return parallelCalculator.result;
    }

    public static void main(String[] args) throws InterruptedException {
        System.out.println(sum(3,5));
    }
}
