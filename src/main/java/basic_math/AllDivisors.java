package basic_math;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

public class AllDivisors {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number:");
        int n = sc.nextInt();
        List<Integer> divisors = getDivisors(n);
        divisors.sort(Comparator.naturalOrder());
        System.out.println("Divisors: " + divisors);
    }

    private static List<Integer> getDivisors(int n) {
        List<Integer> divisors = new ArrayList<>();
        for(int i = 1; i * i <= n; i++) {
            if (n % i == 0) {
                divisors.add(i);
                if (n/i != i) {
                    divisors.add(n/i);
                } 
            }
        }
        return divisors;
    }

}
