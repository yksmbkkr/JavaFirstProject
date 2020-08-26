package tech.yash;

import java.io.IOException;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException {
        Scanner in = new Scanner(System.in);
        System.out.println("Name of your input file > ");
        String infile = in.nextLine();
        System.out.println("Name of your output file > ");
        String outfile = in.nextLine();
        IncomeOperation incomeOperation = new IncomeOperation(infile, outfile);
        System.out.println("Exiting...");
    }
}
