import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n (for n x n matrix): ");
        int n = sc.nextInt();
        int[][] a = new int[n][n];

        System.out.println("Enter matrix elements:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        boolean found = false;

        for (int i = 0; i < n; i++) {
            // Find minimum in row i
            int minVal = a[i][0];
            int colIndex = 0;
            for (int j = 1; j < n; j++) {
                if (a[i][j] < minVal) {
                    minVal = a[i][j];
                    colIndex = j;
                }
            }

            // Check if minVal is maximum in its column
            boolean isSaddle = true;
            for (int k = 0; k < n; k++) {
                if (a[k][colIndex] > minVal) {
                    isSaddle = false;
                    break;
                }
            }

            if (isSaddle) {
                System.out.println("Saddle Point is: " + minVal + " at (" + i + "," + colIndex + ")");
                found = true;
                break; // remove this if you want all saddle points
            }
        }

        if (!found) {
            System.out.println("No Saddle Point found");
        }
        sc.close();
    }
}