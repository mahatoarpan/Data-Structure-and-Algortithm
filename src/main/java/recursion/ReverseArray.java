package recursion;

public class ReverseArray {
    public static void main(String[] args) {
        int[] arr = {2, 4, 5, 10, 1};
        System.out.println("Original Array: ");
        printArray(arr);
        reverse(arr, 0, arr.length - 1);
        System.out.println("Reversed Array: ");
        printArray(arr);
    }

    private static void printArray(int[] arr) {
        for (int i : arr) {
            System.out.print(i + " ");
        }
        System.out.println();
    }

    private static void reverse(int[] arr, int l, int r) {

        if (l >= r) {
            return;
        }

        int temp = arr[l];
        arr[l] = arr[r];
        arr[r] = temp;
        reverse(arr, l+1, r-1);

    }
}
