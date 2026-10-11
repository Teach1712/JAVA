import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PalindromePartitioning {

    // Function to check if a string is palindrome
    public static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    // Backtracking function
    public static void backtrack(String s, int start, List<String> current, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(current));
            return;
        }

        for (int end = start; end < s.length(); end++) {
            String substring = s.substring(start, end + 1);
            if (isPalindrome(substring)) {
                current.add(substring);
                backtrack(s, end + 1, current, result);
                current.remove(current.size() - 1); // backtrack
            }
        }
    }

    public static List<List<String>> partition(String s) {
        List<List<String>> result = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter String s: ");
        String s = sc.nextLine();

        List<List<String>> ans = partition(s);
        System.out.println("Output: " + ans);
        sc.close();
    }
}