import java.util.Scanner;

public class UniqueArray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int unique = 0;

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the integers into the array: ");

        for (int i = 0; i < n; i++) {
            System.out.print("Enter integer:");
            int temp = scanner.nextInt();
            boolean isDuplicate = false;

            for (int j : array) {
                if (temp == j) {
                    isDuplicate = true;
                    break;
                }
            }
            if (!isDuplicate) {
                array[unique] = temp;
                unique++;
            }
        }
        System.out.println("The array without duplicates: ");
        for (int k = 0; k < unique; k++) {
            System.out.print(array[k] + " ");
        }
    }
}