import java.util.Scanner;
import java.util.Arrays;

public class SelectAssignment {

    // Function for Selection Sort - to showcase understanding
    public static void selectionSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            int minIdx = i;
            // find minimum in remaining unsorted array
            for (int j = i + 1; j < n; j++) {
                if (arr[j] < arr[minIdx]) {
                    minIdx = j;
                }
            }
            // swap min element with first element of unsorted part
            int temp = arr[minIdx];
            arr[minIdx] = arr[i];
            arr[i] = temp;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter N: ");
        int n = sc.nextInt();

        int[] A = new int[n];
        System.out.println("Enter " + n + " unique elements:");
        for (int i = 0; i < n; i++) {
            A[i] = sc.nextInt();
        }

        // Create a sorted copy using Selection Sort
        int[] sortedA = Arrays.copyOf(A, n);
        selectionSort(sortedA);

        System.out.print("Sorted Array: ");
        for (int x : sortedA) System.out.print(x + " ");
        System.out.println();

        // Find position of each A[i] in sorted array
        int[] result = new int[n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (A[i] == sortedA[j]) {
                    result[i] = j; // 0-based position
                    break;
                }
            }
        }

        System.out.print("Result positions: ");
        for (int pos : result) {
            System.out.print(pos + " ");
        }
        System.out.println();

        // If you want 1-based position for output
        System.out.print("Result positions (1-based): ");
        for (int pos : result) {
            System.out.print((pos + 1) + " ");
        }

        sc.close();
    }
}