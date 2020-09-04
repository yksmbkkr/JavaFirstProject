package tech.yash.datecalculatorspringboot.Calculator;

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

    public String getStringInput(){
        return sc.nextLine();
    }
}
