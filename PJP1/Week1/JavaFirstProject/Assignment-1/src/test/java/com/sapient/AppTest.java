package com.sapient;

// import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
// import junit.Test;
import static org.junit.Assert.*;

/**
 * Unit test for simple App.
 */
// public class AppTest 
//     extends TestCase
// {
//     /**
//      * Create the test case
//      *
//      * @param testName name of the test case
//      */
//     public AppTest( String testName )
//     {
//         super( testName );
//     }

//     /**
//      * @return the suite of tests being tested
//      */
//     public static Test suite()
//     {
//         return new TestSuite( AppTest.class );
//     }

//     /**
//      * Rigourous Test :-)
//      */
//     public void testApp()
//     {
//         assertTrue( true );
//     }
// }

public class AppTest {
    private CheckEven app;
    
    @Before
    public void setup() {
        app = new CheckEven();
    }
    
    
    @Test
    public void TestZeroAsEven() {
        boolean flag = app.check(0);
        assertTrue(flag == true);
    }

    @Test
    public void Test2Case() {
        boolean flag = app.check(90);
        assertTrue(flag == true);
    }

    @Test
    public void Test3Case() {
        boolean flag = app.check(101);
        assertTrue(flag == false);
    }

    @Test
    public void Test4Case() {
        boolean flag = app.check(2);
        assertTrue(flag == true);
    }

    @Test
    public void Test5Case() {
        boolean flag = app.check(89);
        assertTrue(flag == false);
    }
}