import java.text.NumberFormat;
import java.util.Scanner;

public class application {
    public static void main(final String[] args) {

        long n;
        Scanner s=new Scanner(System.in);
        System.out.println("Enter a number to convert into word format");
        n =s.nextLong();
        fig_to_words figToWords = new fig_to_words(n);
        figToWords.convert();
    }
}
