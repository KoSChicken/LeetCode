package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/counting-bits/description/">338. 比特位计数</a>
 */
public class CountBits {

    @Test
    void solution() {
        System.out.println(Arrays.toString(countBits(15)));
    }

    /**
     * 一个数的二进制表示中1的数量可以通过查看它右移一位的数的二进制表示中1的数量（即除以2），然后加上它自己最低位的值（即它和1进行与操作的结果）来得到。
     */
    public int[] countBits(int n) {
        int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            count[i] = count[i >> 1] + (i & 1);
        }
        return count;
    }
}
