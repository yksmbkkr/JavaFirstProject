import java.util.Scanner;

public class Shapes {
    static int noOfSides;

    private static void calculateShapeArea(){
        Scanner sn = new Scanner(System.in);
        if(noOfSides==1){
            System.out.println("Input radius of circle > ");
            double a = sn.nextDouble();
            Circle circle = new Circle(a);
        } else if(noOfSides == 3){
            System.out.println("Input side 1 of triangle > ");
            double a = sn.nextDouble();
            System.out.println("Input side 2 of triangle > ");
            double b = sn.nextDouble();
            System.out.println("Input side 3 of triangle > ");
            double c = sn.nextDouble();
            Triangle triangle = new Triangle(a,b,c);
        } else if(noOfSides == 4){
            System.out.println("Input side of square > ");
            double a = sn.nextDouble();
            Square square = new Square(a);
        } else {
            System.out.println("Invalid input.");
        }
    }

    public static void main(String[] args) {
        Scanner sn = new Scanner(System.in);
        System.out.println("No of Sides > ");
        int n = sn.nextInt();
        noOfSides = n;
        calculateShapeArea();
    }

}

class Circle{
     double pi = Math.PI;
     double radius;

     private double calculateArea(){
         return pi*radius*radius;
    }

    public Circle(double radius){
        this.radius = radius;
        double area = calculateArea();
        System.out.println("Area of this circle is ");
        System.out.println(area);
    }

}

class Triangle{
    double a,b,c;

    private double calculateArea(){
        double p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    public Triangle(double a, double b, double c){
        this.a = a;
        this.b = b;
        this.c = c;
        double area = calculateArea();
        System.out.println("Area of this triangle is ");
        System.out.println(area);
    }

}

class Square{
    double side;

    private double calculateArea(){
        return this.side*this.side;
    }

    public Square(double side){
        this.side = side;
        double area = calculateArea();
        System.out.println("Area of this square is ");
        System.out.println(area);
    }

}
