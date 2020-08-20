package tech.yash;

import java.util.*;

public class CalculatorIO_withSessionMemory extends CalculatorIO {
    ArrayList<OperationObject> sessionMemory;
//    private final Object[] result = new Object[1];

    public CalculatorIO_withSessionMemory() {
        super();
        this.addMenuOptions("Press 9 to view history - ");

        this.sessionMemory = new ArrayList<>();
        smartLambdaMap.put(9, (Integer n) -> {
            System.out.println("##################################################");
            System.out.println("History\n");
            this.sessionMemory.forEach(System.out::println);
            this.result[0] = "DISPLAYED HISTORY";
        });
    }

    public void performOperation(int op){
        if (this.smartLambdaMap.containsKey(op)){
            OperationObject operationObject = new OperationObject();
            this.sessionMemory.add(operationObject);
            String op_stmt = this.menuOptions.get(op-1);
            op_stmt = op_stmt.replaceAll("\\d","");
            op_stmt = op_stmt.replaceAll("Press","");
            op_stmt = op_stmt.replaceFirst("to","");
            op_stmt = op_stmt.replace("-","");
            op_stmt = op_stmt.strip();
            operationObject.setOperation(op_stmt);
            this.smartLambdaMap.get(op).accept(0);
            String output = "";
            if (result[0].getClass() == GregorianCalendar.class){
                System.out.println("\nResult of operation - ");
                output = DateCalculator.dateToString(((Calendar) result[0]));
                System.out.println(output);
                System.out.println("##################################################");
            } else if (result[0].getClass() == String.class) {
                System.out.println("\nResult of operation - ");
                output = (String) result[0];
                System.out.println(output);
                System.out.println("##################################################");
            } else {
                System.out.println("\nResult of operation - ");
                output = ((HashMap<String, Long>) result[0]).toString();
                System.out.println(output);
                System.out.println("##################################################");
            }
            operationObject.setResult(output);
        }
    }

    public String getStringInput(){
        Scanner sc = new Scanner(System.in);
        String temp =  sc.nextLine();
        this.sessionMemory.get(this.sessionMemory.size()-1).addInput(temp);
        return temp;
    }
}
