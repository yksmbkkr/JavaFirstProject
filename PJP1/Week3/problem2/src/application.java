import java.util.Scanner;

public class application {
    public static void main(String[] args) {
        KeyRead_Line2 keyReadLine2 = new KeyRead_Line2();
        keyReadLine2.read();
        keyReadLine2.display();
        keyReadLine2.sort();
        keyReadLine2.display();

        Scanner sn = new Scanner(System.in);
        System.out.println("Which number you want to find > ");
        int find = sn.nextInt();

        System.out.println("idx: "+keyReadLine2.find(find));

    }
}
