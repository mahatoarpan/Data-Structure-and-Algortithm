package patter_problems;

public class Pattern4 {
    public static void main(String[] args) {
        int n = Input.input();
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}