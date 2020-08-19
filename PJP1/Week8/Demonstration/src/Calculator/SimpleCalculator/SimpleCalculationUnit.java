package Calculator.SimpleCalculator;

import Calculator.CalculationUnitInterface;

public class SimpleCalculationUnit implements CalculationUnitInterface {

    CalculatorMemory calculatorMemory;

    public SimpleCalculationUnit(CalculatorMemory calculatorMemory) {
        this.calculatorMemory = calculatorMemory;
    }

    public float operation(String operator){
        if(operator.equals("+")){
            return (this.calculatorMemory.getNum1()+this.calculatorMemory.getNum2());
        } else if(operator.equals("-")){
            return (this.calculatorMemory.getNum1()-this.calculatorMemory.getNum2());
        } else if(operator.equals("*")){
            return (this.calculatorMemory.getNum1()*this.calculatorMemory.getNum2());
        } else if(operator.equals("/")){
            return (this.calculatorMemory.getNum1()/this.calculatorMemory.getNum2());
        } else {
            throw new IllegalArgumentException("Only operators +, -, *, / are allowed");
        }
    }

    public CalculatorMemory getMemory(){
        return this.calculatorMemory;
    }
}
