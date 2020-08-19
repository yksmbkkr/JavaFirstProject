package tech.yash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;

public class AddEmployeeTest {

    private final int test_emp_id = 100;
    private final String test_emp_name = "TESTEMP";
    private final String test_emp_city = "TESTCITY";

    @Mock
    Employee emp;

    @Mock
    Employee emp2;
//
    @BeforeEach
    public void setup(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void creatingEmployeeListTest(){

        // Trying out various things just ignore !

        /*AddEmplyee addEmplyee = new AddEmplyee();
        addEmplyee.addEmplyee(employee);

        when(employee.toString()).thenReturn("Employee Details: 100, testname, testcity");
//        when(employee.getId()).thenReturn(100);
//        when(addEmplyee.getEmployee(100)).thenReturn(employee);

        Assertions.assertEquals("Employee Details: 100, testname, testcity", employee.toString());
//        Assertions.assertEquals(employee, addEmplyee.getEmployee(100));
        verify(employee).toString();*/
//        Employee emp = mock(Employee.class);
        when(emp.getId()).thenReturn(test_emp_id);
        when(emp.getName()).thenReturn(test_emp_name);
        when(emp.getCity()).thenReturn(test_emp_city);
        String str = "Employee Details: "+emp.getId()+", "+emp.getName()+", "+emp.getCity();
        when(emp.toString()).thenReturn(str);

        AddEmplyee empList = new AddEmplyee();
        empList.addEmplyee(emp);
//        for (Employee e:empList.getEmployeeList()
//             ) {
//            System.out.println(e.getId());
//        }
        System.out.println(empList.getEmployee(100).toString());
//        verify(emp).getId();
        Assertions.assertEquals(100, emp.getId());

    }

    // Functional Tests ----------------------------------------------------------

    @Test
    public void test_addEmployee(){

        // Functional Test

        when(emp.getId()).thenReturn(test_emp_id);
        when(emp.getName()).thenReturn(test_emp_name);

        AddEmplyee empList = new AddEmplyee();
        empList.addEmplyee(emp);

        Assertions.assertEquals(1, empList.getSize(), "Added 1 Employee");
    }

    @Test
    public void test_getEmployee(){

        // Functional Test

        when(emp.getId()).thenReturn(test_emp_id);
        when(emp.getName()).thenReturn(test_emp_name);

        AddEmplyee empList = new AddEmplyee();
        empList.addEmplyee(emp);

        Assertions.assertEquals(emp, empList.getEmployee(100), "Get Emplyee by ID 100");

    }

    @Test
    public void testNegative_getEmployee(){

        // Functional Test

        when(emp.getId()).thenReturn(test_emp_id);
        when(emp.getName()).thenReturn(test_emp_name);

        AddEmplyee empList = new AddEmplyee();
        empList.addEmplyee(emp);
//        when(emp2.getId()).thenReturn(test_emp_id+1);


        Assertions.assertNotEquals(emp2, empList.getEmployee(100), "Get Emplyee by ID 100 returned wrong");

    }

    // Non Functional Tests ----------------------------------------------------------

    @Test
    public void testNull_addEmployee(){

        // Non Functional Test

        Employee nullEmp = null;
        AddEmplyee addEmplyee = new AddEmplyee();

        Assertions.assertThrows(NullPointerException.class, ()->{
            addEmplyee.addEmplyee(nullEmp);
        });
    }

    @Test
    public void testNegativeID_addEmployee(){

        // Non Functional Test

        when(emp.getId()).thenReturn(-100);
//        when(emp.getId()).thenReturn(test_emp_id);
        when(emp.getName()).thenReturn(test_emp_name);
        AddEmplyee addEmplyee = new AddEmplyee();

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            addEmplyee.addEmplyee(emp);
        });
    }

    @Test
    public void testEmptyName_addEmployee(){

        // Non Functional Test

        when(emp.getId()).thenReturn(test_emp_id);
        when(emp.getName()).thenReturn("");
        AddEmplyee addEmplyee = new AddEmplyee();

        Assertions.assertThrows(IllegalArgumentException.class, ()->{
            addEmplyee.addEmplyee(emp);
        });
    }

    @Test
    public void testNull_on_employee_not_found_getEmployee(){

        // Non Functional Test

        when(emp.getId()).thenReturn(test_emp_id);
        when(emp.getName()).thenReturn(test_emp_name);

        AddEmplyee addEmplyee = new AddEmplyee();
        addEmplyee.addEmplyee(emp);

        Assertions.assertEquals(null, addEmplyee.getEmployee(200), "Trying to get non existing employee with id 200");
    }



}
