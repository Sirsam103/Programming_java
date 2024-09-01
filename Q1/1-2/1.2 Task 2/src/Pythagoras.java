import java.util.Scanner;

public class Pythagoras {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the lenght of the first leg: ");
        double leg1 = scanner.nextDouble();
        System.out.print("Enter the lenght of the second leg: ");
        double leg2 = scanner.nextDouble();
        double hypotenuse = Math.sqrt((leg1 * leg1) + (leg2 * leg2));
        System.out.printf("The hypotenuse is: %.2f%n", hypotenuse);
    }
}