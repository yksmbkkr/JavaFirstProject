package tech.yash;

//import org.junit.Before;
//import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class NumberTest {
    Number number;
    Number number1;
    Number number2;
    Number negative;

    @BeforeEach
    public void setup(){
        number = new Number(67);
        number1 = new Number(25);
        number2 = new Number(0);
        negative = new Number(-965);


    }

    @Test
    public void primeTest1(){
        Assertions.assertEquals(true, number.isPrime(),"isPrime Error 67 !");
        Assertions.assertEquals(false, number1.isPrime(), "isPrime Error 25 !");

    }

    @Test
    public void primeTest_NonFunctional(){
//        Number negative = new Number(-965);

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            number2.isPrime();

        });
    }

    @Test
    public void primeTest_NonFunctional2(){
//        Number number = new Number(0);

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            negative.isPrime();


        });
    }

    @Test
    public void armstrongTest1(){
        Number a = new Number(371);
        Number b = new Number(372);
        Assertions.assertEquals(true, a.isArmstrong(), "isArmstrong Error 371 !");
        Assertions.assertEquals(false, b.isArmstrong(),"isArmstrong Error 372 !");

    }

    @Test
    public void palindromeTest1(){
        Number a = new Number(110011);
        Number b = new Number(120011);
        Assertions.assertEquals(true, a.isPalindrome(), "isPalindrome Error 110011 !");
        Assertions.assertEquals(false, b.isPalindrome(), "isPalindrome Error 120011 !");

    }

    @Test
    public void armstrongTest_NonFunctional2(){
//        Number number = new Number(0);
        Number a = new Number(-965);

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            a.isArmstrong();

        });
    }

    @Test
    public void palindromeTest_NonFunctional2(){
//        Number number = new Number(0);
        Number a = new Number(-965);

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            a.isPalindrome();

        });
    }

}
