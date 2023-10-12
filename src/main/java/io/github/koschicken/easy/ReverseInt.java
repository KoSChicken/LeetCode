package io.github.koschicken.easy;

/**
 * <a href="https://leetcode.cn/problems/reverse-integer">7. 整数反转</a>
 */
public class ReverseInt {

    public static void main(String[] args) {
        System.out.println(reverse(-2147483412));
        System.out.println(reverse(Integer.MIN_VALUE));
    }

    public static int reverse(int x) {
        // 12345 -> 54321
        int result = 0;
        while (x != 0) {
            if (result > Integer.MAX_VALUE / 10 || result < Integer.MIN_VALUE / 10) {
                return 0;
            }
            result = result * 10 + x % 10;
            System.out.println(result);
            x = x / 10;
            System.out.println(x);
            System.out.println("-------------");
        }
        return result;
    }
}
