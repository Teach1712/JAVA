import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();

        System.out.print("Enter number of elements to add: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            list.add(x); // add element
        }

        System.out.println("ArrayList: " + list);

        // 1. Get element
        System.out.print("Enter index to get element: ");
        int idx = sc.nextInt();
        if (idx >= 0 && idx < list.size()) {
            System.out.println("Element at " + idx + " is: " + list.get(idx));
        }

        // 2. Set / Update element
        System.out.print("Enter index and value to update: ");
        int uIdx = sc.nextInt();
        int uVal = sc.nextInt();
        if (uIdx >= 0 && uIdx < list.size()) {
            list.set(uIdx, uVal);
            System.out.println("After update: " + list);
        }

        // 3. Contains
        System.out.print("Enter value to check if contains: ");
        int check = sc.nextInt();
        System.out.println("Contains " + check + "? " + list.contains(check));

        // 4. Remove
        System.out.print("Enter index to remove: ");
        int rIdx = sc.nextInt();
        if (rIdx >= 0 && rIdx < list.size()) {
            list.remove(rIdx);
            System.out.println("After removal: " + list);
        }

        // 5. Size
        System.out.println("Final Size of ArrayList: " + list.size());

        // 6. Print using loop
        System.out.print("Final list using loop: ");
        for (int val : list) {
            System.out.print(val + " ");
        }
        
        sc.close();
    }
}