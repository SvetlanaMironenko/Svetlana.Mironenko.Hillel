package hillel.lesson04;

public class DegreeTable {

    public static void main (String[] args) {
        for (int i = 0; i <= 360; i = i + 10) {
            double radians = Math.toRadians(i);
            String res = String.format("%.3f", Math.sin(radians));
            System.out.println(("Sine degrees for an angle " + i + " is " + res));
        }
    }
}
