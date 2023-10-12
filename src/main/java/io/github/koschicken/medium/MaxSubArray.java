package io.github.koschicken.medium;

/**
 * <a href="https://leetcode.cn/problems/maximum-subarray/description/">53. 最大子数组和</a>
 */
public class MaxSubArray {

    public static void main(String[] args) {
        int[] nums = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] nums = {-2, -1, -3, -4, -1, -2, -1, -5, -4};
        int sum = maxSubArray(nums);
        System.out.println(sum);
    }

    public static int maxSubArray(int[] nums) {
        if (nums.length == 1) {
            return nums[0];
        }
        int sum = 0;
        int max = nums[0];
        for (int num : nums) {
            sum += num;
            if (sum < num) {
                sum = num;
            }
            if (sum > max) {
                max = sum;
            }
        }
        return max;
    }
}
