package patter_problems;

public class Pattern13 {
    public static void main(String[] args) {
        int n = Input.input();
        int counter = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(counter++ + " ");
            }
            System.out.println();
        }
    }
}
