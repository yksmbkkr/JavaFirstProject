package Calculator.SimpleCalculator;


import Calculator.CalculatorMemoryInterface;

public class CalculatorMemory implements CalculatorMemoryInterface {
    private final int num1;
    private final int num2;

    public CalculatorMemory(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    public int getNum1() {
        return num1;
    }

    public int getNum2() {
        return num2;
    }
}
