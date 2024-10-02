import java.util.Arrays;
import java.util.Scanner;

public class SortingDempo {
    // ANSI escape codes for colored text
    private static final String ANSI_RESET = "\u001B[0m";
    private static final String ANSI_GREEN = "\u001B[32m";
    private static final String ANSI_YELLOW = "\u001B[33m";
    private static final String ANSI_CYAN = "\u001B[36m";
    private static final String ANSI_RED = "\u001B[31m"; // Ensure this is defined

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println(ANSI_GREEN + "Welcome to the Sorting Algorithms Demo!" + ANSI_RESET);
        System.out.println(ANSI_YELLOW + "===================================" + ANSI_RESET);

        // Get the number of elements in the array
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();
        int[] array = new int[n];

        // Get the elements of the array
        System.out.println("Enter the elements of the array:");
        for (int i = 0; i < n; i++) {
            System.out.print("Element " + (i + 1) + ": ");
            array[i] = scanner.nextInt();
        }

        // Show the menu for sorting algorithms
        System.out.println(ANSI_CYAN + "\nChoose a sorting algorithm:" + ANSI_RESET);
        System.out.println("1. Bubble Sort");
        System.out.println("2. Quick Sort");
        System.out.print("Enter your choice (1 or 2): ");
        int choice = scanner.nextInt();

        int[] sortingArray = Arrays.copyOf(array, array.length);
        long startTime, endTime;

        // Execute the chosen sorting algorithm
        if (choice == 1) {
            startTime = System.nanoTime();
            bubbleSort(sortingArray);
            endTime = System.nanoTime();
            System.out.println(ANSI_GREEN + "Bubble Sort Result: " + Arrays.toString(sortingArray) + ANSI_RESET);
            System.out.println("Execution Time: " + (endTime - startTime) + " nanoseconds");
        } else if (choice == 2) {
            startTime = System.nanoTime();
            quickSort(sortingArray, 0, sortingArray.length - 1);
            endTime = System.nanoTime();
            System.out.println(ANSI_GREEN + "Quick Sort Result: " + Arrays.toString(sortingArray) + ANSI_RESET);
            System.out.println("Execution Time: " + (endTime - startTime) + " nanoseconds");
        } else {
            System.out.println(ANSI_RED + "Invalid choice!" + ANSI_RESET);
        }

        System.out.println(ANSI_GREEN + "Thank you for using the demo!" + ANSI_RESET);
        scanner.close();
    }

    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }
}
