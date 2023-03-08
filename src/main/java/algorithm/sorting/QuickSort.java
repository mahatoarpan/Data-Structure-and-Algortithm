package algorithm.sorting;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
        quickSort(arr, 0, arr.length-1);
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

    public static void quickSort(int[] arr, int low, int high) {
        if (low < high) {
            int partitionIndex = partition(arr, low, high);
            quickSort(arr, low, partitionIndex - 1);
            quickSort(arr, partitionIndex + 1, high);
        }
    }

    public static int partition(int[] arr, int low, int high) {
        int pivot = low;
        int i = low;
        int j = high;
        while (i <= j) {
            while (arr[i] <= arr[pivot] && i <= high - 1) {
                i++;
            }
            while (arr[j] > arr[pivot] && j >= low + 1) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, pivot, j);
        return j;
    }

    public static void swap(int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
}
