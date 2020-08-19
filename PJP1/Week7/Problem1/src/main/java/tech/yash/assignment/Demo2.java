package tech.yash.assignment;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

public class Demo2 {
    public static void main(String[] args) {
        Map<String, Employee> empData = new HashMap<>();
        empData.put("emp101", new Employee(1001, "John", "Delhi"));
        empData.put("emp102", new Employee(1002, "Joe", "Delhi"));
        empData.put("emp103", new Employee(1003, "Emily", "Mumbai"));
        empData.put("emp104", new Employee(1004, "Riya", "Ambala"));
        empData.put("emp105", new Employee(1005, "Rahul", "Mumbai"));
        empData.put("emp106", new Employee(1006, "Deep", "Ambala"));
        empData.put("emp107", new Employee(1007, "Ray", "Mumbai"));

        Scanner sn = new Scanner(System.in);
        System.out.println("Enter employee ID (Integer only e.g. 1001) >");
        int eid = sn.nextInt();

        Iterator empi = empData.values().iterator();
        while(empi.hasNext()){
            Employee temp = (Employee) empi.next();
            if(temp.equals(eid)){
                System.out.println("REQUIRED EMPLOYEE DETAILS: "+temp.toString());
                break;
            }
            if(!empi.hasNext()){
                System.out.println("NONE FOUND");
            }
        }
    }
}
