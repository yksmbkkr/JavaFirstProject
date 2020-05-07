package Problem1;

public class Application {
    public static void main(String[] args) {
        ClassBO my_classroom = new ClassBO();

        my_classroom.addStudent(101, "Aman", "Delhi");
        my_classroom.addStudent(102, "Rajat", "Ambala");
        my_classroom.addStudent(103, "Naman", "Chandigarh");
        my_classroom.addStudent(104, "Amit", "Ambala");
        my_classroom.addStudent(105, "Riya", "Ambala");
        my_classroom.addStudent(106, "Anjali", "Delhi");
        my_classroom.addStudent(107, "Kartik", "Ambala");
        my_classroom.addStudent(108, "Rishabh", "Chandigarh");
        my_classroom.addStudent(109, "Yash", "Delhi");
        my_classroom.addStudent(110, "Kritika", "Chandigarh");
        my_classroom.addStudent(111, "John", "Delhi");
        my_classroom.addStudent(112, "Jane", "Delhi");
        System.out.println("All-----------------------------------------------");
        my_classroom.displayAll();
        System.out.println("id 105-----------------------------------------------");
        my_classroom.displayStudent(105);
        System.out.println("id 120-----------------------------------------------");
        my_classroom.displayStudent(120);
        System.out.println("yash-----------------------------------------------");
        my_classroom.displayStudent("Yash");
        System.out.println("Delhi-----------------------------------------------");
        my_classroom.displayStudentbyCity("Delhi");
        System.out.println("Sort by Name-----------------------------------------------");
        my_classroom.sortByName();
        my_classroom.displayAll();
        System.out.println("Sort by City-----------------------------------------------");
        my_classroom.sortByCity();
        my_classroom.displayAll();
        System.out.println("Sort by Id-----------------------------------------------");
        my_classroom.sortById();
        my_classroom.displayAll();
    }
}
