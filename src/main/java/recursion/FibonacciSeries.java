package recursion;

public class FibonacciSeries {
    public static long fibonacci(int n) {
        if (n == 0) return 0;
        if (n == 1) return 1;
        return fibonacci(n-1) + fibonacci(n-2);
    }

    public static void main(String[] args) {
        for (int n = 0; n < 100; n++) {
            System.out.println(n + " : " + fibonacci(n));
        }
    }
}
