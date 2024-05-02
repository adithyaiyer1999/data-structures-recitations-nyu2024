package sortingAlgos;

public class QuickSort {

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            quickSort(arr, low, pi - 1);
            quickSort(arr, pi + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = (low - 1);
        for (int j = low; j < high; j++) {
            if (arr[j] <= pivot) {
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

    public static void main(String[] args) {
        int[] array1 = {10, 7, 8, 9, 1, 5};
        System.out.println("Initial array1: ");
        for (int num : array1) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        quickSort(array1, 0, array1.length - 1);
        System.out.println("Sorted array1: ");
        for (int num : array1) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] array2 = {102, 24, 3, 44, 183, 22};
        System.out.println("Initial array2: ");
        for (int num : array2) {
            System.out.print(num + " ");
        }
        System.out.println();
        quickSort(array2, 0, array2.length - 1);
        System.out.println("Sorted array2: ");
        for (int num : array2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

