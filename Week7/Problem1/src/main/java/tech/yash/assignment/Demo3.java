package tech.yash.assignment;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Scanner;

public class Demo3 {

    public static void main(String[] args) {

        //Different approach to find employee, Instead of using Employee ID, using Employee Code

        ApplicationContext employeeConfig = new ClassPathXmlApplicationContext("employeeConfig.xml");

        Scanner sn = new Scanner(System.in);
        System.out.println("Enter employee code (e.g. emp5) >");
        String empCode = sn.next();

        try {
            Employee result = (Employee) employeeConfig.getBean(empCode);
            System.out.println("REQUIRED EMPLOYEE DETAILS: "+result.toString());
        } catch (NoSuchBeanDefinitionException e) {
            System.out.println("NO EMPLOYEE FOUND WITH PROVIDED CODE !");
        }


    }

}
