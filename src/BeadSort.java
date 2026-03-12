import java.util.*;

public class BeadSort {

    // Counters to track algorithm operations
    public static long comparisons = 0;
    public static long swaps = 0;

    // Step 1: Find the maximum value in the array.
    // This determines the number of columns in the bead grid.
    public static void beadSortDescending(int[] arr) {

        int max = 0;

        for (int num : arr) {
            comparisons++;
            if (num > max) {
                max = num;
            }
        }

        // Step 2: Create a 2D bead matrix.
        // Rows represent numbers in the array
        // Columns represent bead positions
        int[][] beads = new int[arr.length][max];

        // Step 3: Place beads in the grid.
        // Each number is represented by that many beads in its row.
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                beads[i][j] = 1;
                swaps++; // counting bead placements as movements
            }
        }

        // Step 4: Simulate gravity.
        // Beads fall downward within each column.
        for (int j = 0; j < max; j++) {

            int sum = 0;

            // Count how many beads exist in this column
            for (int i = 0; i < arr.length; i++) {
                comparisons++;
                sum += beads[i][j];
                beads[i][j] = 0; // clear the column
            }

            // Place beads at the bottom of the column
            for (int i = arr.length - sum; i < arr.length; i++) {
                beads[i][j] = 1;
                swaps++;
            }
        }

        // Step 5: Convert bead rows back into integer values.
        // The number of beads in each row corresponds to the sorted value.
        for (int i = 0; i < arr.length; i++) {

            int count = 0;

            for (int j = 0; j < max; j++) {
                comparisons++;
                count += beads[i][j];
            }

            arr[i] = count;
        }

        // Step 6: Reverse the array to produce descending order.
        for (int i = 0; i < arr.length / 2; i++) {

            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;

            swaps++;
        }
    }
}