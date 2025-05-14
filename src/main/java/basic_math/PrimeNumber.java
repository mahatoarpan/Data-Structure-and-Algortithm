package basic_math;

import java.util.Scanner;

public class PrimeNumber {

     public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number: ");
        int n = sc.nextInt();
        System.out.println(isPrime(n) ? "Prime Number" : "Non-prime Number");
    }

    private static boolean isPrime(int n) {
        int counter = 0;
        for(int i = 1; i*i<=n; i++) {
            if (n % i == 0) {
                counter++;
                if (n / i != i) {
                    counter++;
                }
            }
        }
        return counter == 2;
    } 
}