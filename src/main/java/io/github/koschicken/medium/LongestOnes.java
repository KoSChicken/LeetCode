package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/max-consecutive-ones-iii/">1004. 最大连续1的个数 III</a>
 */
public class LongestOnes {

    @Test
    void solution() {
        assertEquals(longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2), 6);
        assertEquals(longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3), 10);
    }

    /**
     * 右指针不断向右移动，移动时记录0的数量，当0的数量超过k时，左指针向右移动，直到两个指针之间的0的数量重新等于k，之后继续移动右指针。
     * 右指针每次移动都要计算当前两个指针之间的元素数量，这个数量就是最大连续1的个数的数量。
     * 重复这些操作直到右指针到达数组末尾。
     */
    public int longestOnes(int[] nums, int k) {
        int n = nums.length;
        int res = 0;
        int left = 0;
        int right = 0;
        int count = 0;
        while (right < n) {
            if (nums[right] == 0) {
                count++;
            }
            while (count > k) {
                if (nums[left] == 0) {
                    count--;
                }
                left++;
            }
            res = Math.max(res, right - left + 1);
            right++;
        }
        return res;
    }
}
