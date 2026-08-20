import java.util.Scanner;

public class LeapYear {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a year: ");
        int year = sc.nextInt();
        
        // Leap year logic: divisible by 4 but not 100, OR divisible by 400
        // Using ternary operator ? :
        String result = (year % 4 == 0 && year % 100 != 0) || (year % 400 == 0) 
                        ? year + " is a Leap Year" 
                        : year + " is not a Leap Year";
        
        System.out.println(result);
        
        sc.close();
    }
}