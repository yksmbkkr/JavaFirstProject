package JavaAssignment;

import javax.sound.midi.Soundbank;
import java.util.Scanner;

public class Application {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        int[] arr1 = {20, 45, 0, 26, 20, 45, 5, 9 , 8};
        Int_Arr_Process int_arr_process = new Int_Arr_Process(arr1);
        int_arr_process.display_h();
        Int_Arr_Process int_arr_process1 = new Int_Arr_Process(int_arr_process);
        int_arr_process1.display_v();
        int_arr_process.sort();
        int_arr_process.display_h();
        System.out.println(int_arr_process.get_sum());
        System.out.println(int_arr_process.get_largest());
        System.out.println(int_arr_process.get_smallest());

        int[][] firstMatrix = { {3, -2, 5}, {3, 0, 4} };
        int[][] secondMatrix = { {2, 3}, {-9, 0}, {0, 4} };
        int[][] mat = { { 2, 0, 0, 0 },
                { 0, 2, 0, 0 },
                { 0, 0, 2, 0 },
                { 0, 0, 0, 2 } };

        Matrix matrix1 = new Matrix(mat);
        Matrix matrix2 = new Matrix(firstMatrix);
        Matrix matrix3 = new Matrix(secondMatrix);
        Matrix matrix = new Matrix(matrix1);
        matrix.display();
        matrix1.display();
        Matrix sumresult = matrix.add(matrix1);
        sumresult.display();
        matrix2.display();
        matrix3.display();
        Matrix prod_res = matrix2.multiply(matrix3);
        prod_res.display();

//        Num_Process add = (int a, int b) -> (a + b);
//        Num_Process subtract = (int a, int b) -> (a - b);
//        Num_Process multiply = (int a, int b) -> (a * b);
//        Num_Process divide = (int a, int b) -> (a / b);

        Calculator calculator = new Calculator();
        Scanner sn = new Scanner(System.in);
        System.out.println("Input first number >");
        int a = sn.nextInt();
        System.out.println("Input Second Number >");
        int b = sn.nextInt();
        sn.nextLine();
        System.out.println("Input operator ('add', 'subtract', 'multiply', 'divide' from these choice only) >");
        String opr = sn.nextLine();
        Num_Process operator = (Num_Process) Calculator.class.getField(opr).get(calculator);
        int res = Calculator.calculate(a,b, operator);
        System.out.println(res);

    }
}
