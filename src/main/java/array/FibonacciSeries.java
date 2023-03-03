package array;

public class FibonacciSeries {
    public static long fibonacci(int n, long[] arr) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        if (arr[n] != 0)    return arr[n];
        arr[n] = fibonacci(n - 1, arr) + fibonacci(n - 2, arr);
        return arr[n];
    }
    public static void main(String[] args) {
        long[] arr = new long[100];
        for (int n = 0; n < 100; n++) {
            System.out.println(n + " : " + fibonacci(n, arr));
        }
    }
}
