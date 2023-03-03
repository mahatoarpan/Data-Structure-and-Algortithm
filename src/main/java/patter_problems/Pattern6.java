package patter_problems;

public class Pattern6 {
    public static void main(String[] args) {
        int n = Input.input();
        for(int i = n; i > 0; i--) {
            for(int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }
}
