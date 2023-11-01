package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/container-with-most-water/description/">11. 盛最多水的容器</a>
 */
public class MaxArea {

    @Test
    void solution() {
        assertEquals(maxArea(new int[]{1, 8, 6, 2, 5, 4, 8, 3, 7}), 49);
    }

    public int maxArea(int[] height) {
        int head = 0;
        int tail = height.length - 1;
        int maxArea = 0;
        while (head < tail) {
            int shortOne = Math.min(height[head], height[tail]);
            maxArea = Math.max(maxArea, shortOne * (tail - head));
            if (height[head] <= height[tail]) {
                head++;
            } else {
                tail--;
            }
        }
        return maxArea;
    }
}
