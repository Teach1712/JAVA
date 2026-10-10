import java.util.Scanner;

public class CeilFloor {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter n: ");
        int n = sc.nextInt();

        int[] a = new int[n];
        System.out.println("Enter " + n + " sorted numbers:");
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        System.out.print("Enter d: ");
        int d = sc.nextInt();

        int low = 0;
        int high = a.length - 1;
        int ceil = -1; // smallest element >= d
        int floor = -1; // greatest element <= d

        // Binary Search
        while (low <= high) {
            int mid = (low + high) / 2;

            if (d < a[mid]) {
                ceil = a[mid]; // mid can be ceil
                high = mid - 1;
            } else if (d > a[mid]) {
                floor = a[mid]; // mid can be floor
                low = mid + 1;
            } else {
                // d == a[mid], both ceil and floor are same
                ceil = a[mid];
                floor = a[mid];
                break;
            }
        }

        System.out.println("Ceil: " + ceil);
        System.out.println("Floor: " + floor);

        sc.close();
    }
}