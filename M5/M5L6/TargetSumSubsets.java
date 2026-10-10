import java.util.Scanner;

public class TargetSumSubsets {

    // This is the function you have to complete
    public static void printTargetSumSubsets(int[] arr, int idx, String set, int sos, int tar) {
        // base case
        if (idx == arr.length) {
            if (sos == tar) {
                System.out.println(set + ".");
            }
            return;
        }

        // 1. Yes - include current element
        printTargetSumSubsets(arr, idx + 1, set + arr[idx] + ", ", sos + arr[idx], tar);

        // 2. No - exclude current element
        printTargetSumSubsets(arr, idx + 1, set, sos, tar);
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

        System.out.print("Enter target: ");
        int tar = sc.nextInt();

        printTargetSumSubsets(arr, 0, "", 0, tar);

        sc.close();
    }
}