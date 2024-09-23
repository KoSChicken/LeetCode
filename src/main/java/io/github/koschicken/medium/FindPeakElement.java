package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/find-peak-element/description/">162. 寻找峰值</a>
 */
public class FindPeakElement {

    @Test
    void solution() {
        assertEquals(6, findPeakElement(new int[]{1, 2, 1, 3, 5, 6, 7}));
    }

    public int findPeakElement(int[] nums) {
        int left = 0;
        // 在循环中没有找到峰值，则数组最后一个数就是峰值
        int right = nums.length - 2;
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[mid] > nums[mid + 1]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
