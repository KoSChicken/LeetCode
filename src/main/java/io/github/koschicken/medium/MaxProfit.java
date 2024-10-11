package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/">122. 买卖股票的最佳时机II</a>
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/">714. 买卖股票的最佳时机含手续费</a>
 */
public class MaxProfit {

    @Test
    void solution() {
        assertEquals(7, maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        assertEquals(8, maxProfit(new int[]{1, 3, 2, 8, 4, 9}, 2));
    }

    /**
     * <pre>
     *     使用一个二维数组dp[][]，第一维记录天数，第二维记录是否持股
     *     题目要求只能持有一只股票，所以 第i天 有 1-持有股票 和 0-未持有股票 两种情况。
     *     如果 第i天 未持有股票，第i-1天 有两种情况：
     *          1. 第i-1天 持有股票，即 第i-1天 结束时卖出了股票。
     *          2. 第i-1天 没有持有股票，即 第i-1天结束时 没有进行任何操作。
     *          综上可得出一个状态转移方程：
     *          dp[i][0] = max(dp[i-1][0], dp[i-1][1] + prices[i])
     *     如果 第i天 持有股票，第i-1天 也有两种情况：
     *          1. 第i-1天 持有股票，即 第i-1天结束时 没有进行任何操作。
     *          2. 第i-1天 没有持有股票，即 第i-1天结束时 买入了股票。要注意的是，买入股票时使用的价格是 第i天 的价格。
     *          综上可得出一个状态转移方程：
     *          dp[i][1] = max(dp[i-1][1], dp[i-1][0] - prices[i])
     *      接下来考虑两种情况的比较关系，假设i是最后一天，当日持有股票也不可能卖出，所以必然要在最后一天将股票卖出才能获得较高的收益。
     * </pre>
     */
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
        }
        return dp[n][0];
    }

    /**
     * 原理和无手续费的股票买卖一样，只是增加了手续费，同时题目中规定每笔交易只需要支付一次手续费，所以可以只在卖出时让手续费参与计算。
     */
    public int maxProfit(int[] prices, int fee) {
        int n = prices.length;
        long[][] dp = new long[n + 1][2];
        dp[0][0] = 0;
        dp[0][1] = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i - 1] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i - 1]);
        }
        return (int) dp[n][0];
    }
}
