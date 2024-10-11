package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/longest-consecutive-sequence/">128. 最长连续序列</a>
 */
public class LongestConsecutive {

    @Test
    void solution() {
        // 输入：nums = [9,1,4,7,3,-1,0,5,8,-1,6]
        // 输出：7
        assertEquals(7, longestConsecutive(new int[]{9, 1, 4, 7, 3, -1, 0, 5, 8, -1, 6}));
    }

    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            set.add(num);
        }
        int max = 1;
        for (Integer num : set) {
            if (!set.contains(num - 1)) {
                int count = 1;
                int curr = num;
                while (set.contains(curr + 1)) {
                    curr++;
                    count++;
                }
                max = Math.max(max, count);
            }
        }
        return max;
    }
}
