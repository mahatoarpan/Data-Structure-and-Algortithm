package patter_problems;

import java.util.Scanner;

public class Input {

    public static int input() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the value of N");
        int n = sc.nextInt();
        sc.nextLine();
        return n;
    }
}
