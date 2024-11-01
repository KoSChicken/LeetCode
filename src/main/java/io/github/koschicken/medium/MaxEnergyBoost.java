package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/maximum-energy-boost-from-two-drinks/description/">3259. 超级饮料的最大强化能量</a>
 */
public class MaxEnergyBoost {

    @Test
    void solution() {
        assertEquals(5, maxEnergyBoost(new int[]{1, 3, 1}, new int[]{1, 1, 3}));
        assertEquals(7, maxEnergyBoost(new int[]{4, 1, 1}, new int[]{1, 1, 3}));
    }

    public long maxEnergyBoost(int[] energyDrinkA, int[] energyDrinkB) {
        int n = energyDrinkA.length;
        long[] dpA = new long[n + 1];
        long[] dpB = new long[n + 1];
        long[] dp = new long[n + 1];
        for (int i = 1; i <= n; i++) {
            dpA[i] = dpA[i - 1] + energyDrinkA[i - 1];
            dpB[i] = dpB[i - 1] + energyDrinkB[i - 1];
            if (i >= 2) {
                dpA[i] = Math.max(dpA[i - 1], dpB[i - 2]) + energyDrinkA[i - 1];
                dpB[i] = Math.max(dpB[i - 1], dpA[i - 2]) + energyDrinkB[i - 1];
            }
            dp[i] = Math.max(dpA[i], dpB[i]);
        }
        return dp[n];
    }
}
