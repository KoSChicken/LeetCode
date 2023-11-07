package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/longest-subarray-of-1s-after-deleting-one-element/">1493. 删掉一个元素以后全为 1 的最长子数组</a>
 */
public class LongestSubarray {

    @Test
    void solution() {
        assertEquals(longestSubarray(new int[]{1, 1, 0, 1}), 3);
        assertEquals(longestSubarray(new int[]{0, 1, 1, 1, 0, 1, 1, 0, 1}), 5);
        assertEquals(longestSubarray(new int[]{1, 1, 1}), 2);
    }

    /**
     * 和<a href="https://leetcode.cn/problems/max-consecutive-ones-iii/">1004. 最大连续1的个数 III</a>一样，只是题目中的k变成1，且0不是翻转而是删除。
     */
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int res = 0;
        int count = 0;
        int left = 0;
        int right = 0;
        while (right < n) {
            if (nums[right] == 0) {
                count++;
            }
            while (count > 1) {
                if (nums[left] == 0) {
                    count--;
                }
                left++;
            }
            res = Math.max(res, right - left);
            right++;
        }
        return res;
    }
}
