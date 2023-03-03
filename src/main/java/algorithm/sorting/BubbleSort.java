package algorithm.sorting;

public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {13, 46, 24, 52, 20, 9};
        sort(arr);
        for (int ele : arr) {
            System.out.print(ele + " ");
        }
    }
    private static void sort(int[] arr) {
        for(int i = arr.length - 1; i > 0; i--) {
            boolean didSwap = false;
            for(int j = 0; j < i; j++) {
                if (arr[j] > arr[j+1]) {
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    didSwap = true;
                }
            }
            if (!didSwap){
                break;
            }
        }
    }
}
