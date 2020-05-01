package JavaAssignment;

public class Calculator {

    public static Num_Process add = (int a, int b) -> (a + b);
    public static Num_Process subtract = (int a, int b) -> (a - b);
    public static Num_Process multiply = (int a, int b) -> (a * b);
    public static Num_Process divide = (int a, int b) -> (a / b);

    public static int calculate(int a, int b, Num_Process operator) {
        return operator.cal(a, b);
    }
}
