package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/house-robber/description/">198. 打家劫舍</a>
 */
public class Rob {

    @Test
    void solution() {
        assertEquals(rob(new int[]{1, 2, 3, 1}), 4);
        assertEquals(rob(new int[]{2, 7, 9, 3, 1}), 12);
        assertEquals(rob(new int[]{2, 1, 1, 2}), 4);
    }

    /**
     * 因为不能打劫相邻的房屋，所以要么打劫i和i-2，要么只打劫i-1，取两种状态中的高收益者。
     * 状态转移方程：dp[i] = max(dp[i-1], dp[i-2] + nums[i]
     */
    public int rob(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]); // 构建dp数组时一定要注意第二个元素的赋值方式
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}
