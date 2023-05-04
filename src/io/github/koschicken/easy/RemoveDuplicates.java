package io.github.koschicken.easy;

import java.util.Arrays;

public class RemoveDuplicates {

    public static void main(String[] args) {
        // int[] nums = {0, 1, 1, 1, 2, 3, 3, 4};
        int[] nums = {1, 1, 2};
        int length = removeDuplicates(nums);
        System.out.println(Arrays.toString(Arrays.copyOf(nums, length)));
    }

    public static int removeDuplicates(int[] nums) {
        int slow = 0;
        int fast = 1;
        while (fast < nums.length) {
            // 一快一慢两个指针遍历数组，快指针一直向前跑，当两个指针指向的值不相同时，慢指针移动一次，再把快指针指向的值和慢指针的值交换
            if (nums[fast] != nums[slow]) {
                slow++;
                nums[slow] = nums[fast];
            }
            fast++;
            System.out.println("slow = " + slow + " fast = " + fast + " nums = " + Arrays.toString(nums));
        }
        // 快指针跑到头的时候，慢指针指向的是最后一次交换的值，+1之后就是新数组的长度。
        return slow + 1;
    }
}
