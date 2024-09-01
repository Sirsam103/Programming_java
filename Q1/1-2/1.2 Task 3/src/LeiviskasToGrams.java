import java.util.Scanner;

public class LeiviskasToGrams {
    public static void main(String[] args) {
        double gramsPerLuoti = 13.28;
        int luotiPerNaula = 32;
        int naulaPerLeiviska = 20;

        Scanner scanner = new Scanner(System.in);
        System.out.print("Weight (g): ");
        double grams = scanner.nextDouble();


        double totalLuoti = grams / gramsPerLuoti;
        int leiviska = (int) (totalLuoti / (luotiPerNaula * naulaPerLeiviska));
        int naula = (int) (totalLuoti / luotiPerNaula) % naulaPerLeiviska;
        double luoti = totalLuoti % luotiPerNaula;
        System.out.printf("%.0f grams is %d leiviskä, %d naula, and %.2f luoti.%n", grams, leiviska, naula, luoti);
    }
}