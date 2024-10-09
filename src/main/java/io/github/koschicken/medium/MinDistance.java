package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/edit-distance/?envType=study-plan-v2&envId=leetcode-75">72. 编辑距离</a>
 */
public class MinDistance {

    @Test
    void solution() {
        assertEquals(5, minDistance("horse", "ros"));
    }

    /**
     * <pre>
     *     当最后一位相同：dp[i][j] = dp[i-1][j-1]
     *     当最后一位不同：
     *     删除：dp[i][j] = dp[i-1][j] + 1
     *     插入：dp[i][j] = dp[i][j-1] + 1
     *     替换：dp[i][j] = dp[i-1][j-1] + 1
     *     取三者最小的
     * </pre>
     */
    public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        int[][] dp = new int[m + 1][n + 1];
        for (int j = 1; j <= n; j++) {
            dp[0][j] = j;
        }
        for (int i = 1; i <= m; i++) {
            dp[i][0] = i;
            char c1 = word1.charAt(i - 1);
            for (int j = 1; j <= n; j++) {
                char c2 = word2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.min(Math.min(dp[i][j - 1], dp[i - 1][j]), dp[i - 1][j - 1]) + 1;
                }
            }
        }
        return dp[m][n];
    }
}
