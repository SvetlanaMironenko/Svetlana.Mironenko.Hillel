package hillel.lesson04;

import java.util.Arrays;
import java.util.Random;

public class RandomIntegers {
    private static int[] arrValues = new int[10];

    public static void main(String[] args) {
        fillMyArray();
        System.out.println("Random array " + Arrays.toString(arrValues));
        replaceEvensValues();
        System.out.println("Even numbers are replaced by zero " + Arrays.toString(arrValues));
    }

    public static void fillMyArray() {
        Random random = new Random();
        for (int i = 0; i < 10; i++) {
            int randomValue = random.nextInt(10);
            arrValues[i] = randomValue;
        }
    }

    public static void replaceEvensValues() {
        for (int i = 0; i < 10; i++) {
            if (arrValues[i] % 2 == 0) {
                arrValues[i] = 0;
            }
        }
    }
}
