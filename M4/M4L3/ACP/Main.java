import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // First matrix size
        System.out.print("Enter rows and cols of Matrix 1: ");
        int r1 = sc.nextInt();
        int c1 = sc.nextInt();

        // Second matrix size
        System.out.print("Enter rows and cols of Matrix 2: ");
        int r2 = sc.nextInt();
        int c2 = sc.nextInt();

        // Condition for multiplication
        if (c1!= r2) {
            System.out.println("Multiplication not possible! c1 must be equal to r2");
            return;
        }

        int[][] a = new int[r1][c1];
        int[][] b = new int[r2][c2];
        int[][] c = new int[r1][c2]; // Result matrix

        System.out.println("Enter Matrix 1 elements:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c1; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        System.out.println("Enter Matrix 2 elements:");
        for (int i = 0; i < r2; i++) {
            for (int j = 0; j < c2; j++) {
                b[i][j] = sc.nextInt();
            }
        }

        // Multiplication Logic - showcase of 2-D arrays
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                for (int k = 0; k < c1; k++) {
                    c[i][j] += a[i][k] * b[k][j];
                }
            }
        }

        System.out.println("Result Matrix:");
        for (int i = 0; i < r1; i++) {
            for (int j = 0; j < c2; j++) {
                System.out.print(c[i][j] + " ");
            }
            System.out.println();
        }
        sc.close();
    }
}