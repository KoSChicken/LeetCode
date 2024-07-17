package io.github.koschicken.medium;

import io.github.koschicken.common.MaxHeap;
import org.junit.jupiter.api.Test;

import java.util.PriorityQueue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/kth-largest-element-in-an-array/description/">215. 数组中的第K个最大元素</a>
 */
public class KthLargest {

    @Test
    void solution() {
        // 示例 1:
        //
        // 输入: [3,2,1,5,6,4], k = 2
        // 输出: 5
        assertEquals(5, findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        // 示例 2:
        //
        // 输入: [3,2,3,1,2,4,5,5,6], k = 4
        // 输出: 4
        assertEquals(4, findKthLargest(new int[]{3, 2, 3, 1, 2, 4, 5, 5, 6}, 4));
    }

    public int findKthLargest(int[] nums, int k) {
        MaxHeap<Integer> maxHeap = new MaxHeap<>(nums.length);
        for (int num : nums) {
            maxHeap.add(num);
        }
        int ans = maxHeap.find(0);
        for (int i = 0; i < k; i++) {
            ans = maxHeap.remove();
        }
        return ans;
    }

    public int findKthLargestLib(int[] nums, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();
        for (int num : nums) {
            priorityQueue.offer(num);
        }
        int ans = priorityQueue.peek();
        for (int i = 0; i < nums.length - k + 1; i++) {
            ans = priorityQueue.poll();
        }
        return ans;
    }
}
