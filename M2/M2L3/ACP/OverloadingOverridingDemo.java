import java.util.Scanner;

// 1. Create a Parent class
class Shape {
    String name;
    
    Shape(String name) {
        this.name = name;
    }
    
    // Method to be overridden - same method in parent
    void area() {
        System.out.println("Area of " + name + " cannot be calculated. Define shape properly.");
    }
    
    // 2. Issue Methods inside the class - Method Overloading examples
    // Overloading: Same method name, different parameters
    void display() {
        System.out.println("Shape Name: " + name);
    }
    
    void display(String color) {  // Overloaded method 1
        System.out.println("Shape Name: " + name + ", Color: " + color);
    }
    
    void display(String color, int sides) {  // Overloaded method 2
        System.out.println("Shape Name: " + name + ", Color: " + color + ", Sides: " + sides);
    }
}

// Child class inheriting from Shape
class Circle extends Shape {
    double radius;
    
    Circle(double radius) {
        super("Circle"); // call parent constructor
        this.radius = radius;
    }
    
    // 3. Method Overriding: Same method name + same parameters as parent
    // This overrides the area() method of parent class
    @Override
    void area() {
        double result = 3.14 * radius * radius;
        System.out.println("Area of Circle: " + result);
    }
}

// Another Child class
class Rectangle extends Shape {
    double length, breadth;
    
    Rectangle(double length, double breadth) {
        super("Rectangle");
        this.length = length;
        this.breadth = breadth;
    }
    
    // Overriding area() method again for Rectangle
    @Override
    void area() {
        double result = length * breadth;
        System.out.println("Area of Rectangle: " + result);
    }
}

public class OverloadingOverridingDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // Demonstrating Method Overloading
        Shape s = new Shape("Generic Shape");
        System.out.println("--- Method Overloading ---");
        s.display(); // calls display()
        s.display("Red"); // calls display(String)
        s.display("Blue", 4); // calls display(String, int)
        
        System.out.println("\n--- Method Overriding ---");
        // Demonstrating Method Overriding
        Shape c = new Circle(5.0); // Parent reference, Child object
        c.area(); // Calls Circle's area() - Runtime Polymorphism
        
        Shape r = new Rectangle(10, 5);
        r.area(); // Calls Rectangle's area()
        
        sc.close();
    }
}