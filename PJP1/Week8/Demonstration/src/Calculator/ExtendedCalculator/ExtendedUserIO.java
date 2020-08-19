package Calculator.ExtendedCalculator;

import Calculator.SimpleCalculator.CalculatorMemory;
import Calculator.SimpleCalculator.UserIO;

import java.util.Scanner;

public class ExtendedUserIO extends UserIO {

    public ExtendedUserIO(){
        super();
        this.setCalculationUnit(new ExtendedCalculationUnit((CalculatorMemory) this.getCalculatorMemory()));
    }

    @Override
    public float calculate() {
        System.out.println("What operation do you want to perform ( + , * , - , / , ^ , % )");
//        sn.next();
        Scanner sn = new Scanner(System.in);
//        sn.nextLine();
        String temp = sn.nextLine();
//        System.out.println(temp);
//        this.getCalculationUnit().extendedOperation(temp);
        return this.getCalculationUnit().operation(temp);
    }
}
