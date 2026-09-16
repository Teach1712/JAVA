import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.print("Enter size of list: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextInt());
        }

        System.out.println("Original List: " + list);

        // Logic to swap first and last
        if (list.size() > 1) {
            // Method 1: Using Collections.swap (Easiest)
            Collections.swap(list, 0, list.size() - 1);

            /* Method 2: Manual logic using get() and set()
            int first = list.get(0);
            int last = list.get(list.size() - 1);
            list.set(0, last);
            list.set(list.size() - 1, first);
            */
        }

        System.out.println("After Swapping First-Last: " + list);
        sc.close();
    }
}