package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/WHnhjV/description/">LCP.50 宝石补给</a>
 */
public class GiveGem {

    @Test
    void solution() {
        // 输入：gem = [3,1,2], operations = [[0,2],[2,1],[2,0]]
        // 输出：2
        // 解释：
        // 第 1 次操作，勇者 0 将一半的宝石赠送给勇者 2， gem = [2,1,3]
        // 第 2 次操作，勇者 2 将一半的宝石赠送给勇者 1， gem = [2,2,2]
        // 第 3 次操作，勇者 2 将一半的宝石赠送给勇者 0， gem = [3,2,1]
        // 返回 3 - 1 = 2
        assertEquals(giveGem(new int[]{3, 1, 2}, new int[][]{{0, 2}, {2, 1}, {2, 0}}), 2);
        assertEquals(giveGem(new int[]{100, 0, 50, 100}, new int[][]{{0, 2}, {0, 1}, {3, 0}, {3, 0}}), 75);
        assertEquals(giveGem(new int[]{0, 0, 0, 0}, new int[][]{{1, 2}, {3, 1}, {1, 2}}), 0);
    }

    public int giveGem(int[] gem, int[][] operations) {
        for (int[] operation : operations) {
            int index = operation[0];
            int target = operation[1];
            int gems = gem[index] / 2;
            gem[index] -= gems;
            gem[target] += gems;
        }
        int max = gem[0];
        int min = gem[0];
        for (int g : gem) {
            max = Math.max(max, g);
            min = Math.min(min, g);
        }
        return max - min;
    }
}
