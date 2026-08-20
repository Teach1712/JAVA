import java.util.Scanner;

// 1. Create Student class
class Student {
    int rollNo;
    String name;
    double marks;
    
    // Method to input details
    void input(int r) {
        Scanner sc = new Scanner(System.in);
        rollNo = r;
        System.out.print("Enter name for Student " + rollNo + ": ");
        name = sc.nextLine();
        System.out.print("Enter marks for Student " + rollNo + ": ");
        marks = sc.nextDouble();
        sc.nextLine(); // consume new line
    }
    
    // Method to show details
    void display() {
        System.out.println("Roll No: " + rollNo + " | Name: " + name + " | Marks: " + marks);
    }
}

public class Top10Students {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        // 2. Create array of 10 Student objects
        Student s[] = new Student[10];
        
        System.out.println("=== Enter details of Top 10 Students of Class 10 ===");
        
        // 3. Create object for student 1 to 10 and take input
        for(int i = 0; i < 10; i++) {
            s[i] = new Student(); // create object
            s[i].input(i + 1); // call input method
            System.out.println();
        }
        
        // 4. Display all student details
        System.out.println("\n=== Top 10 Students Details ===");
        for(int i = 0; i < 10; i++) {
            s[i].display(); // call display method
        }
        
        sc.close();
    }
}