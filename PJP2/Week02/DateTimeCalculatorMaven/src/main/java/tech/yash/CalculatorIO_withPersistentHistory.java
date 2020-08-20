package tech.yash;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

public class CalculatorIO_withPersistentHistory extends CalculatorIO {
    OperationObject operationObject = new OperationObject();

    public CalculatorIO_withPersistentHistory() {
        super();
        this.addMenuOptions("Press 9 to view history - ");

//        this.sessionMemory = new ArrayList<>();
        smartLambdaMap.put(9, (Integer n) -> {
            System.out.println("##################################################");
            System.out.println("History\n");
//            this.sessionMemory.forEach(System.out::println);
            try {
                this.readHistory().forEach(entry -> {
                    String[] e_o = entry.split("\\|");
                    System.out.println("----------------------\nOperation: " + e_o[0] +
                            "\nInputs: " + e_o[1] +
                            "\nResult: " + e_o[2]);
                });
            } catch (FileNotFoundException e) {
                System.out.println("History not found !");
            }
            this.result[0] = "DISPLAYED HISTORY";
        });
    }

    public void performOperation(int op) throws IOException {
        if (this.smartLambdaMap.containsKey(op)){
//            OperationObject operationObject = new OperationObject();
//            this.sessionMemory.add(operationObject);
            String op_stmt = this.menuOptions.get(op-1);
            op_stmt = op_stmt.replaceAll("\\d","");
            op_stmt = op_stmt.replaceAll("Press","");
            op_stmt = op_stmt.replaceFirst("to","");
            op_stmt = op_stmt.replace("-","");
            op_stmt = op_stmt.strip();
            operationObject.setOperation(op_stmt);
            this.smartLambdaMap.get(op).accept(0);
            String output = "";
            System.out.println("\nResult of operation - ");
            if (result[0].getClass() == GregorianCalendar.class){
                output = DateCalculator.dateToString(((Calendar) result[0]));
            } else if (result[0].getClass() == String.class) {
                output = (String) result[0];
            } else {
                output = ((HashMap<String, Long>) result[0]).toString();
            }
            System.out.println(output);
            System.out.println("##################################################");
            operationObject.setResult(output);
            this.addHistorytoFile(operationObject);
            this.operationObject.resetInput();
        }
    }

    public String getStringInput(){
        Scanner sc = new Scanner(System.in);
        String temp =  sc.nextLine();
        operationObject.addInput(temp);
        return temp;
    }

    public void addHistorytoFile(OperationObject operationObject) throws IOException {
        FileOutputStream fos = new FileOutputStream("data_calculator_history.txt", true);
        fos.write((operationObject.getOperation() + "|" + operationObject.getInputs() + "|" + operationObject.getResult()+"\r\n").getBytes());
        fos.close();
    }

    public ArrayList<String> readHistory() throws FileNotFoundException {
        ArrayList<String> result = new ArrayList<>();
        Scanner s = new Scanner(new FileReader("data_calculator_history.txt"));
        while (s.hasNext()) {
            result.add(s.nextLine());
        }
        return result;
    }
}
