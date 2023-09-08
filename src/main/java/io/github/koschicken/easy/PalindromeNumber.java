package io.github.koschicken.easy;

public class PalindromeNumber {

    public static void main(String[] args) {
        System.out.println("123 " + isPalindrome(123));
        System.out.println("121 " + isPalindrome(121));
        System.out.println("-121 " + isPalindrome(-121));
        System.out.println("1234004321 " + isPalindrome(1234004321));
    }

    public static boolean isPalindrome(int x) {
        if (x == 0) return true;
        if (x < 0) return false;
        if (x % 10 == 0) return false;
        return x == reverse(x);
    }

    private static int reverse(int x) {
        int result = 0;
        while (x != 0) {
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            result = result * 10 + x % 10;
            x = x / 10;
        }
        return result;
    }
}
