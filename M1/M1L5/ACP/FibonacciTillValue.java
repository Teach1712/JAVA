import java.util.Scanner;

public class FibonacciTillValue {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter max value N: ");
        int n = sc.nextInt();
        
        int first = 0, second = 1;
        
        System.out.print("Fibonacci Series: ");
        
        while(first <= n) {
            System.out.print(first + " ");
            int next = first + second;
            first = second;
            second = next;
        }
        
        sc.close();
    }
}