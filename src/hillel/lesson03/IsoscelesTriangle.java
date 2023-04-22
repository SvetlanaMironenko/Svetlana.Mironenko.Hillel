package hillel.lesson03;

public class IsoscelesTriangle {

    public static void main (String[] args) {
        int sideOne = 3;
        int sideTwo = 7;
        int sideThree = 7;
        if ((sideOne == sideTwo) || (sideTwo == sideThree) || (sideOne == sideThree)) {
            System.out.println("The triangle is isosceles");
        } else {
            System.out.println("The triangle is not isosceles");
        }
    }

}

