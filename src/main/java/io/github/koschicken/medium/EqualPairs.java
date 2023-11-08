package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/equal-row-and-column-pairs/">2352. 相等行列对</a>
 */
public class EqualPairs {

    @Test
    void solution() {
        assertEquals(equalPairs(new int[][]{{13, 13}, {13, 13}}), 4);
        assertEquals(equalPairs(new int[][]{{11, 1}, {1, 11}}), 2);
        assertEquals(equalPairs(new int[][]{{3, 1, 2, 2}, {1, 4, 4, 5}, {2, 4, 2, 2}, {2, 4, 2, 2}}), 3);
        assertEquals(equalPairs(new int[][]{{1, 2, 3, 4}, {2, 1, 4, 3}, {3, 4, 1, 2}, {4, 3, 2, 1}}), 4);
        assertEquals(equalPairs(new int[][]{
                {3, 3, 3, 6, 18, 3, 3, 3, 3, 3},
                {3, 3, 3, 3, 1, 3, 3, 3, 3, 3},
                {3, 3, 3, 3, 1, 3, 3, 3, 3, 3},
                {3, 3, 3, 3, 1, 3, 3, 3, 3, 3},
                {1, 1, 1, 11, 19, 1, 1, 1, 1, 1},
                {3, 3, 3, 18, 19, 3, 3, 3, 3, 3},
                {3, 3, 3, 3, 1, 3, 3, 3, 3, 3},
                {3, 3, 3, 3, 1, 3, 3, 3, 3, 3},
                {3, 3, 3, 1, 6, 3, 3, 3, 3, 3},
                {3, 3, 3, 3, 1, 3, 3, 3, 3, 3}
        }), 48);
    }

    public int equalPairs(int[][] grid) {
        Map<List<Integer>, Integer> map = new HashMap<>();
        for (int[] row : grid) {
            List<Integer> list = new ArrayList<>();
            for (int i : row) {
                list.add(i);
            }
            map.put(list, map.getOrDefault(list, 0) + 1);
        }
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            List<Integer> col = new ArrayList<>();
            for (int j = 0; j < grid[0].length; j++) {
                col.add(grid[j][i]);
            }
            if (map.containsKey(col)) {
                count += map.get(col);
            }
        }
        return count;
    }
}
