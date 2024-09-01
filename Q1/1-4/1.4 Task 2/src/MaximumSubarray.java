import java.util.Scanner;

public class MaximumSubarray {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int max = Integer.MIN_VALUE;
        int current = 0;
        int start = 0;
        int end = 0;
        int temp = 0;

        System.out.print("Enter the size of the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];
        System.out.println("Enter the integers into the array: ");
        for (int i = 0; i < n; i++) {
            System.out.print("Enter integer:");
            array[i] = scanner.nextInt();
        }
        
        for (int i = 0; i < n; i++) {
            current += array[i];
            if (current > max) {
                max = current;
                start = temp;
                end = i;
            }
            if (current < 0) {
                current = 0;
                temp = i + 1;
            }
        }
        System.out.println("Maximum sum: " + max);
        System.out.println("Integers: " + (start + 1) + "-" + (end + 1));
    }
}