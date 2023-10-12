package io.github.koschicken.easy;

import java.util.Arrays;
import java.util.HashMap;

/**
 * <a href="https://leetcode.cn/problems/two-sum/description/">1. 两数之和</a>
 */
public class TwoSum {
    public static void main(String[] args) {
        int[] nums = {3, 3};
        int target = 6;
        int[] ints = twoSum(nums, target);
        System.out.println(Arrays.toString(ints));
    }

    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
            }
            map.put(nums[i], i);
        }
        return result;
    }

    public int[] twoSumPro(int[] nums, int target) {
        if (nums.length == 2) {
            return new int[]{0, 1};
        }
        int hLength = nums.length / 2;
        for (int i = 0; i < hLength; i++) {
            int rem = nums.length - i - 1;
            int bFind = target - nums[i];
            int aFind = target - nums[rem];
            for (int k = i + 1; k < nums.length; k++) {
                if (nums[k] == bFind) {
                    return new int[]{i, k};
                }
                if (nums[k] == aFind) {
                    return new int[]{rem, k};
                }
            }
        }
        return new int[]{-1, -1};
    }
}
