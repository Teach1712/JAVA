import java.util.Scanner;

public class FRQ_AR_3 {

    // Method to find second largest element
    public static int findSecondLargest(int[] arr) {
        if (arr.length < 2) {
            return -1;
        }

        int largest = Integer.MIN_VALUE;
        int secondLargest = Integer.MIN_VALUE;

        for (int num : arr) {
            if (num > largest) {
                secondLargest = largest;
                largest = num;
            } else if (num > secondLargest && num!= largest) {
                secondLargest = num;
            }
        }

        // If all elements are same, there is no second largest
        if (secondLargest == Integer.MIN_VALUE) {
            return -1;
        }

        return secondLargest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int result = findSecondLargest(arr);
        System.out.println("Second Largest element is: " + result);

        sc.close();
    }
}