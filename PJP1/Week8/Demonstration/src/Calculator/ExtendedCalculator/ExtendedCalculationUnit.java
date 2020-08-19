package Calculator.ExtendedCalculator;

import Calculator.SimpleCalculator.CalculatorMemory;
import Calculator.SimpleCalculator.SimpleCalculationUnit;

public class ExtendedCalculationUnit extends SimpleCalculationUnit {

    public ExtendedCalculationUnit(CalculatorMemory calculatorMemory) {
        super(calculatorMemory);
        System.out.println("Its extended version along with operators + , / , - , * it also supports ^ and %");
    }

    public float operation(String operator){
        if (operator.equals("+") || operator.equals("-") || operator.equals("*") || operator.equals("/")){
            return super.operation(operator);
        }
        if (operator.equals("^")){
            return (float) Math.pow(this.getMemory().getNum1(), this.getMemory().getNum2());
        }
        if (operator.equals("%")){
            return this.getMemory().getNum1()%this.getMemory().getNum2();
        }
        throw new IllegalArgumentException("Only + , - , / , * , ^ , % are allowed !");
    }
}
