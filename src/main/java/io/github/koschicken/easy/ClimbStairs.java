package io.github.koschicken.easy;

public class ClimbStairs {

    public static void main(String[] args) {
        for (int i = 0; i < 46; i++) {
            System.out.println(climbStairs(i));
        }
    }

    private static int climbStairs(int n) {
        if (n <= 3) {
            return n;
        }
        int a = 1;
        int b = 2;
        int r = 0;
        for (int i = 0; i < n - 2; i++) {
            r = a + b;
            a = b;
            b = r;
        }
        return r;
    }
}
