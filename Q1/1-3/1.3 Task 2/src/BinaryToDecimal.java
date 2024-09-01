import java.util.Scanner;

public class BinaryToDecimal {
    public static void main(String[] args) {
        int decimal = 0;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a binary number: ");
        String binary = scanner.nextLine();

        for (int i = 0; i < binary.length(); i++) {
            char bit = binary.charAt(i);
            decimal = decimal * 2 + (bit - '0');
        }
        System.out.println("The decimal equivalent is: " + decimal);
    }
}