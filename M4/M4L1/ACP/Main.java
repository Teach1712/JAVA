import java.util.Scanner;

public class Main {

    // Logic for Inverse
    public static int[] inverseOfArray(int[] arr) {
        int n = arr.length;
        int[] inv = new int[n];

        for (int i = 0; i < n; i++) {
            int value = arr[i];
            inv[value] = i;
        }
        return inv;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements (0 to " + (n-1) + "):");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int[] inv = inverseOfArray(arr);

        System.out.print("Original Array: ");
        for (int x : arr) System.out.print(x + " ");

        System.out.print("\nInverse Array : ");
        for (int x : inv) System.out.print(x + " ");

        sc.close();
    }
}