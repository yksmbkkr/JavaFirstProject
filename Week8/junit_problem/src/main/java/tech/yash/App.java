package tech.yash;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
//        System.out.println( "Hello World!" );

        Number number = new Number(25);
        Number number1 = new Number(67);

        Number number2 = new Number(371);

        Number number3 = new Number(110011);

        System.out.println("Checking prime for "+number.getNum()+" : "+number.isPrime());
        System.out.println("Checking prime for "+number1.getNum()+" : "+number1.isPrime());
        System.out.println("Checking armstrong number for "+number2.getNum()+" : "+number2.isArmstrong());
        System.out.println("Checking if number is palindrome for "+number3.getNum()+" : "+number3.isPalindrome());

    }
}
