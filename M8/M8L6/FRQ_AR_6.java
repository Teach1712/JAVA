import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FRQ_AR_6 {

    // Recursive backtracking method
    public static void backtrack(int[] candidates, int target, int start, List<Integer> current, List<List<Integer>> result) {

        if (target == 0) {
            result.add(new ArrayList<>(current));
            return;
        }

        if (target < 0) {
            return; // exceeded target
        }

        for (int i = start; i < candidates.length; i++) {
            current.add(candidates[i]);
            // Not i+1 because same number can be used unlimited times
            backtrack(candidates, target - candidates[i], i, current, result);
            current.remove(current.size() - 1); // backtrack
        }
    }

    public static List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> result = new ArrayList<>();
        backtrack(candidates, target, 0, new ArrayList<>(), result);
        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        int[] candidates = new int[n];

        System.out.println("Enter candidates array (distinct integers):");
        for (int i = 0; i < n; i++) {
            candidates[i] = sc.nextInt();
        }

        System.out.print("Enter target: ");
        int target = sc.nextInt();

        List<List<Integer>> ans = combinationSum(candidates, target);
        System.out.println("Output: " + ans);

        sc.close();
    }
}