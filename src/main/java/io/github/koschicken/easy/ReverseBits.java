package io.github.koschicken.easy;

/**
 * <a href="https://leetcode.cn/problems/reverse-bits/description/">190. 颠倒二进制位</a>
 */
public class ReverseBits {

    public static void main(String[] args) {
        System.out.println(reverseBits(-3));
    }

    private static int reverseBits(int n) {
        int rev = 0;
        for (int i = 0; i < 32 && n != 0; ++i) {
            rev |= (n & 1) << (31 - i);
            n >>>= 1;
        }
        return rev;
    }
}
