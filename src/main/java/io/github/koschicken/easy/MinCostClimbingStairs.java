package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/min-cost-climbing-stairs/description/">746. 使用最小花费爬楼梯</a>
 */
public class MinCostClimbingStairs {

    @Test
    void solution() {
        assertEquals(minCostClimbingStairs(new int[]{10, 15, 20}), 15);
        assertEquals(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}), 6);
    }

    /**
     * 状态转移方程：dp[i] = min(dp[i-1]+cost[i-1], dp[i-2]+cost[i-2])
     */
    public int minCostClimbingStairs(int[] cost) {
        int n = cost.length;
        int[] dp = new int[n + 1];
        for (int i = 2; i <= n; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[n];
    }
}
