package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <a href="https://leetcode.cn/problems/increasing-triplet-subsequence/">334. 递增的三元子序列</a>
 */
public class IncreasingTriplet {

    @Test
    void solution() {
        assertTrue(increasingTriplet(new int[]{20, 100, 10, 12, 5, 13}));
        // assertTrue(increasingTriplet(new int[]{1, 2, 3, 4, 5}));
        // assertFalse(increasingTriplet(new int[]{5, 4, 3, 2, 1}));
        // assertTrue(increasingTriplet(new int[]{2, 1, 5, 0, 4, 6}));
    }

    public boolean increasingTriplet(int[] nums) {
        int first = nums[0];
        int second = Integer.MAX_VALUE;
        for (int num : nums) {
            if (num > second) {
                return true;
            } else if (num > first) {
                second = num;
            } else {
                first = num;
            }
        }
        return false;
    }
}
