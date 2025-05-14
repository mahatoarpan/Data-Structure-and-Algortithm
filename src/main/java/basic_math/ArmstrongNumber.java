package basic_math;

import java.util.Scanner;

public class ArmstrongNumber {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number:");
        int n = sc.nextInt();
        System.out.println(isArmstrong(n) ? "Armstrong Number" : "Non-armstrong Number");
    }

    private static boolean isArmstrong(int n) {
        int sum = 0, x = n;
        while (x > 0) {
            int digit = x % 10;
            sum = sum + (int)(Math.pow(digit, 3));
            x/=10;
        }
        return sum == n;
    }
}
