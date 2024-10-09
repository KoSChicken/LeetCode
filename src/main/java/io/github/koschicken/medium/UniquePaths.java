package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/unique-paths/description/">62. 不同路径</a>
 */
public class UniquePaths {

    @Test
    void solution() {
        assertEquals(28, uniquePaths(3, 7));
    }

    /**
     * 典型的动态规划。题目要求只能往右或往下走，所以可以到达[i, j]的位置只有[i-1, j]和[i, j-1]，所以状态转移方程为： dp[i, j] = dp[i-1, j] + dp[i, j-1]
     */
    public int uniquePaths(int m, int n) {
        if (m == 1 || n == 1) {
            return 1;
        }
        int[][] dp = new int[m][n];
        // x或y轴为0的坐标初始化为1，因为只有一条路径
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int i = 0; i < n; i++) {
            dp[0][i] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}
