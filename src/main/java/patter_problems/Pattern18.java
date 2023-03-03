package patter_problems;

public class Pattern18 {
    public static void main(String[] args) {
        int n = Input.input();

        for(int i = 0; i < n; i++) {
            int cVal = 64 + n - i;
            for(int j = 0; j <= i; j++) {
                System.out.print((char)(cVal + j));
            }
            System.out.println();
        }
    }
}
