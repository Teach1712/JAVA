import java.util.ArrayList;
import java.util.Scanner;

public class StringCall {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Character> charList = new ArrayList<>();

        System.out.print("Enter number of characters: ");
        int n = sc.nextInt();

        System.out.println("Enter " + n + " characters:");
        for (int i = 0; i < n; i++) {
            char c = sc.next().charAt(0);
            charList.add(c);
        }

        // 1. Construct String from ArrayList
        StringBuilder sb = new StringBuilder();
        for (char c : charList) {
            sb.append(c);
        }
        String originalString = sb.toString();
        System.out.println("\nOriginal Generated String: " + originalString);

        // 2. Find its Length
        int length = originalString.length();
        System.out.println("Length of String: " + length);

        // 3. Find its Reverse
        String reverseString = sb.reverse().toString();
        System.out.println("Reverse of String: " + reverseString);

        // 4. Make two words of equal length from original string
        if (length % 2 == 0) {
            String word1 = originalString.substring(0, length / 2);
            String word2 = originalString.substring(length / 2);
            System.out.println("Word 1: " + word1);
            System.out.println("Word 2: " + word2);
        } else {
            System.out.println("String length is odd, cannot make two equal words.");
            System.out.println("You can make: '" + originalString.substring(0, length/2) + "' and '" + originalString.substring(length/2) + "' (almost equal)");
        }
        sc.close();
    }
}