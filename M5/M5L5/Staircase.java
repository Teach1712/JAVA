import java.util.Scanner;

public class Staircase {

    // Function to count number of ways
    public static int countWays(int n) {
        // base cases
        if (n == 0) {
            return 1; // 1 way - stay there
        }
        if (n < 0) {
            return 0; // no way
        }

        // recursion: you can take 1, 2 or 3 steps
        int jump1 = countWays(n - 1);
        int jump2 = countWays(n - 2);
        int jump3 = countWays(n - 3);

        return jump1 + jump2 + jump3;
    }

    // Bonus: If you want to PRINT all paths also
    public static void printPaths(int n, String path) {
        if (n == 0) {
            System.out.println(path);
            return;
        }
        if (n < 0) {
            return;
        }
        printPaths(n - 1, path + "1");
        printPaths(n - 2, path + "2");
        printPaths(n - 3, path + "3");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter n: ");
        int n = sc.nextInt();

        System.out.println("Total ways: " + countWays(n));
        
        System.out.println("\nAll paths:");
        printPaths(n, "");

        sc.close();
    }
}