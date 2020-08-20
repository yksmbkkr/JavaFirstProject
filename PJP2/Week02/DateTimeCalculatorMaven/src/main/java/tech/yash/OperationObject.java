package tech.yash;

import java.util.ArrayList;

public class OperationObject {
    private String operation = "";
    private ArrayList<String> inputs = new ArrayList<>();
    private String result = "";

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public void addInput(String input) {
        this.inputs.add(input);
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getOperation() {
        return operation;
    }

    public ArrayList<String> getInputs() {
        return inputs;
    }

    public String getResult() {
        return result;
    }

    public String toString(){
        return "----------------------\nOperation: " + this.getOperation() +
                "\nInputs: " + this.getInputs() +
                "\nResult: " + this.getResult();
    }

    public void resetInput(){
        this.inputs = new ArrayList<>();
    }
}
