import java.util.Arrays;

public class ExperimentRunner {

    public static void main(String[] args) {

        int[] example = {5,3,1,7,4};

        System.out.println("Example Run");

        System.out.println("Original:");
        System.out.println(Arrays.toString(example));

        BeadSort.beadSortDescending(example);

        System.out.println("\nSorted (Descending):");
        System.out.println(Arrays.toString(example));

        System.out.println("\nComparisons: " + BeadSort.comparisons);
        System.out.println("Swaps: " + BeadSort.swaps);

        runExperiments();
    }

    public static void runExperiments() {

        int[] testSizes = {
                1,2,3,4,5,10,250,999,9999,89786,789300,1780000
        };

        System.out.printf("%-12s %-15s %-15s %-15s\n",
                "Size","Comparisons","Swaps","Time(ns)");

        System.out.println("-------------------------------------------------------");

        for(int size : testSizes){

            int[] arr = ArrayGenerator.generateRandomArray(size);

            BeadSort.comparisons = 0;
            BeadSort.swaps = 0;

            long start = System.nanoTime();

            BeadSort.beadSortDescending(arr);

            long end = System.nanoTime();

            long timeTaken = end - start;

            System.out.printf("%-12d %-15d %-15d %-15d\n",
                    size,
                    BeadSort.comparisons,
                    BeadSort.swaps,
                    timeTaken);
        }
    }
}