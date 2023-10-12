package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/movement-of-robots/description/">2731. 移动机器人</a>
 */
public class MovementOfRobots {

    @Test
    void solution() {
        assertEquals(sumDistance(new int[]{-2, 0, 2}, "RLL", 3), 8);
        assertEquals(sumDistance(new int[]{1, 0}, "RL", 2), 5);
    }

    public int sumDistance(int[] nums, String s, int d) {
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'L') {
                nums[i] -= d;
            } else {
                nums[i] += d;
            }
        }
        return (int) sumOfAbsoluteDifferences(nums);
    }

    private long sumOfAbsoluteDifferences(int[] array) {
        int mod = (int) (Math.pow(10, 9) + 7);
        Arrays.sort(array);
        long sum = 0;
        long prefixSum = 0;
        for (int i = 0; i < array.length; i++) {
            sum = (sum + ((long) array[i] * i - prefixSum)) % mod;
            prefixSum += array[i];
        }
        return sum;
    }

    @Test
    void testSum() {
        long sum = sumOfAbsoluteDifferences(new int[]{-2, -1, 0, 1, 2});
        assertEquals(sum, 20);
    }
}
