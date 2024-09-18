package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/maximum-subsequence-score/submissions/565734939/">2542. 最大子序列的分数</a>
 */
public class MaxScore {

    @Test
    void solution() {
        assertEquals(168, maxScore(new int[]{2, 1, 14, 12}, new int[]{11, 7, 13, 6}, 3));
    }

    /**
     * 将第二个数组排序，取得最大的三个，然后将第一个数组中对应下标的数加入优先队列。计算此时的结果，随后遍历第一个数组中剩下的数字，计算并更新结果。
     */
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int length = nums1.length;
        Integer[] indices = new Integer[length];
        for (int i = 0; i < length; i++) {
            indices[i] = i;
        }
        Arrays.sort(indices, (i, j) -> nums2[j] - nums2[i]);
        long sum = 0;
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < k; i++) {
            sum += nums1[indices[i]];
            priorityQueue.offer(nums1[indices[i]]);
        }
        long result = sum * nums2[indices[k - 1]];
        for (int i = k; i < length; i++) {
            int i1 = nums1[indices[i]];
            if (i1 > priorityQueue.peek()) {
                sum = sum - priorityQueue.poll() + i1;
                priorityQueue.offer(i1);
                result = Math.max(result, sum * nums2[indices[i]]);
            }
        }
        return result;
    }
}
