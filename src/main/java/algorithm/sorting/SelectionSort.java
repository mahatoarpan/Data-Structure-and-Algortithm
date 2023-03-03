package algorithm.sorting;

public class SelectionSort {

    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
        SelectionSort.sort(arr);

        for (int j : arr) {
            System.out.print(j + " ");
        }
    }
    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex])
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    private static void swap (int[] arr, int indexA, int indexB) {
        int temp = arr[indexA];
        arr[indexA] = arr[indexB];
        arr[indexB] = temp;
    }
}
