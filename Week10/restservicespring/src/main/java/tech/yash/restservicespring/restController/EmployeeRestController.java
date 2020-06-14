package tech.yash.restservicespring.restController;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.yash.employee.EmpDAO;
import tech.yash.employee.EmpPojo;

import java.util.List;

@RestController
public class EmployeeRestController {

    @Autowired
    private EmpDAO empDAO;

//    @GetMapping(name = "HomePage", value = {"/", "/home"})
//    public String welcome(){
//        return "Welcome to Rest Template Example";
//    }

    @GetMapping(name = "Get All Employees", value = "/employees")
    public List<EmpPojo> getAllEmployee(){
        return empDAO.getAllEmployee();
    }

    @GetMapping(name = "Get Employee", value = "/employees/{id}")
    public EmpPojo getEmployee(@PathVariable int id){
        return empDAO.getEmployee(id);
    }

    @GetMapping(name = "Get Employee by Name", value = "/employees/name/{name}")
    public EmpPojo getEmployee(@PathVariable String name){

        List<EmpPojo> list = empDAO.getAllEmployee();

        return list.stream()
                .filter(empPojo -> empPojo.getName().equalsIgnoreCase(name))
                .findFirst()
                .orElse(null);
    }

    @PostMapping(name = "Insert Employee", value = "/employees")
    public EmpPojo insertEmployee(EmpPojo empPojo){
        return empDAO.addEmployee(empPojo);
    }

    @PostMapping(name = "Update Employee", value = "/employees/update")
    public EmpPojo updateEmployee(EmpPojo empPojo){
        return empDAO.updateEmployee(empPojo);
    }

    @DeleteMapping(name = "Delete Emplyee", value = "/employees/{id}")
    public EmpPojo deleteEmployee(@PathVariable int id){
        return empDAO.deleteEmployee(id);
    }

}
