package recursion;

import java.util.Scanner;

public class PalindromeSting {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter String: ");
        String s = sc.nextLine().trim();
        System.out.println(isPalindrome(s, 0, s.length() - 1) ? "Palindrome String" : "Non-palindrome String");

    }

    private static boolean isPalindrome(String s, int l, int r) {

        if (l >= r) { return true; }
        return s.charAt(l) == s.charAt(r) ? isPalindrome(s, l+1, r-1) : false;
    }

}
