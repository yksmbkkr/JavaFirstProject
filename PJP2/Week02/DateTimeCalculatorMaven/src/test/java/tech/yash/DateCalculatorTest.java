package tech.yash;

import static org.junit.Assert.assertTrue;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;

import java.awt.*;
import java.security.InvalidParameterException;
import java.util.Calendar;
import java.util.HashMap;

public class DateCalculatorTest {

    public boolean compareDayMonthYear(Calendar date1, Calendar date2){
//        System.out.println(date1.toString());
//        System.out.println(date2.toString());
        if (date1.get(Calendar.DAY_OF_MONTH) != date2.get(Calendar.DAY_OF_MONTH)){
            return false;
        }
        if (date1.get(Calendar.MONTH) != date2.get(Calendar.MONTH)){
            return false;
        }
        if (date1.get(Calendar.YEAR) != date2.get(Calendar.YEAR)){
            return false;
        }
        return true;
    }


    @Test
    public void shouldAnswerWithTrue()
    {
        assertTrue( true );
    }

    @Test
    public void stringToDateTest(){
        String input = "02051999";
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            DateCalculator.stringToDate(input);
        });
    }

    @Test
    public void stringToDateTest2(){
        String input = "02 051999";
        Assertions.assertThrows(InvalidParameterException.class, () -> {
            DateCalculator.stringToDate(input);
        });
    }

    @Test
    public void stringtoDateTest3(){
        String input = "02 05 1999";
        Calendar output = Calendar.getInstance();
        output.set(1999, Calendar.MAY, 2);
        Assertions.assertTrue(compareDayMonthYear(DateCalculator.stringToDate(input), output));

    }

    @Test
    public void datetoStringTest(){
        String output = "02 05 1999";
        Calendar input = Calendar.getInstance();
        input.set(1999, Calendar.MAY, 2);
        Assertions.assertTrue(compareDayMonthYear(DateCalculator.stringToDate(output), input));

    }

    @Test
    public void additionTest(){
        Calendar output_actual = DateCalculator.add(DateCalculator.stringToDate("15 7 1990"), DateCalculator.stringToDate("15 9 3"));
        Calendar output_expected = Calendar.getInstance();
        output_expected.set(1994, Calendar.MARCH, 30);
        Assertions.assertTrue(compareDayMonthYear(output_expected, output_actual));
    }

    @Test
    public void subtractionTest(){
        HashMap<String, Long> output_actual = DateCalculator.subtract(DateCalculator.stringToDate("10 9 1990"), DateCalculator.stringToDate("1 1 1990"));
        HashMap<String, Long> output_expected = new HashMap<>();
        output_expected.put("MONTHS", (long) 8);
        output_expected.put("WEEKS", (long) 36);
        output_expected.put("DAYS", (long) 252);

        Assertions.assertEquals(output_expected, output_actual);
    }

    @Test
    public void subtractionTest2(){
        HashMap<String, Long> output_actual = DateCalculator.subtract(DateCalculator.stringToDate("5 5 1990"), DateCalculator.stringToDate("5 5 1990"));
        HashMap<String, Long> output_expected = new HashMap<>();
        output_expected.put("MONTHS", (long) 8);
        output_expected.put("WEEKS", (long) 36);
        output_expected.put("DAYS", (long) 252);

        Assertions.assertNotEquals(output_expected, output_actual);
    }

    @Test
    public void addDaysTest(){
        Calendar output_actual = DateCalculator.addDays(DateCalculator.stringToDate("1 1 2020"), 150);
        Calendar output_expected = Calendar.getInstance();
        output_expected.set(2020, Calendar.MAY, 30);
        Assertions.assertTrue(compareDayMonthYear(output_expected, output_actual));
    }

    @Test
    public void addWeeksTest(){
        Calendar output_actual = DateCalculator.addWeeks(DateCalculator.stringToDate("5 5 2012"), -20);
        Calendar output_expected = Calendar.getInstance();
        output_expected.set(2011, Calendar.DECEMBER, 17);
        Assertions.assertTrue(compareDayMonthYear(output_expected, output_actual));
    }

    @Test
    public void addMonthsTest(){
        Calendar output_actual = DateCalculator.addMonths(DateCalculator.stringToDate("15 10 2019"), 9);
        Calendar output_expected = Calendar.getInstance();
        output_expected.set(2020, Calendar.JULY, 15);
        Assertions.assertTrue(compareDayMonthYear(output_expected, output_actual));
    }

    @Test
    public void dayOfWeekTest(){
        String output_actual = DateCalculator.getDayofWeek(DateCalculator.stringToDate("15 4 2018"));
        String output_expected = "Sunday";
        Assertions.assertEquals(output_expected, output_actual);
    }

    @Test
    public void weekOfYearTest(){
        String output_actual = DateCalculator.getWeekofYear(DateCalculator.stringToDate("15 4 2018"));
        String output_expected = "16";
        Assertions.assertEquals(output_expected, output_actual);
    }

    @Test
    public void smartConverterTest(){
        Calendar output_actual = DateCalculator.smartConverter("Today");
        Calendar output_expected = Calendar.getInstance();
//        output_expected.set(2020, Calendar.MAY, 30);
        Assertions.assertTrue(compareDayMonthYear(output_expected, output_actual));
    }

    @Test
    public void smartConverterTest2(){
        Calendar output_actual = DateCalculator.smartConverter("Day before Yesterday");
        Calendar output_expected = Calendar.getInstance();
        output_expected.add(Calendar.DAY_OF_MONTH, -2);
        Assertions.assertTrue(compareDayMonthYear(output_expected, output_actual));
    }

    @Test
    public void smartConverterTest3(){
        Calendar output_actual = DateCalculator.smartConverter("100 Years From Now");
        Calendar output_expected = Calendar.getInstance();
        output_expected.add(Calendar.YEAR, 100);
        Assertions.assertTrue(compareDayMonthYear(output_expected, output_actual));
    }

    @Test
    public void smartConverterTest4(){
        Calendar output_actual = DateCalculator.smartConverter("3000 years earlier");
        Calendar output_expected = Calendar.getInstance();
        output_expected.set(981, Calendar.AUGUST, 22);
//        output_expected.set
        Assertions.assertFalse(compareDayMonthYear(output_expected, output_actual));
    }

}
