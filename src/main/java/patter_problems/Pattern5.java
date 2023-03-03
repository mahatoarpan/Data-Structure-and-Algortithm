package patter_problems;

public class Pattern5 {
    public static void main(String[] args) {
        int n = Input.input();
        for(int i = n; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
