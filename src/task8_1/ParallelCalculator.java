package task8_1;

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
