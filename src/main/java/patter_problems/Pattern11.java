package patter_problems;

public class Pattern11 {
    public static void main(String[] args) {
        int n = Input.input();
        boolean on = true;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                if (on)     System.out.print(1);
                else        System.out.print(0);
                on = !on;
            }
            System.out.println();
        }
    }
}
