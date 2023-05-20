package hillel.lesson12;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ThreeBaskets {

    public static void main(String[] args) {
        List<Integer> listNumbers = new ArrayList<>();
        Random random = new Random();
        for (int i = 0; i < 100; i++) {
            listNumbers.add(random.nextInt(60));
        }
        System.out.println("Random array " + listNumbers);
        distributionNumbers(listNumbers);
    }

    private static void distributionNumbers(List<Integer> sourceListNumbers) {
        List<Integer> numberAreDivisibleBy2 = new ArrayList<>();
        List<Integer> numberAreDivisibleBy3 = new ArrayList<>();
        List<Integer> otherNumbers = new ArrayList<>();
        for (Integer curNumber : sourceListNumbers) {
            if ((curNumber % 2) == 0) {
                numberAreDivisibleBy2.add(curNumber);
            }
            if ((curNumber % 3) == 0) {
                numberAreDivisibleBy3.add(curNumber);
            }
            if (!((curNumber % 2) == 0 || (curNumber % 3) == 0)) {
                otherNumbers.add(curNumber);
            }
        }
        System.out.println("The divisible by 2 " + numberAreDivisibleBy2);
        System.out.println("The divisible by 3 " + numberAreDivisibleBy3);
        System.out.println("The other numbers " + otherNumbers);
    }
}
