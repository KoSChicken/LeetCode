package io.github.koschicken.easy;

import java.util.Arrays;

public class RemoveElement {

    public static void main(String[] args) {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int i = removeElement(nums, 2);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, i)));
    }

    /**
     * 很投机的做法
     */
    public static int removeElement(int[] nums, int val) {
        int replaced = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                nums[i] = Integer.MAX_VALUE;
                replaced++;
            }
        }
        Arrays.sort(nums);
        return nums.length - replaced;
    }
}
