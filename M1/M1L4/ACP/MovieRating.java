import java.util.Scanner;

public class MovieRating {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Enter movie rating count: ");
        int rating = sc.nextInt();
        
        if(rating > 75000) {
            System.out.println("Classification: Out of the World");
        }
        else if(rating > 45000 && rating < 70000) {
            System.out.println("Classification: Best");
        }
        else if(rating > 25000) {
            System.out.println("Classification: Better");
        }
        else if(rating > 5000) {
            System.out.println("Classification: Good");
        }
        else {
            System.out.println("Classification: Below Good");
        }
        
        sc.close();
    }
}