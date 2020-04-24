import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class KeyRead_Line2 {
    int[] digits;

    public void read(){
        Scanner sn = new Scanner(System.in);
        System.out.println("Input n numbers from key board seperated by space > ");
        String str1 = sn.nextLine();
        String[] temp = str1.split(" ");
        digits = new int[temp.length];
        for(int i = 0; i < temp.length; i++) {
            this.digits[i] = Integer.parseInt(temp[i]);
        }
    }

    public void display(){
        System.out.println(Arrays.toString(this.digits));
    }

    public void sort(){
        Arrays.sort(this.digits);
    }
    public int find(int digit){
        return Arrays.binarySearch(digits, digit);
    }
}
