import java.util.Arrays;

public class BeadSort {

    static long comparisons = 0;
    static long swaps = 0;

    public static void beadSortDescending(int[] arr) {

        int max = 0;

        // Find maximum value
        for (int num : arr) {
            comparisons++;
            if (num > max) {
                max = num;
            }
        }

        int[][] beads = new int[arr.length][max];

        // Place beads
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i]; j++) {
                beads[i][j] = 1;
                swaps++;
            }
        }

        // Simulate gravity
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

        // Count beads to get sorted numbers
        for (int i = 0; i < arr.length; i++) {
            int count = 0;

            for (int j = 0; j < max; j++) {
                comparisons++;
                count += beads[i][j];
            }

            arr[i] = count;
        }

        // Reverse for descending
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[arr.length - i - 1];
            arr[arr.length - i - 1] = temp;
            swaps++;
        }

    }

    public static void main(String[] args) {

        int[] numbers = {5, 3, 1, 7, 4};

        System.out.println("Original Array:");
        System.out.println(Arrays.toString(numbers));

        beadSortDescending(numbers);

        System.out.println("\nSorted Array (Descending):");
        System.out.println(Arrays.toString(numbers));

        System.out.println("\nComparisons: " + comparisons);
        System.out.println("Swaps: " + swaps);
    }
}