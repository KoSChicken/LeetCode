package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/find-pivot-index/">724. 寻找数组的中心下标</a>
 */
public class PivotIndex {

    @Test
    void solution() {
        assertEquals(pivotIndex(new int[]{1, 7, 3, 6, 5, 6}), 3);
        // 1, 8, 11, 17, 22, 28
        // 28, 27, 20, 17, 11, 6
        assertEquals(pivotIndex(new int[]{1, 2, 3}), -1);
        // 1, 3, 6
        // 6, 5, 3
        assertEquals(pivotIndex(new int[]{2, 1, -1}), 0);
        // 2, 3, 2
        // 2, 0, -1
    }

    public int pivotIndex(int[] nums) {
        int total = 0;
        for (int num : nums) {
            total += num;
        }
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (sum == total - nums[i] - sum) {
                return i;
            }
            sum += nums[i];
        }
        return -1;
    }

    public int pivotIndexBrutal(int[] nums) {
        int length = nums.length;
        int[] left = new int[length];
        left[0] = nums[0];
        for (int i = 1; i < length; i++) {
            left[i] += left[i - 1] + nums[i];
        }
        int[] right = new int[length];
        right[length - 1] = nums[length - 1];
        for (int i = length - 2; i >= 0; i--) {
            right[i] += right[i + 1] + nums[i];
        }
        for (int i = 0; i < length; i++) {
            if (left[i] == right[i]) {
                return i;
            }
        }
        return -1;
    }
}
