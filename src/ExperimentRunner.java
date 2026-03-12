import java.util.Arrays;

/*
 * ExperimentRunner
 * ----------------
 * This class serves as the entry point of the program.
 * It performs two main tasks:
 *
 * 1. Demonstrates the Bead Sort algorithm using a small example array.
 * 2. Runs performance experiments on arrays of various sizes and records:
 *      - Number of comparisons
 *      - Number of swaps/movements
 *      - Execution time
 *
 * These experiments help analyze the algorithm's behavior as the input size grows.
 */
public class ExperimentRunner {

    public static void main(String[] args) {

        // Example dataset to demonstrate how the algorithm works
        int[] example = {5,3,1,7,4};

        System.out.println("Example Run");

        System.out.println("Original:");
        System.out.println(Arrays.toString(example));

        // Execute bead sort
        BeadSort.beadSortDescending(example);

        System.out.println("\nSorted (Descending):");
        System.out.println(Arrays.toString(example));

        // Display statistics collected during sorting
        System.out.println("\nComparisons: " + BeadSort.comparisons);
        System.out.println("Swaps: " + BeadSort.swaps);

        // Run large-scale performance experiments
        runExperiments();
    }

    /*
     * Runs the bead sort algorithm on arrays of different sizes
     * as specified in the assignment instructions.
     *
     * For each input size, the program:
     *  - Generates a random array
     *  - Runs the sorting algorithm
     *  - Measures execution time
     *  - Prints comparisons and swaps
     */
    public static void runExperiments() {

        int[] testSizes = {
                1,2,3,4,5,10,250,999,9999,89786,789300,1780000
        };

        System.out.printf("%-12s %-15s %-15s %-15s\n",
                "Size","Comparisons","Swaps","Time(ns)");

        System.out.println("-------------------------------------------------------");

        for(int size : testSizes){

            // Generate random dataset
            int[] arr = ArrayGenerator.generateRandomArray(size);

            // Reset algorithm counters before each run
            BeadSort.comparisons = 0;
            BeadSort.swaps = 0;

            // Start execution timer
            long start = System.nanoTime();

            // Run sorting algorithm
            BeadSort.beadSortDescending(arr);

            // Stop execution timer
            long end = System.nanoTime();

            long timeTaken = end - start;

            // Print experiment results
            System.out.printf("%-12d %-15d %-15d %-15d\n",
                    size,
                    BeadSort.comparisons,
                    BeadSort.swaps,
                    timeTaken);
        }
    }
}