package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/find-the-highest-altitude">1732. 找到最高海拔</a>
 */
public class LargestAltitude {

    @Test
    void solution() {
        assertEquals(largestAltitude(new int[]{-5, 1, 5, 0, -7}), 1);
        assertEquals(largestAltitude(new int[]{-4, -3, -2, -1, 4, 3, 2}), 0);
    }

    public int largestAltitude(int[] gain) {
        int highest = 0;
        int current = 0;
        for (int g : gain) {
            current += g;
            highest = Math.max(highest, current);
        }
        return highest;
    }
}
