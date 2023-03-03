package dp;

public class FibonacciSeries {
    public static long[] fibonacci(int n) {
        long[] arr = new long[100];
        int a = 0;
        int b = 0;
        arr[0] = 0; arr[1] = 1;
        for (int i = 2; i < n; i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr;
    }
    public static void main(String[] args) {
        long arr[] = fibonacci(100);
        for (int i = 0; i < arr.length; i++) {
            System.out.println(i + " : " + arr[i]);
        }
    }
}
