package array;

public class LinearSearch {
    public static void main(String[] args) {
        int arr[]={1,2,3,4,5};
        int num = 4;
        int pos = search(arr, num);
        System.out.println(pos == -1 ? "Number not found" : "Number available at location: " + pos);
    }

    private static int search(int[] arr, int key) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == key) {
                return i;
            }
        }
        return -1;
    }
}
