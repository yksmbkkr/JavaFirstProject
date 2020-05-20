package tech.yash.assignment;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class Demo
{
    public static void main( String[] args )
    {
        ApplicationContext employeeConfig = new ClassPathXmlApplicationContext("employeeConfig.xml");
        Map<String, Employee> empData = (Map<String, Employee>) employeeConfig.getBean("employeeMap");
        for (Map.Entry<String, Employee> entry: empData.entrySet()) {
            System.out.println("EMP CODE: "+entry.getKey()+" EMP DETAIL: "+entry.getValue());
        }
        System.out.println();

        Scanner sn = new Scanner(System.in);
        System.out.println("Enter employee ID (Integer only e.g. 1001) >");
        int eid = sn.nextInt();

        /*for (Employee employee: empData.values()) {
            if(employee.equals(eid)){
                System.out.println("REQUIRED EMPLOYEE DETAILS: "+employee.toString());
                break;
            }
        }*/
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
