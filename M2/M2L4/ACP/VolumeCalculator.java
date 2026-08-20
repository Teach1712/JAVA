import java.util.Scanner;

// Parent class
class Shape {
    // Encapsulation: data hidden, accessed via methods
    // Define method to be overridden
    void getVolume() {
        System.out.println("Volume of generic shape cannot be calculated");
    }
}

// Child class 1: Cube
class Cube extends Shape {
    private double side; // private = encapsulation
    
    // Constructor
    Cube(double side) {
        this.side = side;
    }
    
    // Getter and Setter for encapsulation
    public double getSide() {
        return side;
    }
    
    public void setSide(double side) {
        this.side = side;
    }
    
    @Override
    void getVolume() {
        double volume = side * side * side;
        System.out.println("Volume of Cube with side " + side + " = " + volume + " cm^3");
    }
}

// Child class 2: Cuboid
class Cuboid extends Shape {
    private double length, breadth, height; // private variables
    
    Cuboid(double length, double breadth, double height) {
        this.length = length;
        this.breadth = breadth;
        this.height = height;
    }
    
    public double getLength() { return length; }
    public double getBreadth() { return breadth; }
    public double getHeight() { return height; }
    
    @Override
    void getVolume() {
        double volume = length * breadth * height;
        System.out.println("Volume of Cuboid " + length + "x" + breadth + "x" + height + " = " + volume + " cm^3");
    }
}

// Child class 3: Cylinder
class Cylinder extends Shape {
    private double radius, height;
    
    Cylinder(double radius, double height) {
        this.radius = radius;
        this.height = height;
    }
    
    public double getRadius() { return radius; }
    public double getHeight() { return height; }
    
    @Override
    void getVolume() {
        double volume = 3.14 * radius * radius * height;
        System.out.println("Volume of Cylinder r=" + radius + " h=" + height + " = " + volume + " cm^3");
    }
}

public class VolumeCalculator {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("=== Volume Calculator ===");
        
        // Creating objects and calling methods
        System.out.print("Enter side of Cube: ");
        double s = sc.nextDouble();
        Shape cube = new Cube(s); // Parent ref, Child object
        cube.getVolume();
        
        System.out.print("\nEnter length, breadth, height of Cuboid: ");
        double l = sc.nextDouble();
        double b = sc.nextDouble();
        double h = sc.nextDouble();
        Shape cuboid = new Cuboid(l, b, h);
        cuboid.getVolume();
        
        System.out.print("\nEnter radius and height of Cylinder: ");
        double r = sc.nextDouble();
        double hc = sc.nextDouble();
        Shape cylinder = new Cylinder(r, hc);
        cylinder.getVolume();
        
        System.out.println("\n--- Fun Facts ---");
        System.out.println("50 cm3 = 1 million grains of sugar");
        System.out.println("600 cm3 = Volume of a human brain");
        
        sc.close();
    }
}