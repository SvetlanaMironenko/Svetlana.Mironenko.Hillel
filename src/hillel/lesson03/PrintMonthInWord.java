package hillel.lesson03;

public class PrintMonthInWord {

    public static void main(String[] args) {
        System.out.println("Month of the Year by Switch-Case:");
        monthOfTheYearSwitchCase(5);
        System.out.println("Month of the Year by If-Else:");
        int numberMonth = 1;
        String month = monthOfTheYearIfElse(numberMonth);
        System.out.println(month);
        System.out.println("BYE");
    }

    public static void monthOfTheYearSwitchCase(int month) {
        switch (month) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
            default:
                System.out.println("Not a valid month");
        }
    }

    public static String monthOfTheYearIfElse(int numberMonth) {
        if (numberMonth == 1) {
            return "January";
        } else if (numberMonth == 2) {
            return "February";
        } else if (numberMonth == 3) {
            return "March";
        } else if (numberMonth == 4) {
            return "April";
        } else if (numberMonth == 5) {
            return "May";
        } else if (numberMonth == 6) {
            return "June";
        } else if (numberMonth == 7) {
            return "July";
        } else if (numberMonth == 8) {
            return "August";
        } else if (numberMonth == 9) {
            return "September";
        } else if (numberMonth == 10) {
            return "October";
        } else if (numberMonth == 11) {
            return "November";
        } else if (numberMonth == 12) {
            return "December";
        } else {
            System.out.println("Not a valid month");
            return "";
        }
    }
}
