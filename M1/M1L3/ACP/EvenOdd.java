import java.util.Scanner;

public class EvenOdd {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter a number: ");
        int num = sc.nextInt();
        
        String result = (num % 2 == 0) ? "Even" : "Odd";
        System.out.println(num + " is an " + result + " number");
        
        sc.close();
    }
}