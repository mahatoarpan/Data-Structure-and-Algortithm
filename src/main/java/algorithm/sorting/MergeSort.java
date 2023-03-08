package algorithm.sorting;

public class MergeSort {

    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
        mergeSort(arr, 0, arr.length-1);
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }

    public static void mergeSort(int[] arr, int low, int high) {
        if (high > low) {
            int mid = low + ((high - low) / 2);
            mergeSort(arr, low, mid);
            mergeSort(arr, mid+1, high);
            merge(arr, low, mid, high);
        }
    }

    public static void merge(int[] arr, int low, int mid, int high) {
        int[] temp = new int[high - low + 1];
        int tempPointer = 0;
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                temp[tempPointer] = arr[left];
                left++;
            } else {
                temp[tempPointer] = arr[right];
                right++;
            }
            tempPointer++;
        }

        while (left <= mid) {
            temp[tempPointer] = arr[left];
            left++;
            tempPointer++;
        }

        while (right <= high) {
            temp[tempPointer] = arr[right];
            right++;
            tempPointer++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = temp[i-low];
        }
    }
}
