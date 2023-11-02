package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/maximum-average-subarray-i/">643. 子数组最大平均数 I</a>
 */
public class MaxAverage {

    @Test
    void solution() {
        assertEquals(findMaxAverage(new int[]{1, 12, -5, -6, 50, 3}, 4), 12.75);
        assertEquals(findMaxAverage(new int[]{5}, 1), 5.0);
    }

    public double findMaxAverage(int[] nums, int k) {
        int sum = 0;
        for (int i = 0; i < k; i++) {
            sum += nums[i];
        }
        int max = sum;
        for (int i = k; i < nums.length; i++) {
            sum += nums[i] - nums[i - k];
            max = Math.max(max, sum);
        }
        return max * 1.0 / k;
    }
}
