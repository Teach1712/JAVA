import java.util.Scanner;

public class RotateNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter Number: ");
        int num = sc.nextInt();
        
        System.out.print("Enter Rotate no: ");
        int k = sc.nextInt();
        
        int original = num;
        
        // 1. Find number of digits
        int temp = num;
        int digits = 0;
        while(temp > 0) {
            digits++;
            temp = temp / 10;
        }
        
        // Handle if k > digits
        k = k % digits;
        
        // 2. Formula for rotation
        int power1 = (int)Math.pow(10, k);        // 10^k
        int power2 = (int)Math.pow(10, digits-k); // 10^(digits-k)
        
        int rightPart = num % power1;      // last k digits: 678
        int leftPart = num / power1;       // remaining digits: 12345
        
        int rotated = rightPart * power2 + leftPart;
        
        System.out.println("Output: " + rotated);
        
        sc.close();
    }
}