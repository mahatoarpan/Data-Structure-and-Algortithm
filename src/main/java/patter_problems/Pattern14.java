package patter_problems;

public class Pattern14 {
    public static void main(String[] args) {
        int n = Input.input();
        int ascii = 64;
        for (int i = 1; i <= n ; i++) {
            for (int j = 1; j <= i ; j++) {
                System.out.print((char) (ascii + j));
            }
            System.out.println();
        }
    }
}
