package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * <a href="https://leetcode.cn/problems/successful-pairs-of-spells-and-potions/description/">2300. 咒语和药水的成功对数</a>
 */
public class SuccessfulPairs {

    @Test
    void solution() {
        assertArrayEquals(successfulPairs(new int[]{5, 1, 3}, new int[]{1, 2, 3, 4, 5}, 7), new int[]{4, 0, 3});
        assertArrayEquals(successfulPairs(new int[]{3, 1, 2}, new int[]{8, 5, 8}, 16), new int[]{2, 0, 2});
    }

    public int[] successfulPairs(int[] spells, int[] potions, long success) {
        Arrays.sort(potions);
        int[] counts = new int[spells.length];
        for (int i = 0; i < spells.length; i++) {
            if ((long) spells[i] * potions[potions.length - 1] < success) {
                counts[i] = 0;
            } else {
                int left = 0;
                int right = potions.length - 1;
                while (left <= right) {
                    int mid = left + (right - left) / 2;
                    if ((long) spells[i] * potions[mid] >= success) {
                        right = mid - 1;
                    } else {
                        left = mid + 1;
                    }
                }
                counts[i] = potions.length - left;
            }
        }
        return counts;
    }
}
