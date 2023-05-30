package hillel.lesson03;

public class AbsoluteValues {
    public static void main(String[] args) {
        int value1 = 3;
        int value2 = -9;

        int value1Absolute = Math.abs(value1);
        int value2Absolute = Math.abs(value2);

        if (value1Absolute < value2Absolute) {
            System.out.println("Absolute value of '" + value1 + "' < '" + value2 + "'");
        } else if (value1Absolute > value2Absolute) {
            System.out.println("Absolute value of '" + value1 + "' > '" + value2 + "'");
        } else {
            System.out.println("Absolutes values of " + value1 + "and" + value2 + " are equals");
        }
    }

}
