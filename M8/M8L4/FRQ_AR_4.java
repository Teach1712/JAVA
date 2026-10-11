import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Scanner;

public class FRQ_AR_4 {

    // Method to return unique elements as a NEW ArrayList
    public static ArrayList<String> findUniqueElements(ArrayList<String> inputList) {
        // LinkedHashSet removes duplicates and keeps order
        LinkedHashSet<String> set = new LinkedHashSet<>(inputList);
        
        // Creating a NEW ArrayList (not a reference to input)
        ArrayList<String> uniqueList = new ArrayList<>(set);
        
        return uniqueList;
    }

    // Alternative logic without using Set (using only loops - if teacher asks)
    public static ArrayList<String> findUniqueElementsWithoutSet(ArrayList<String> inputList) {
        ArrayList<String> uniqueList = new ArrayList<>();
        for (String s : inputList) {
            if (!uniqueList.contains(s)) {
                uniqueList.add(s);
            }
        }
        return uniqueList;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of strings: ");
        int n = sc.nextInt();
        sc.nextLine(); // consume newline

        ArrayList<String> list = new ArrayList<>();
        System.out.println("Enter " + n + " strings:");
        for (int i = 0; i < n; i++) {
            list.add(sc.nextLine());
        }

        ArrayList<String> result = findUniqueElements(list);

        System.out.println("Input List: " + list);
        System.out.println("Unique List (new ArrayList): " + result);
        System.out.println("Are both list same reference? " + (list == result)); // should be false

        sc.close();
    }
}