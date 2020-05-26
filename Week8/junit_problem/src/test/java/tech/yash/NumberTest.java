package tech.yash;

import org.junit.Before;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.assertEquals;

public class NumberTest {
    Number number;
    Number number1;
    Number number2;
    Number negative;

    @Before
    public void setup(){
        number = new Number(67);
        number1 = new Number(25);
        number2 = new Number(0);
        negative = new Number(-965);


    }

    @Test
    public void primeTest1(){
        assertEquals("isPrime Error 67 !", true, number.isPrime());
        assertEquals("isPrime Error 25 !", false, number1.isPrime());

    }

    @Test(expected = IllegalArgumentException.class)
    public void primeTest_NonFunctional(){
//        Number negative = new Number(-965);

        number2.isPrime();
    }

    @Test(expected = IllegalArgumentException.class)
    public void primeTest_NonFunctional2(){
//        Number number = new Number(0);

        negative.isPrime();
    }

    @Test
    public void armstrongTest1(){
        Number a = new Number(371);
        Number b = new Number(372);
        assertEquals("isArmstrong Error 371 !", true, a.isArmstrong());
        assertEquals("isArmstrong Error 372 !", false, b.isArmstrong());

    }

    @Test
    public void palindromeTest1(){
        Number a = new Number(110011);
        Number b = new Number(120011);
        assertEquals("isPalindrome Error 110011 !", true, a.isPalindrome());
        assertEquals("isPalindrome Error 120011 !", false, b.isPalindrome());

    }

    @Test(expected = IllegalArgumentException.class)
    public void armstrongTest_NonFunctional2(){
//        Number number = new Number(0);
        Number a = new Number(-965);
        a.isArmstrong();
    }

    @Test(expected = IllegalArgumentException.class)
    public void palindromeTest_NonFunctional2(){
//        Number number = new Number(0);
        Number a = new Number(-965);
        a.isPalindrome();
    }

}
