package Problem1;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClassBO {
    private List<Student> classroom;

    public ClassBO() {
        this.classroom = new ArrayList<>();
    }

    public ClassBO(ClassBO classBO){
        this.classroom = classBO.classroom;
    }

    public void addStudent(){
        Student student = new Student();
        this.classroom.add(student);
    }

    public void addStudent(Student student){
        this.classroom.add(student);
    }

    public void addStudents(int n){
        for (int i = 0; i < n; i++) {
            this.classroom.add(new Student());
        }
    }

    public void addStudent(int id, String name, String city){
        this.classroom.add(new Student(id, name, city));
    }

    public void displayStudent(int id){
        this.classroom.stream().filter(student -> student.getId() == id).forEach(System.out::println);
    }

    public void displayStudent(String name){
        this.classroom.stream().filter(student -> student.getName().equalsIgnoreCase(name)).forEach(System.out::println);
    }

    public void displayStudentbyCity(String city){
        this.classroom.stream().filter(student -> student.getCity().equalsIgnoreCase(city)).forEach(System.out::println);
    }
    
    public void displayAll(){
        for (Student student : this.classroom) {
            System.out.println(student);
        }
    }

    public void sortById(){
        this.classroom.sort(Comparator.comparing(Student::getId));
    }

    public void sortByName(){
        this.classroom.sort(Comparator.comparing(Student::getName));
    }

    public void sortByCity(){
        this.classroom.sort(Comparator.comparing(Student::getCity));
    }
}
