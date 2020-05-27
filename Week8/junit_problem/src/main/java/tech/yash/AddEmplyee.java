package tech.yash;

import java.util.ArrayList;
import java.util.List;

public class AddEmplyee {

    private List<Employee> employeeList;

    public AddEmplyee() {
        this.employeeList = new ArrayList<>();
    }

    public void addEmplyee(Employee employee){
        if(this.employeeList == null){
            this.employeeList = new ArrayList<>();
        }

        if (employee == null){
            throw new NullPointerException("Can not add null object !");
        }

        if (employee.getId() < 0){
            throw new IllegalArgumentException("Employee with negative ID not allowed !");
        }

        if (employee.getName().length() < 1){
            throw new IllegalArgumentException("Employee with empty name not allowed !");
        }

        this.employeeList.add(employee);
    }

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public int getSize(){
        return this.employeeList.size();
    }

    public Employee getEmployee(int id){
        return this.employeeList.stream().filter(employee -> employee.getId() == id).findFirst().orElse(null);
    }
}
