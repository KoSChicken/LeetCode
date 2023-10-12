package io.github.koschicken.medium;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/largest-values-from-labels/description/">1090. 受标签影响的最大值</a>
 */
public class LargestValsFromLabels {

    public static void main(String[] args) {
        System.out.println(largestValsFromLabels(new int[]{4, 7, 4, 6, 3}, new int[]{2, 0, 0, 2, 2}, 2, 2));
    }

    public static int largestValsFromLabels(int[] values, int[] labels, int numWanted, int useLimit) {
        int sum = 0;
        int n = values.length;
        Integer[] id = new Integer[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
        Arrays.sort(id, (a, b) -> values[b] - values[a]); // 倒序
        int count = 0;
        Map<Integer, Integer> countMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (count < numWanted) {
                int label = labels[id[i]];
                if (countMap.getOrDefault(label, 0) == useLimit) {
                    continue;
                }
                count++;
                sum += values[id[i]];
                countMap.put(label, countMap.getOrDefault(label, 0) + 1);
            }
        }
        return sum;
    }
}
