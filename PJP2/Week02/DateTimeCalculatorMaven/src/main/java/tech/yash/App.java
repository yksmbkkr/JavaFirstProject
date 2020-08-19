package tech.yash;

import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
//        System.out.println("Input date 1 in format 'Day Month Year' (e.g. 25 12 2125) > ");
//        int[] d1 = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
//        System.out.println("Input date 2 in format 'Day Month Year' (e.g. 25 12 2125) > ");
//        int[] d2 = Stream.of(in.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();

        int[] d1 = {25, 12, 2020};
        int[] d2 = {6, 5, 1523};

//        System.out.println(Arrays.toString(d1));
//        System.out.println(Arrays.toString(d2));

        DateCalculator dateCalculator = new DateCalculator(d1, d2);
        System.out.println(DateCalculator.dateToString(dateCalculator.getDate1()));
        System.out.println(DateCalculator.dateToString(dateCalculator.getDate2()));
        System.out.println(DateCalculator.dateToString(dateCalculator.add()));
        System.out.println(dateCalculator.subtract().toString());

        System.out.println(DateCalculator.getDayofWeek(dateCalculator.getDate1()));
        System.out.println(DateCalculator.getWeekofYear(dateCalculator.getDate1()));

        System.out.println(DateCalculator.dateToString(DateCalculator.smartConverter("Today")));
        System.out.println(DateCalculator.dateToString(DateCalculator.smartConverter("Day before Yesterday")));
        System.out.println(DateCalculator.dateToString(DateCalculator.smartConverter("30 Days from now")));
        System.out.println(DateCalculator.dateToString(DateCalculator.smartConverter("2 Weeks from now")));
        System.out.println(DateCalculator.dateToString(DateCalculator.smartConverter("2 Years from now")));
        System.out.println(DateCalculator.dateToString(DateCalculator.smartConverter("10 Days earlier")));
        System.out.println(DateCalculator.dateToString(DateCalculator.smartConverter("50 years earlier")));


    }
}
