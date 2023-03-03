package patter_problems;

public class Pattern15 {
    public static void main(String[] args) {
        int n = Input.input();
        int ascii = 64;
        for (int i = n; i > 0 ; i--) {
            for (int j = 1; j <= i ; j++) {
                System.out.print((char) (ascii + j));
            }
            System.out.println();
        }
    }
}
