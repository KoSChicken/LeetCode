package io.github.koschicken.easy;

/**
 * <a href="https://leetcode.cn/problems/number-of-1-bits/description/">191. 位1的个数</a>
 */
public class HammingWeight {

    public static void main(String[] args) {
        System.out.println(Integer.bitCount(-3));
    }

    public static int hammingWeight(int n) {
        return Integer.bitCount(n);
    }
}
