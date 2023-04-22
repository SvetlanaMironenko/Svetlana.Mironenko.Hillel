package hillel.lesson02;

public class DegreeCelsius {
    public static void main(String[] args) {
        double celsius = 26;
        double degreesFahrenheit = convertCelsiusToFahrenheit(celsius);
        double degreesKelvin = convertCelsiusToKelvin(celsius);

        System.out.println(degreesFahrenheit + " F");
        System.out.println(degreesKelvin + " K");
    }

    private static double convertCelsiusToFahrenheit(double celsius) {
        return (celsius * 9 / 5) + 32;
    }

    private static double convertCelsiusToKelvin(double celsius) {
        return celsius + 273.15;
    }
}
