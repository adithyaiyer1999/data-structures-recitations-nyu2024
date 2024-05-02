package sortingAlgos;

public class MergeSort {

    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = (left + right) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;

        int[] L = new int[n1];
        int[] R = new int[n2];

        for (int i = 0; i < n1; ++i)
            L[i] = arr[left + i];
        for (int j = 0; j < n2; ++j)
            R[j] = arr[mid + 1 + j];

        int i = 0, j = 0;
        int k = left;

        while (i < n1 && j < n2) {
            if (L[i] <= R[j]) {
                arr[k] = L[i];
                i++;
            } else {
                arr[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n1) {
            arr[k] = L[i];
            i++;
            k++;
        }

        while (j < n2) {
            arr[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] array1 = {10, 7, 8, 9, 1, 5};
        System.out.println("Initial array1: ");
        for (int num : array1) {
            System.out.print(num + " ");
        }
        System.out.println();
        mergeSort(array1, 0, array1.length - 1);
        System.out.println("Sorted array1: ");
        for (int num : array1) {
            System.out.print(num + " ");
        }
        System.out.println();

        int[] array2 = {102, 24, 3, 44, 183, 22};
        System.out.println("Initial array2: ");
        for (int num : array1) {
            System.out.print(num + " ");
        }
        System.out.println();
        mergeSort(array2, 0, array2.length - 1);
        System.out.println("Sorted array2: ");
        for (int num : array2) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
