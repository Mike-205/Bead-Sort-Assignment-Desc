import java.util.*;

public class BeadSort {

    public static long comparisons = 0;
    public static long swaps = 0;

    public static void beadSortDescending(int[] arr) {

        int max = 0;

        for (int num : arr) {
            comparisons++;
            if (num > max) {
                max = num;
            }
        }

        int[][] beads = new int[arr.length][max];

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                beads[i][j] = 1;
                swaps++;
            }
        }

        for (int j = 0; j < max; j++) {

            int sum = 0;

            for (int i = 0; i < arr.length; i++) {
                comparisons++;
                sum += beads[i][j];
                beads[i][j] = 0;
            }

            for (int i = arr.length - sum; i < arr.length; i++) {
                beads[i][j] = 1;
                swaps++;
            }
        }

        for (int i = 0; i < arr.length; i++) {

            int count = 0;

            for (int j = 0; j < max; j++) {
                comparisons++;
                count += beads[i][j];
            }

            arr[i] = count;
        }

        for (int i = 0; i < arr.length / 2; i++) {

            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;

            swaps++;
        }
    }
}