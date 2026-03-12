import java.util.Random;

public class ArrayGenerator {

    public static int[] generateRandomArray(int size) {

        Random rand = new Random();
        int[] arr = new int[size];

        for(int i = 0; i < size; i++){
            arr[i] = rand.nextInt(100);
        }

        return arr;
    }
}