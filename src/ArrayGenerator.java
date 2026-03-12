import java.util.Random;

/*
 * ArrayGenerator
 * ---------------
 * Utility class responsible for generating arrays of random integers.
 * These arrays are used as input for testing the performance of the
 * Bead Sort algorithm on different dataset sizes.
 */
public class ArrayGenerator {

    /*
     * Generates an array of random integers.
     *
     * @param size The number of elements to generate.
     * @return An integer array filled with random values.
     *
     * Note:
     * The values are limited (0–99) to prevent excessive memory usage
     * since Bead Sort internally creates a bead matrix whose width
     * depends on the maximum value in the input array.
     */
    public static int[] generateRandomArray(int size) {

        Random rand = new Random();

        // Create array with the requested size
        int[] arr = new int[size];

        // Fill the array with random integers
        for(int i = 0; i < size; i++){
            arr[i] = rand.nextInt(100);
        }

        return arr;
    }
}