import java.util.HashMap;
import java.util.Scanner;

public class CountFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Email Id: ");
        String email = sc.nextLine();

        HashMap<Character, Integer> freq = new HashMap<>();

        for (int i = 0; i < email.length(); i++) {
            char ch = email.charAt(i);
            // Check if character is NOT an alphabet (i.e., numeric or special)
            if (!Character.isLetter(ch)) {
                if (freq.containsKey(ch)) {
                    freq.put(ch, freq.get(ch) + 1);
                } else {
                    freq.put(ch, 1);
                }
            }
        }

        System.out.println("Output:");
        for (char key : freq.keySet()) {
            System.out.println(key + " -> " + freq.get(key));
        }
        sc.close();
    }
}