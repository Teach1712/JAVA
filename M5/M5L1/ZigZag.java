import java.util.Scanner;

public class ZigZag {

    // Recursive function to print zig-zag
    public static void pzz(int n) {
        if (n == 0) {
            return; // base case
        }

        System.out.print(n + " "); // pre
        pzz(n - 1);
        System.out.print(n + " "); // in
        pzz(n - 1);
        System.out.print(n + " "); // post
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();
        
        pzz(n);
        
        sc.close();
    }
}