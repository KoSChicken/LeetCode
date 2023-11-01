package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * <a href="https://leetcode.cn/problems/move-zeroes/description/">283. 移动零</a>
 */
public class MoveZeros {

    @Test
    void solution() {
        int[] nums = {1, 2, 3, 4, 5, 0, 0, 0, 0, 0, 0, 0};
        moveZeroes(nums);
        assertArrayEquals(nums, new int[]{1, 2, 3, 4, 5, 0, 0, 0, 0, 0, 0, 0});
    }

    public void moveZeroes(int[] nums) {
        int length = nums.length;
        int slow = 0;
        int fast = 0;
        while (fast < length) {
            if (nums[fast] != 0) {
                swap(nums, slow, fast);
                slow++;
            }
            fast++;
        }
    }

    private void swap(int[] nums, int slow, int fast) {
        int t = nums[slow];
        nums[slow] = nums[fast];
        nums[fast] = t;
    }
}
