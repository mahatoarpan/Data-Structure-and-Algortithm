package recursion;

public class Factorial {
    public static long factorial(int n) {
        if (n == 1) return 1;
        return factorial(n - 1) * n;
    }

    public static void main(String[] args) {
        for (int i = 1; i < 50; i++) {
            System.out.println(i + " : " + factorial(i));
        }
    }
}
