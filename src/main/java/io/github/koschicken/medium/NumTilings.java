package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/domino-and-tromino-tiling/description/">790. 多米诺和托米诺平铺</a>
 */
public class NumTilings {

    @Test
    void solution() {
        assertEquals(numTilings(30), 312342182);
    }

    /**
     * 第i列的状态有4种情况：
     * dp[i][0] 没有被覆盖
     * dp[i][1] 上面被覆盖
     * dp[i][2] 下面被覆盖
     * dp[i][3] 整列被覆盖
     * 则第i-1列的状态和第i列的关系如下：（用x表示放置在i-1列上的瓷砖）
     * dp[i][0] = dp[i-1][3]。
     * 只有一种可能，即i-1放置的瓷砖覆盖了整列，这里不用关心是用哪种瓷砖：
     * x o
     * x o
     * dp[i][1] = dp[i-1[0] + dp[i-1][2]
     * 有两种可能：
     * x x     x x
     * x o     o o
     * dp[i][2] = dp[i-1][0] + dp[i-1][1]
     * 有两种可能：
     * x o     o o
     * x x     x x
     * dp[i][3] = dp[i-1][0] + dp[i-1][1] + dp[i-1][2] + dp[i-1][3]
     * 有四种可能：
     * x x     x x     o x     o x
     * x x     o x     x x     o x
     * 只有dp[i][3]才是第i列都被覆盖的情况，所以dp[i][3]就是问题的结果
     */
    public int numTilings(int n) {
        if (n < 3) {
            return n;
        }
        int mod = 1000000007;
        int[][] dp = new int[n + 1][4];
        dp[0][3] = 1;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = dp[i - 1][3];
            dp[i][1] = (dp[i - 1][0] + dp[i - 1][2]) % mod;
            dp[i][2] = (dp[i - 1][0] + dp[i - 1][1]) % mod;
            dp[i][3] = (((dp[i - 1][0] + dp[i - 1][1]) % mod + dp[i - 1][2]) % mod + dp[i - 1][3]) % mod;
        }
        return dp[n][3];
    }
}
