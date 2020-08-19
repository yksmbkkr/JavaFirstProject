package Calculator.SimpleCalculator;

import Calculator.CalculationUnitInterface;
import Calculator.CalculatorMemoryInterface;

import java.util.Scanner;

public class UserIO {
    Scanner sn;
    CalculatorMemoryInterface calculatorMemory;
    CalculationUnitInterface calculationUnit;

    public UserIO(){
        sn = new Scanner(System.in);
        System.out.println("Number 1");
        int temp = sn.nextInt();
        System.out.println("Number 2");
        int temp2 = sn.nextInt();
        calculatorMemory = new CalculatorMemory(temp, temp2);
        calculationUnit = new SimpleCalculationUnit((CalculatorMemory) calculatorMemory);
    }

    public CalculationUnitInterface getCalculationUnit() {
        return calculationUnit;
    }

    public void setCalculationUnit(CalculationUnitInterface calculationUnit) {
        this.calculationUnit = calculationUnit;
    }

    public CalculatorMemoryInterface getCalculatorMemory() {
        return calculatorMemory;
    }

    public float calculate(){
        System.out.println("What operation do you want to perform ( + , * , - , / )");
//        sn.next();
        sn.nextLine();
        String temp = sn.nextLine();
//        System.out.println(temp);
        return calculationUnit.operation(temp);
    }
}
