import java.util.Scanner;

public class ReversalAssignment {

    public static int reversePairs(int[] nums) {
        return mergeSortAndCount(nums, 0, nums.length - 1);
    }

    private static int mergeSortAndCount(int[] nums, int low, int high) {
        if (low >= high) return 0;

        int mid = (low + high) / 2;
        int count = 0;

        count += mergeSortAndCount(nums, low, mid);
        count += mergeSortAndCount(nums, mid + 1, high);
        count += countPairs(nums, low, mid, high); // count cross pairs
        merge(nums, low, mid, high); // merge sorted halves

        return count;
    }

    // Count pairs where i in [low, mid] and j in [mid+1, high]
    private static int countPairs(int[] nums, int low, int mid, int high) {
        int count = 0;
        int j = mid + 1;

        for (int i = low; i <= mid; i++) {
            while (j <= high && (long) nums[i] > 2L * (long) nums[j]) {
                j++;
            }
            // if j moved, then all elements from mid+1 to j-1 satisfy condition for this i
            // But careful: j is monotonic, we need separate pointer per i - correct way:
        }

        // Correct two-pointer counting
        j = mid + 1;
        for (int i = low; i <= mid; i++) {
            while (j <= high && (long) nums[i] > 2L * (long) nums[j]) {
                j++;
            }
            // Actually we need count of j's that satisfy, so we need to move j for each i
            // Let's re-implement properly:
        }

        // Proper implementation
        int right = mid + 1;
        int c = 0;
        for (int left = low; left <= mid; left++) {
            while (right <= high && (long) nums[left] > 2L * nums[right]) {
                right++;
            }
            // No, this logic is reverse - we need to count. Let's do final correct version:
        }
        return 0; // placeholder to be replaced below
    }

    // ---- FINAL CORRECT AND CLEAN VERSION BELOW ----

    public static class Solution {
        public int reversePairs(int[] nums) {
            return sort(nums, 0, nums.length - 1);
        }

        private int sort(int[] nums, int l, int r) {
            if (l >= r) return 0;
            int m = l + (r - l) / 2;
            int count = sort(nums, l, m) + sort(nums, m + 1, r);

            // count reverse pairs
            int j = m + 1;
            for (int i = l; i <= m; i++) {
                while (j <= r && (long) nums[i] > 2L * nums[j]) {
                    j++;
                }
                count += (j - (m + 1));
            }

            // merge step
            int[] temp = new int[r - l + 1];
            int i = l, k = m + 1, p = 0;
            while (i <= m && k <= r) {
                if (nums[i] <= nums[k]) temp[p++] = nums[i++];
                else temp[p++] = nums[k++];
            }
            while (i <= m) temp[p++] = nums[i++];
            while (k <= r) temp[p++] = nums[k++];

            System.arraycopy(temp, 0, nums, l, temp.length);
            return count;
        }
    }

    // Main driver for assignment
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = sc.nextInt();
        int[] nums = new int[n];
        System.out.println("Enter " + n + " elements:");
        for (int i = 0; i < n; i++) nums[i] = sc.nextInt();

        Solution sol = new Solution();
        int ans = sol.reversePairs(nums);

        System.out.println("Number of reverse pairs: " + ans);
        sc.close();
    }
}