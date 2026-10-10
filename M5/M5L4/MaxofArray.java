import java.util.Scanner;

public class MaxOfArray {

    // 1. ITERATIVE Solution
    public static int maxIterative(int[] arr) {
        int max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    // 2. RECURSIVE Solution
    public static int maxRecursive(int[] arr, int idx) {
        // base case: if we are at last element
        if (idx == arr.length - 1) {
            return arr[idx];
        }

        // faith: recursion will give max of remaining array
        int maxOfRest = maxRecursive(arr, idx + 1);

        // compare current element with max of rest
        if (arr[idx] > maxOfRest) {
            return arr[idx];
        } else {
            return maxOfRest;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " numbers:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int max1 = maxIterative(arr);
        int max2 = maxRecursive(arr, 0);

        System.out.println("Maximum (Iterative): " + max1);
        System.out.println("Maximum (Recursive): " + max2);

        sc.close();
    }
}