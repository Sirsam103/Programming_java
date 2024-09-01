import java.util.Random;
import java.util.Scanner;

public class MultiplicationTables {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int score;

        do {
            score = 0;
            for (int i = 0; i < 10; i++) {
                int first = random.nextInt(10) + 1;
                int second = random.nextInt(10) + 1;
                System.out.print("What is " + first + " * " + second + "? ");
                int answer = scanner.nextInt();
                if (answer == first * second) {
                    System.out.println("Correct!");
                    score++;
                } else {
                    System.out.println("Incorrect. The correct answer is " + (first * second) + ".");
                }
            }
            if (score == 10) {
                System.out.println("Congratulations! You have mastered the multiplication tables.");
            } else {
                System.out.println("You scored " + score + " out of 10. Let's try another set.");
            }
        } while (score < 10);
        scanner.close();
    }
}