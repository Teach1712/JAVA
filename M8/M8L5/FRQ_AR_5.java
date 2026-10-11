import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FRQ_AR_5 {

    // Recursive backtracking method
    public static void backtrack(String s, int index, StringBuilder current, List<String> result) {
        if (index == s.length()) {
            result.add(current.toString());
            return;
        }

        char ch = s.charAt(index);

        if (Character.isLetter(ch)) {
            // Choice 1: lowercase
            current.append(Character.toLowerCase(ch));
            backtrack(s, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);

            // Choice 2: uppercase
            current.append(Character.toUpperCase(ch));
            backtrack(s, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        } else {
            // If digit, no choice, just add it
            current.append(ch);
            backtrack(s, index + 1, current, result);
            current.deleteCharAt(current.length() - 1);
        }
    }

    public static List<String> letterCasePermutation(String s) {
        List<String> result = new ArrayList<>();
        backtrack(s, 0, new StringBuilder(), result);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter string s: ");
        String s = sc.nextLine();

        List<String> ans = letterCasePermutation(s);
        System.out.println("Output: " + ans);

        sc.close();
    }
}