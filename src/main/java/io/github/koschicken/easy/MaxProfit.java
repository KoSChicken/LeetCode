package io.github.koschicken.easy;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/">121. 买卖股票的最佳时机</a>
 */
public class MaxProfit {

    public static void main(String[] args) {
        System.out.println(maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
        System.out.println(maxProfit(new int[]{7, 6, 4, 3, 1}));
        System.out.println(maxProfit(new int[]{1, 2, 4}));
    }

    public static int maxProfit(int[] prices) {
        int length = prices.length;
        if (length == 1) {
            return 0;
        }
        if (length == 2) {
            return prices[0] < prices[1] ? prices[1] - prices[0] : 0;
        }
        int min = Integer.MAX_VALUE;
        int max = 0;
        for (int price : prices) {
            if (price < min) {
                min = price;
            } else if (price - min > max) {
                max = price - min;
            }
        }
        return max;
    }
}
