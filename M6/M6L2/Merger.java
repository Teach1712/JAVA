import java.util.Scanner;

public class Merger {

    // 1. Function for Bubble Sort
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // swap
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    // 2. Function to Merge two sorted arrays
    public static int[] mergeSortedArrays(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[] merged = new int[n + m];

        int i = 0, j = 0, k = 0;

        while (i < n && j < m) {
            if (a[i] <= b[j]) {
                merged[k++] = a[i++];
            } else {
                merged[k++] = b[j++];
            }
        }

        // copy remaining elements
        while (i < n) {
            merged[k++] = a[i++];
        }
        while (j < m) {
            merged[k++] = b[j++];
        }

        return merged;
    }

    public static void printArray(int[] arr) {
        for (int val : arr) {
            System.out.print(val + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first array: ");
        int n = sc.nextInt();
        int[] a = new int[n];
        System.out.println("Enter " + n + " elements for first array:");
        for (int i = 0; i < n; i++) a[i] = sc.nextInt();

        System.out.print("Enter size of second array: ");
        int m = sc.nextInt();
        int[] b = new int[m];
        System.out.println("Enter " + m + " elements for second array:");
        for (int i = 0; i < m; i++) b[i] = sc.nextInt();

        // Sort both arrays using Bubble Sort
        bubbleSort(a);
        bubbleSort(b);

        System.out.print("Sorted Array 1: ");
        printArray(a);

        System.out.print("Sorted Array 2: ");
        printArray(b);

        // Merge
        int[] merged = mergeSortedArrays(a, b);

        System.out.print("Final Merged Sorted Array: ");
        printArray(merged);

        sc.close();
    }
}