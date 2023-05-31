package hillel.lesson02;

public class SquareCircle {

    public static void main(String[] args) {
        double radius = 2.5;
        double square = squareOfCircle(radius);
        System.out.println("Square circle is " + String.format("%.2f", square));

        String str = "sdfsf";
        str = str.toUpperCase();
    }

    private static double squareOfCircle(double radius) {
        return Math.PI * radius * radius;
    }
}
