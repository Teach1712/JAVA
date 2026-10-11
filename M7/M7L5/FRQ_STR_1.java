import java.util.HashMap;
import java.util.Scanner;

public class FRQ_STR_1 {

    // This is the main function you have to write in assignment
    public static void countSubstrings(String str, int k) {
        HashMap<String, Integer> map = new HashMap<>();

        if (k > str.length()) {
            System.out.println("Length k is greater than string length");
            return;
        }

        for (int i = 0; i <= str.length() - k; i++) {
            String sub = str.substring(i, i + k);
            map.put(sub, map.getOrDefault(sub, 0) + 1);
        }

        System.out.println("Substrings of length " + k + ":");
        for (String s : map.keySet()) {
            System.out.println(s + " -> " + map.get(s));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        String str = sc.nextLine();
        System.out.print("Enter length k: ");
        int k = sc.nextInt();
        
        countSubstrings(str, k);
        sc.close();
    }
}