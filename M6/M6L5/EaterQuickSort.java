import java.util.*;

class Apple {
    int x, y, idx;
    Apple(int x, int y, int idx) {
        this.x = x;
        this.y = y;
        this.idx = idx;
    }
}

public class EaterQuickSort {

    // Quick Sort for Apple array - sort by y asc, then x asc
    public static void quickSort(Apple[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    static int partition(Apple[] arr, int low, int high) {
        Apple pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (compare(arr[j], pivot) <= 0) {
                i++;
                swap(arr, i, j);
            }
        }
        swap(arr, i + 1, high);
        return i + 1;
    }

    static int compare(Apple a, Apple b) {
        if (a.y!= b.y) return a.y - b.y;
        return a.x - b.x;
    }

    static void swap(Apple[] arr, int i, int j) {
        Apple temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter N: ");
        int n = sc.nextInt();

        Apple[] apples = new Apple[n];
        System.out.println("Enter Xi Yi for " + n + " apples:");
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            int y = sc.nextInt();
            apples[i] = new Apple(x, y, i);
        }

        // 1. Sort by row Y using Quick Sort
        quickSort(apples, 0, n - 1);

        int[] eatenBefore = new int[n];
        int eatenCount = 0;
        boolean leftToRight = true; // start at (1,1) left side

        // 2. Traverse row by row
        int i = 0;
        while (i < n) {
            int currY = apples[i].y;
            int j = i;
            // find all apples with same Y
            while (j < n && apples[j].y == currY) j++;

            // apples[i... j-1] are same row, already sorted by X asc
            // if leftToRight, eat in asc order, else desc order
            if (leftToRight) {
                for (int k = i; k < j; k++) {
                    eatenBefore[apples[k].idx] = eatenCount++;
                }
            } else {
                for (int k = j - 1; k >= i; k--) {
                    eatenBefore[apples[k].idx] = eatenCount++;
                }
            }

            // after finishing this row, you go to other end
            leftToRight =!leftToRight;
            i = j;
        }

        System.out.println("Number of apples eaten before each apple (input order):");
        for (int k = 0; k < n; k++) {
            System.out.println("Apple " + (k+1) + " at (" + apples[k].x + "," + apples[k].y + " ) -> " + eatenBefore[k]);
        }

        // Just print result array
        System.out.print("Result array: ");
        for (int v : eatenBefore) System.out.print(v + " ");

        sc.close();
    }
}