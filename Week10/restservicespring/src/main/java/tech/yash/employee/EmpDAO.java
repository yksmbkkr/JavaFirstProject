package tech.yash.employee;

import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class EmpDAO {

    private static Map<Integer, EmpPojo> empMap = new HashMap<>();

    static {
        initEmpDAO();
    }

    private static void initEmpDAO(){
        EmpPojo empPojo = new EmpPojo(1001, "Riya", "Delhi");
        EmpPojo empPojo1 = new EmpPojo(1002, "Pawan", "Ambala");
        EmpPojo empPojo2 = new EmpPojo(1003, "Aditi", "Delhi");

        empMap.put(empPojo.getId(), empPojo);
        empMap.put(empPojo1.getId(), empPojo1);
        empMap.put(empPojo2.getId(), empPojo2);
    }

    public EmpPojo getEmployee(int empId){
        return empMap.get(empId);
    }

    public EmpPojo addEmployee(EmpPojo emp){
        empMap.put(emp.getId(), emp);
        return emp;
    }

    public EmpPojo updateEmployee(EmpPojo emp){
        empMap.put(emp.getId(), emp);
        return emp;
    }

    public EmpPojo deleteEmployee(int empId){
        return empMap.remove(empId);
    }

    public List<EmpPojo> getAllEmployee(){
        Collection<EmpPojo> c = empMap.values();
        List<EmpPojo> l = new ArrayList<>();
        l.addAll(c);
        return l;
    }

}
