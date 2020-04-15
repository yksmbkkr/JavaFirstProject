package com.sapient;
import java.util.Scanner;
import com.sapient.CheckEven;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        System.out.println( "Enter A Integer > " );
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        if(CheckEven.check(number)){
            System.out.println("Its an even number");
        }else{
            System.out.println("Its an odd number");
        }
    }
}
