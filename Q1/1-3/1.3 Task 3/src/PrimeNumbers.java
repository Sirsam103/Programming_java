import java.util.Scanner;

public class PrimeNumbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean found = false;

        System.out.print("Enter the first value: ");
        int first = scanner.nextInt();
        System.out.print("Enter the second value: ");
        int second = scanner.nextInt();

        if (first < 2) first = 2;
        if (first >= second) {
            int temp = first;
            first = second;
            second = temp;
        }
        System.out.println("Prime numbers between " + first + " and " + second + ":");

        for (int i = first; i <= second; i++) {
            if (isPrime(i)) {
                System.out.println(i + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.println("There are no prime numbers between " + first + " and " + second);
        }
    }
    public static boolean isPrime(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}