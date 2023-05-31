package hillel.lesson02;
import java.util.Scanner;

public class SquareOfATriangle {
    public static void main(String[] args) {
        Scanner number = new Scanner(System.in);
        System.out.println("Enter length");
        double height = number.nextDouble();
        System.out.println("Enter Height");
        double length = number.nextDouble();
        double squareTriangle = squareOfATriangle(height, length);
        System.out.println("Square of a triangle: " + squareTriangle);
    }

    private static double squareOfATriangle(double height, double length) {
        return (height * length) / 2;
    }
}
