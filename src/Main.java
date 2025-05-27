import java.util.Random;
import java.util.Scanner;

/**
 * This program generates random numbers between 0-999.
 * The user can input how many random numbers to generate.
 * The random numbers are displayed, sorted by even and odd,
 * Numbers are sorted in ascending and descending order.
 * @author danmas-4
 */
public class Main {
    public static final String INVALID_INPUT_MESSAGE = "Invalid Input";
    public static final int MAX_ALLOWED = 1000;

    public static void main(final String[] args) {
        Scanner scanner = new Scanner(System.in);
        int count;

        while (true) {
            System.out.print("How many random numbers in the range 0 - 999 are desired? ");
            try {
                String input = scanner.nextLine();
                count = Integer.parseInt(input);

                if (count < 1 || count > MAX_ALLOWED) {
                    System.out.println(INVALID_INPUT_MESSAGE);
                } else {
                    break;
                }

            } catch (NumberFormatException e) {
                System.out.println(INVALID_INPUT_MESSAGE);
            }
        }

        try {
            int[] numbers = new int[count];
            int[] even = new int[count];
            int[] odd = new int[count];
            int evenCount = 0;
            int oddCount = 0;

            Random rand = new Random();

            for (int i = 0; i < count; i++) {
                numbers[i] = rand.nextInt(MAX_ALLOWED); // 0-999
            }

            // Print random numbers
            System.out.println("\nHere are the random numbers:");
            for (int num : numbers) {
                System.out.print(num + " ");
            }
            System.out.println();

            // Split into even and odd
            for (int num : numbers) {
                if (num % 2 == 0) {
                    even[evenCount++] = num;
                } else {
                    odd[oddCount++] = num;
                }
            }

            // Sort them
            sortAscending(even, evenCount);
            sortDescending(odd, oddCount);

            // Print sorted results
            System.out.println("\nHere are the random numbers arranged:");
            if (evenCount == 0) {
                System.out.print("No Even Numbers - ");
            } else {
                for (int i = 0; i < evenCount; i++) {
                    System.out.print(even[i] + " ");
                }
                System.out.print("- ");
            }

            if (oddCount == 0) {
                System.out.println("No Odd Numbers");
            } else {
                for (int i = 0; i < oddCount; i++) {
                    System.out.print(odd[i] + " ");
                }
                System.out.println();
            }

            // Final count message (required format)
            System.out.println("\nOf the above " + count + " numbers, " + evenCount + " were even and " + oddCount + " odd");

        } catch (OutOfMemoryError e) {
            System.out.println("The system cannot allocate enough memory for " + count + " numbers.");
        }
    }

    /**
     * Sorts the array in ascending order.
     *@param array - Numbers stored here
     *@param length - Amount of numbers in array
     */
    private static void sortAscending(final int[] array, final int length) {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }

    /**
     * Sorts the array in descending order.
     *@param array - Numbers stored here
     *@ length - Amount of numbers in array
     */
    private static void sortDescending(final int[] array, final int length) {
        for (int i = 0; i < length - 1; i++) {
            for (int j = 0; j < length - i - 1; j++) {
                if (array[j] < array[j + 1]) {
                    int temp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = temp;
                }
            }
        }
    }
}
