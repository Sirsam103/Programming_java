import java.util.Random;
import java.util.Scanner;

public class RandomNames {
    public static void main(String[] args) {
        String[] first = {"Matti", "Anna", "Juhani", "Maria", "Mikko", "Liisa", "Pekka", "Kati", "Heikki", "Sari", "Olli", "Elina", "Ari", "Eeva", "Juha", "Kirsti", "Tapio", "Hanna", "Eero", "Minna"};
        String[] last = {"Niemi", "Virtanen", "Korhonen", "Mäkinen", "Laine", "Koskinen", "Hämäläinen", "Salminen", "Järvinen", "Ollila", "Hakkarainen", "Lehtonen", "Räsänen", "Alonen", "Salo", "Päivinen", "Kallio", "Mäkelä", "Laitinen", "Niskanen"};
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();

        System.out.print("How many random names would you like to generate? ");
        int amount = scanner.nextInt();
        System.out.println("\nGenerated Names:");

        for (int i = 0; i < amount; i++) {
            System.out.println(first[random.nextInt(first.length)] + " " + last[random.nextInt(last.length)]);
        }
        scanner.close();
    }
}