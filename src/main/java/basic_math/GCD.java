package basic_math;

import java.util.Scanner;

public class GCD {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number A: ");
        int a = sc.nextInt();
        System.out.println("Enter number B: ");
        int b = sc.nextInt();
        System.out.println("GCD: " + gcd(a, b));
    }

    private static int gcd(int a, int b) {
        while (a > 0 && b > 0) {
            if (a > b) {
                a = a % b;
            } else {
                b = b % a;
            }
        }
        return a == 0 ? b : a;
    }
}