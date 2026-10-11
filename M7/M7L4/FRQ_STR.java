import java.util.HashMap;
import java.util.Scanner;

public class FRQ_STR {
    public static void countSubstrings(String str, int k) {
        HashMap<String, Integer> freqMap = new HashMap<>();
        for (int i = 0; i <= str.length() - k; i++) {
            String sub = str.substring(i, i + k);
            freqMap.put(sub, freqMap.getOrDefault(sub, 0) + 1);
        }
        for (String key : freqMap.keySet()) {
            System.out.println(key + " -> " + freqMap.get(key));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String: ");
        String str = sc.nextLine();
        System.out.print("Enter length k: ");
        int k = sc.nextInt();
        countSubstrings(str, k);
    }
}