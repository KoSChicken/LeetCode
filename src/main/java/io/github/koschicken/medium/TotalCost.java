package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/total-cost-to-hire-k-workers/">2462. 雇佣 K 位工人的总代价</a>
 */
public class TotalCost {

    @Test
    void solution() {
        assertEquals(4, totalCost(new int[]{1, 2, 4, 1}, 3, 3));

    }

    /**
     * 按照题目下面的提示的思路，创建两个优先队列，循环计算总花费。
     * <p>
     * 专门处理了总人数不够创建两个队列的情况，避免两个队列加入同一个数组元素的情况。
     */
    public long totalCost(int[] costs, int k, int candidates) {
        long totalCost = 0;
        int n = costs.length;
        // 人数不足，直接排序计算
        if (candidates * 2 + k > n) {
            Arrays.sort(costs);
            for (int i = 0; i < k; i++) {
                totalCost += costs[i];
            }
            return totalCost;
        }
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        int left = candidates;
        int right = n - candidates - 1;
        for (int i = 0; i < candidates; i++) {
            pq1.offer(costs[i]);
            pq2.offer(costs[n - i - 1]);
        }
        while (k > 0) {
            if (pq1.peek() <= pq2.peek()) {
                totalCost += pq1.poll();
                pq1.offer(costs[left++]);
            } else {
                totalCost += pq2.poll();
                pq2.offer(costs[right--]);
            }
            k--;
        }
        return totalCost;
    }
}
