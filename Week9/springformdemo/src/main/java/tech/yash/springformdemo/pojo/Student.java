package tech.yash.springformdemo.pojo;

public class Student {

    private int id;
    private String name;
    private String city;

    public Student(){
        System.out.println("NOTHING PROVIDED");
    }

    public Student(int id, String name, String city) {
        this.id = id;
        this.name = name;
        this.city = city;
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

    //    @Override
    public boolean equals(int id) {
//        if (this == o) return true;
//        if (o == null || getClass() != o.getClass()) return false;
//
//        int id = (int) o;
        return this.hashCode() == id;
    }

    @Override
    public int hashCode() {
        return id;
    }

    @Override
    public String toString(){
        return getId()+", "+getName()+", "+getCity();
    }

}
