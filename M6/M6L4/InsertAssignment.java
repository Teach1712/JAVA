import java.util.Scanner;
import java.util.Arrays;

public class InsertAssignment {

    // Function for Insertion Sort - to showcase understanding
    public static void insertionSort(int[] arr) {
        int n = arr.length;
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;

            // Move elements greater than key to one position ahead
            while (j >= 0 && arr[j] > key) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = key;
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

        // Create a sorted copy using Insertion Sort
        int[] sortedA = Arrays.copyOf(A, n);
        insertionSort(sortedA);

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

        sc.close();
    }
}