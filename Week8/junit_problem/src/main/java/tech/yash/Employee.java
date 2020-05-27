package tech.yash;

public class Employee {

    private int id;
    private String name;
    private String city;

    public Employee(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCity() {
        return city;
    }

    public String toString(){
        return "Employee Details: "+this.getId()+", "+this.getName()+", "+this.getCity();
    }
}
