package hillel.lesson04;

import java.util.Arrays;
import java.util.Random;

public class ArithmeticMean {

    public static void main(String[] args) {
        int[] arrValues = new int[20];
        fillMyArray(arrValues);
        System.out.println("My random array " + Arrays.toString(arrValues));
        double averageValue = averageValueOfArray(arrValues);
        System.out.println("Arithmetic Mean " + averageValue);
    }

    public static void fillMyArray(int[] arrayToFill) {
        Random random = new Random();
        for (int i = 0; i < arrayToFill.length; i++) {
            int randomValue = random.nextInt(10);
            arrayToFill[i] = randomValue;
        }
    }
    public static double averageValueOfArray(int[] myArray) {
        int sum = 0;
        for (int i = 0; i < myArray.length; i++) {
            sum = sum + myArray[i];
        }
        return sum / myArray.length;
    }
}
