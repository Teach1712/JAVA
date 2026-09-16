import java.util.*;

public class Main {

    // Standard Kadane's Algorithm
    static long kadane(int[] arr) {
        long maxSoFar = arr[0];
        long currMax = arr[0];
        for (int i = 1; i < arr.length; i++) {
            currMax = Math.max(arr[i], currMax + arr[i]);
            maxSoFar = Math.max(maxSoFar, currMax);
        }
        return maxSoFar;
    }

    static long maxPrefixSum(int[] arr) {
        long max = Long.MIN_VALUE;
        long sum = 0;
        for (int val : arr) {
            sum += val;
            max = Math.max(max, sum);
        }
        return max;
    }

    static long maxSuffixSum(int[] arr) {
        long max = Long.MIN_VALUE;
        long sum = 0;
        for (int i = arr.length - 1; i >= 0; i--) {
            sum += arr[i];
            max = Math.max(max, sum);
        }
        return max;
    }

    static long kConcatenation(int[] arr, int k) {
        long kadaneK1 = kadane(arr);
        if (k == 1) return kadaneK1;

        long totalSum = 0;
        for (int val : arr) totalSum += val;

        long prefix = maxPrefixSum(arr);
        long suffix = maxSuffixSum(arr);

        // Best sum that uses two copies
        long twoCopySum = prefix + suffix;

        if (totalSum > 0) {
            // We can take middle (k-2) copies fully
            return Math.max(kadaneK1, twoCopySum + totalSum * (k - 2));
        } else {
            return Math.max(kadaneK1, twoCopySum);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // Input format: n, array, k
        // ex: 3
        // 1 -2 1
        // 5
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) arr[i] = sc.nextInt();
        int k = sc.nextInt();

        System.out.println(kConcatenation(arr, k));
    }
}