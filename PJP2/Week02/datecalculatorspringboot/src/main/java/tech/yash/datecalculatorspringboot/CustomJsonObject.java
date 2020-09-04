package tech.yash.datecalculatorspringboot;

import javax.validation.constraints.NotBlank;

public class CustomJsonObject {

    @NotBlank
    private String operation;
    @NotBlank
    private String arg1;
    @NotBlank
    private String arg2;

    public String getOperation() {
        return operation;
    }

    public void setOperation(String operation) {
        this.operation = operation;
    }

    public String getArg1() {
        return arg1;
    }

    public void setArg1(String arg1) {
        this.arg1 = arg1;
    }

    public String getArg2() {
        return arg2;
    }

    public void setArg2(String arg2) {
        this.arg2 = arg2;
    }
}
