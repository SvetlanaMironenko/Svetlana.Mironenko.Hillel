package hillel.lesson08;

public class Logger {

    private static void printMessage(Color currentColor, String messageHeader, String message) {
        System.out.println(currentColor.getColor() + "[" + messageHeader + "]: " + message + Color.RESET.getColor());
    }

    public static void debug(String message) {
        printMessage(Color.BLUE, "DEBUG", message);
    }

    public static void error(String message) {
        printMessage(Color.RED, "ERROR", message);
    }

    public static void info(String message) {
        printMessage(Color.GREEN, "INFO", message);
    }

    public static void warning(String message) {
        printMessage(Color.YELLOW, "WARNING", message);
    }

}
