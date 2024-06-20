package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/n-th-tribonacci-number/description/">1137. 第N个泰波那契数</a>
 */
public class Tribonacci {

    @Test
    void solution() {
        assertEquals(tribonacci(0), 0);
        assertEquals(tribonacci(4), 4);
        assertEquals(tribonacci(25), 1389537);
    }

    /**
     * 泰波那契数列：T(0)=0, T(1)=1, T(2)=1，n>=0时，T(n+3)=T(n)+T(n+1)+T(n+2)
     */
    public int tribonacci(int n) {
        if (n < 3) {
            return new int[]{0, 1, 1}[n];
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 3] + dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }
}
