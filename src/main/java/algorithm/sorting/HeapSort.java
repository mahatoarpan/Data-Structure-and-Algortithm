package algorithm.sorting;

public class HeapSort {

    public static void main(String[] args) {
        int[] arr = {0,20,10,40,5,50,30};
        heapsort(arr);
        for(int num : arr) {
            System.out.print(num + " ");
        }

    }

    public static void heapsort(int[] arr) {
        for(int i = arr.length / 2; i > 0; i--) {
            heapify(arr, i);
        }
    }

    private static void heapify(int[] arr, int index) {
        int largest = index;
        int left = index * 2;
        int right = (index * 2) + 1;

        if(left < arr.length && arr[left] > arr[largest]) {
            largest = left;
        }

        if(right < arr.length && arr[right] > arr[largest]) {
            largest = right;
        }

        if(largest != index) {
            int temp = arr[largest];
            arr[largest] = arr[index];
            arr[index] = temp;
            heapify(arr, largest);
        }
    }
}
