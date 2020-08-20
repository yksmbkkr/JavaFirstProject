package tech.yash;

import java.io.IOException;
import java.util.*;
import java.util.function.Consumer;

public class CalculatorIO {
    final Object[] result = new Object[1];
    ArrayList<String> menuOptions;
    Map<Integer, Consumer<Integer>> smartLambdaMap = new HashMap<>();
    private Scanner sc = new Scanner(System.in);

    CalculatorIO(){
        this.menuOptions = new ArrayList<>();

        this.menuOptions.add("Press 1 to add dates - ");
        this.menuOptions.add("Press 2 to subtract dates - ");
        this.menuOptions.add("Press 3 to add/subtract days from a specific date - ");
        this.menuOptions.add("Press 4 to add/subtract weeks from a specific date - ");
        this.menuOptions.add("Press 5 to add/subtract months from a specific date - ");
        this.menuOptions.add("Press 6 to determine the Day of the Week for a specific date - ");
        this.menuOptions.add("Press 7 to determine the Week Number for a specific date - ");
        this.menuOptions.add("Press 8 to get date from a natural language string - ");

        smartLambdaMap.put(1, (Integer n) -> {
            System.out.println("##################################################");
            System.out.println("Performing Addition\n");
            System.out.println("Input date 1 in format 'Day Month Year' (e.g. 25 12 2125) > ");
            Calendar date1 = DateCalculator.stringToDate(getStringInput());
            System.out.println("Input date 2 in format 'Day Month Year' (e.g. 25 12 2125) > ");
            Calendar date2 = DateCalculator.stringToDate(getStringInput());
            result[0] = DateCalculator.add(date1, date2);
        });
        smartLambdaMap.put(2, (Integer n) -> {
            System.out.println("##################################################");
            System.out.println("Performing Subtraction\n");
            System.out.println("Input date 1 in format 'Day Month Year' (e.g. 25 12 2125) > ");
            Calendar date1 = DateCalculator.stringToDate(getStringInput());
            System.out.println("Input date 2 in format 'Day Month Year' (e.g. 25 12 2125) > ");
            Calendar date2 = DateCalculator.stringToDate(getStringInput());
            result[0] = DateCalculator.subtract(date1, date2);
        });
        smartLambdaMap.put(3, (Integer n) -> {
            System.out.println("##################################################");
            System.out.println("Performing add/subtract days from a specific date\n");
            System.out.println("Input date in format 'Day Month Year' (e.g. 25 12 2125) > ");
            Calendar date1 = DateCalculator.stringToDate(getStringInput());
            System.out.println("Input days to add or subtract (e.g. 20 or -20) > ");
            int diff = Integer.parseInt(getStringInput());
            result[0] = DateCalculator.addDays(date1, diff);
        });
        smartLambdaMap.put(4, (Integer n) -> {
            System.out.println("##################################################");
            System.out.println("Performing add/subtract weeks from a specific date\n");
            System.out.println("Input date in format 'Day Month Year' (e.g. 25 12 2125) > ");
            Calendar date1 = DateCalculator.stringToDate(getStringInput());
            System.out.println("Input weeks to add or subtract (e.g. 20 or -20) > ");
            int diff = Integer.parseInt(getStringInput());
            result[0] = DateCalculator.addWeeks(date1, diff);
        });
        smartLambdaMap.put(5, (Integer n) -> {
            System.out.println("##################################################");
            System.out.println("Performing add/subtract months from a specific date\n");
            System.out.println("Input date in format 'Day Month Year' (e.g. 25 12 2125) > ");
            Calendar date1 = DateCalculator.stringToDate(getStringInput());
            System.out.println("Input months to add or subtract (e.g. 20 or -20) > ");
            int diff = Integer.parseInt(getStringInput());
            result[0] = DateCalculator.addMonths(date1, diff);
        });
        smartLambdaMap.put(6, (Integer n) -> {
            System.out.println("##################################################");
            System.out.println("Determining the Day of the Week for a specific date\n");
            System.out.println("Input date in format 'Day Month Year' (e.g. 25 12 2125) > ");
            Calendar date1 = DateCalculator.stringToDate(getStringInput());
            result[0] = DateCalculator.getDayofWeek(date1);
        });
        smartLambdaMap.put(7, (Integer n) -> {
            System.out.println("##################################################");
            System.out.println("Determining the Week Number for a specific date\n");
            System.out.println("Input date in format 'Day Month Year' (e.g. 25 12 2125) > ");
            Calendar date1 = DateCalculator.stringToDate(getStringInput());
            result[0] = DateCalculator.getWeekofYear(date1);
        });
        smartLambdaMap.put(8, (Integer n) -> {
            System.out.println("##################################################");
            System.out.println("Getting date from a natural language string\n");
            System.out.println("\tAvailable options are - ");
            System.out.println("\tToday, Tomorrow, Day after tomorrow, yesterday, Day before yesterday, Last week, Previous week, Next " +
                    "week, Next month, Next Year, Last month, Last year, Month after, Month " +
                    "before, n weeks from now, n days from now, n months from now, n years " +
                    "from now, n days earlier, n weeks earlier, n months earlier, n years earlier.");
//            System.out.println("Input date in format 'Day Month Year' (e.g. 25 12 2125) > ");
            result[0] = DateCalculator.smartConverter(getStringInput());
        });
    }

    public ArrayList<String> getMenuOptions() {
        return menuOptions;
    }

    public void addMenuOptions(String string) {
        this.menuOptions.add(string);
    }

    public void inputOptions(){
        System.out.println("Press following keys to perform the required operation - ");
        this.getMenuOptions().forEach(System.out::println);
    }

    public void performOperation(int op) throws IOException {
        if (this.smartLambdaMap.containsKey(op)){
            this.smartLambdaMap.get(op).accept(0);
            if (result[0].getClass() == GregorianCalendar.class){
                System.out.println("Result of operation - ");
                System.out.println(DateCalculator.dateToString(((Calendar) result[0])));
                System.out.println("##################################################");
            } else if (result[0].getClass() == String.class) {
                System.out.println("Result of operation - ");
                System.out.println(result[0]);
                System.out.println("##################################################");
            } else {
                System.out.println("Result of operation - ");
                System.out.println(((HashMap<String, Long>) result[0]).toString());
                System.out.println("##################################################");
            }
        }
    }

    public String getStringInput(){
        return sc.nextLine();
    }
}
