package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/koko-eating-bananas/description/">875. 爱吃香蕉的珂珂</a>
 */
public class MinEatingSpeed {

    @Test
    void solution() {
        assertEquals(4, minEatingSpeed(new int[]{3, 6, 7, 11}, 8));
        assertEquals(23, minEatingSpeed(new int[]{30, 11, 23, 4, 20}, 6));
        assertEquals(1, minEatingSpeed(new int[]{312884470}, 968709470));
    }

    public int minEatingSpeed(int[] piles, int h) {
        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        while (left < right) {
            int mid = left + (right - left) / 2;
            int sum = 0;
            for (int pile : piles) {
                sum += (pile + mid - 1) / mid;
            }
            if (sum > h) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}
