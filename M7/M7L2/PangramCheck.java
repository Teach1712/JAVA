import java.util.Scanner;

public class PangramCheck {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a String: ");
        String str = sc.nextLine();
        
        // Convert to lowercase to check easily
        str = str.toLowerCase();
        
        boolean isPangram = true;
        
        // Check for every character from 'a' to 'z'
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (str.indexOf(ch) == -1) {
                isPangram = false;
                break;
            }
        }
        
        if (isPangram) {
            System.out.println("Output: is a Pangram");
        } else {
            System.out.println("Output: is NOT a Pangram");
        }
        sc.close();
    }
}