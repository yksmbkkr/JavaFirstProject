package Problem1;

import java.util.Scanner;

public class Student {

    private int id;
    private String name;
    private String city;

    public Student(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public Student() {
        Scanner sn = new Scanner(System.in);
        System.out.println("Name >");
        this.name = sn.nextLine();
        System.out.println("City >");
        this.city = sn.nextLine();
        System.out.println("ID (integer only)");
        this.id = Integer.parseInt(sn.nextLine());
    }

    public Student(Student student){
        this.name = student.name;
        this.id = student.id;
        this.city = student.city;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String toString(){
        return "Student: ID- "+this.id+", Name- "+this.name+", City- "+this.city;
    }
}
