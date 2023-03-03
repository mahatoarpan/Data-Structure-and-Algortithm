package algorithm;

public class PrintAllDivisor {
    public static String print(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                sb.append(i + " ");
                if (i != n/i) {
                    sb.append(n/i + " ");
                }
            }
        }
        return sb.toString();
    }
}
