import java.util.Arrays;
import java.util.Scanner;

public class FRQ_AR_2 {

    // Method to find median as per assignment
    public static double findMedian(int[] arr) {
        // Sort the array first (important for median)
        Arrays.sort(arr);

        int n = arr.length;

        if (n % 2!= 0) {
            // Odd length - middle element
            return arr[n / 2];
        } else {
            // Even length - average of two middle elements
            int mid1 = arr[(n / 2) - 1];
            int mid2 = arr[n / 2];
            return (mid1 + mid2) / 2.0;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        double median = findMedian(arr);
        System.out.println("Median value is: " + median);

        sc.close();
    }
}