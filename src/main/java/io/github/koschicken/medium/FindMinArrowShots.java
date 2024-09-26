package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/minimum-number-of-arrows-to-burst-balloons/description/">452. 用最少数量的箭引爆气球</a>
 */
public class FindMinArrowShots {

    @Test
    void solution() {
        assertEquals(2, findMinArrowShots(new int[][]{{10, 16}, {2, 8}, {1, 6}, {7, 12}}));
        assertEquals(4, findMinArrowShots(new int[][]{{1, 2}, {3, 4}, {5, 6}, {7, 8}}));
        assertEquals(2, findMinArrowShots(new int[][]{{1, 2}, {2, 3}, {3, 4}, {4, 5}}));
        assertEquals(2, findMinArrowShots(new int[][]{{1, 9}, {7, 16}, {2, 5}, {7, 12}, {9, 11}, {2, 10}, {9, 16}, {3, 9}, {1, 3}}));
    }

    public int findMinArrowShots(int[][] points) {
        // 先做最坏打算：一个气球一支箭
        int arrows = points.length;
        // 将气球数组按照气球的最大x坐标值从小到大排序
        Arrays.sort(points, Comparator.comparingInt(a -> a[1]));
        // 从第一个气球的最大x坐标处射出一支箭
        int arrowx = points[0][1];
        for (int i = 1; i < points.length; i++) {
            // 判断这支箭能不能射中下一个气球
            // 因为已经排序，所以只需要判断当前的气球的最小x坐标值是否小于或等于箭所在的x坐标，是则一定会被射中
            if (points[i][0] <= arrowx) {
                // 如果射出去的箭能命中当前气球，则总共需要的箭数量减少1
                arrows--;
            } else {
                // 如果当前的气球不能被射中，说明需要在新的位置再射一箭
                arrowx = points[i][1];
            }
        }
        return arrows;
    }
}
