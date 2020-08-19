package tech.yash;

public class App2 {

    public static void main(String[] args) {
        Employee employee = new Employee(101, "name1", "city1");
        Employee employee2 = new Employee(102, "name2", "city2");
        Employee employee3 = new Employee(103, "name3", "city3");
        Employee employee4 = new Employee(104, "name4", "city4");
        Employee employee5 = new Employee(105, "name5", "city5");
        Employee employee6 = new Employee(106, "name6", "city6");
        Employee employee7 = new Employee(107, "name7", "city7");
        Employee employee8 = new Employee(108, "name8", "city8");

        AddEmplyee empList = new AddEmplyee();

        empList.addEmplyee(employee);
        empList.addEmplyee(employee2);
        empList.addEmplyee(employee3);
        empList.addEmplyee(employee4);
        empList.addEmplyee(employee5);
        empList.addEmplyee(employee6);
        empList.addEmplyee(employee7);
        empList.addEmplyee(employee8);

        empList.getEmployeeList().forEach((emp) -> System.out.println(emp.toString()));

        System.out.println(empList.getEmployee(105));
        System.out.println(empList.getEmployee(109));

        Employee nullEmp = null;
        empList.addEmplyee(nullEmp);

    }

}
