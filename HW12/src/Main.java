import java.util.Arrays;

public class Main {

    public static void main(String[] args) {

        int[] arrayOne = {9, 4, 7, 1, 3, 6, 5};
        int[] arrayTwo = {4, 8, 2, 6, 1, 9, 7, 5, 3};

        quickSort(arrayOne, 0, arrayOne.length - 1);
        System.out.println("\nresult of quickSort():");
        System.out.println(Arrays.toString(arrayOne));

        System.out.println("\nresult of shakerSort():");
        shakerSort(arrayTwo);
        System.out.printf(Arrays.toString(arrayTwo));
    }

    public static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int pivotIndex = partition(arr, left, right);
            quickSort(arr, left, pivotIndex - 1);
            quickSort(arr, pivotIndex + 1, right);
        }
    }

    public static int partition(int[] arr, int left, int right) {
        int pivot = arr[right];
        int i = left - 1;
        for (int j = left; j < right; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[right];
        arr[right] = temp;
        return i + 1;
    }

    public static void shakerSort(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        while (left <= right) {
            for (int i = left; i < right; i++) {
                if (arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            right--;
            for (int i = right; i > left; i--) {
                if (arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
            left++;
        }
    }
}