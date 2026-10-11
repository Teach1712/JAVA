import java.util.Scanner;

public class FRQ_AR_1 {

    // Method that returns the column index with minimum number of zeros
    public static int columnWithMinZeros(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;

        int minZeroCount = rows + 1; // max possible zeros in a column
        int minColIndex = -1;

        for (int col = 0; col < cols; col++) {
            int zeroCount = 0;
            for (int row = 0; row < rows; row++) {
                if (arr[row][col] == 0) {
                    zeroCount++;
                }
            }

            if (zeroCount < minZeroCount) {
                minZeroCount = zeroCount;
                minColIndex = col;
            }
        }
        return minColIndex; // returns column number (0-based index)
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter rows: ");
        int r = sc.nextInt();
        System.out.print("Enter cols: ");
        int c = sc.nextInt();

        int[][] arr = new int[r][c];
        System.out.println("Enter " + r + "x" + c + " matrix:");
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                arr[i][j] = sc.nextInt();
            }
        }

        int resultCol = columnWithMinZeros(arr);
        System.out.println("Column with minimum number of zeros is: " + resultCol);

        // If you want to print the column values also
        System.out.print("Column values: ");
        for (int i = 0; i < r; i++) {
            System.out.print(arr[i][resultCol] + " ");
        }
        sc.close();
    }
}