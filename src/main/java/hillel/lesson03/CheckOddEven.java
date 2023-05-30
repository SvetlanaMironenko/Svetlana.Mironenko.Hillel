package hillel.lesson03;

import java.util.Scanner;

public class CheckOddEven {

    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        System.out.println("Enter number");
        int value = number.nextInt();
//        int value = 10;
        checkOddOrEven(value);
        System.out.println("BYE");
    }

    public static void checkOddOrEven(int value) {
        if ((value % 2) == 0) {
            System.out.println("The '" + value + "' is even number");
        } else {
            System.out.println("The '" + value + "' is odd number");
        }
    }

}
