package io.github.koschicken.hard;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/trapping-rain-water/description/">42. 接雨水</a>
 */
public class Trap {

    @Test
    void solution() {
        // 输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
        // 输出：6
        // 解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。
        assertEquals(6, trap(new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1}));
    }

    /**
     * 计算一个前缀最大值，计算一个后缀最大值，然后取二者较小的再减去对应的高度，就是这一列能储存的雨水量，加起来就是总量。
     * <p>
     * 时间空间复杂度都是O(n)，可以通过双指针的方式将空间复杂度降低到O(1)
     */
    public int trap(int[] height) {
        int n = height.length;
        int[] preMax = new int[n];
        preMax[0] = height[0];
        for (int i = 1; i < n; i++) {
            preMax[i] = Math.max(preMax[i - 1], height[i]);
        }
        int[] sufMax = new int[n];
        sufMax[n - 1] = height[n - 1];
        for (int i = n - 2; i > -1; i--) {
            sufMax[i] = Math.max(sufMax[i + 1], height[i]);
        }
        int sum = 0;
        for (int i = 0; i < n; i++) {
            int minHeight = Math.min(preMax[i], sufMax[i]);
            sum += (minHeight - height[i]);
        }
        return sum;
    }
}
