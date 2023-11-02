package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/max-number-of-k-sum-pairs/">1679. K 和数对的最大数目</a>
 */
public class MaxOperations {

    @Test
    void solution() {
        assertEquals(maxOperations(new int[]{1, 2, 3, 4}, 5), 2);
        assertEquals(maxOperations(new int[]{3, 1, 3, 4, 3}, 6), 1);
    }

    public int maxOperations(int[] nums, int k) {
        Arrays.sort(nums);
        int i = 0;
        int j = nums.length - 1;
        int count = 0;
        while (i < j) {
            int sum = nums[i] + nums[j];
            if (sum == k) {
                i++;
                j--;
                count++;
            } else if (sum < k) {
                i++;
            } else {
                j--;
            }
        }
        return count;
    }
}
