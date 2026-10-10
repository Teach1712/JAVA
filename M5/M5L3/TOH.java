import java.util.Scanner;

public class TOH {

    // Recursive function for Tower of Hanoi
    public static void toh(int n, String source, String destination, String auxiliary) {
        if (n == 0) {
            return; // base case
        }

        // Step 1: Move n-1 disks from source to auxiliary
        toh(n - 1, source, auxiliary, destination);

        // Step 2: Move nth disk from source to destination
        System.out.println("Move disk " + n + " from " + source + " to " + destination);

        // Step 3: Move n-1 disks from auxiliary to destination
        toh(n - 1, auxiliary, destination, source);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of disks: ");
        int n = sc.nextInt();

        // A, B, C are names of 3 towers
        toh(n, "A", "B", "C");

        System.out.println("Total moves: " + ((int)Math.pow(2, n) - 1));
        
        sc.close();
    }
}