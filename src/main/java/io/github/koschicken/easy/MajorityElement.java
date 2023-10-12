package io.github.koschicken.easy;

/**
 * <a href="https://leetcode.cn/problems/majority-element">169. 多数元素</a>
 */
public class MajorityElement {

    public static void main(String[] args) {
        int[] nums1 = {3, 2, 3};
        System.out.println(majorityElement(nums1));
        int[] nums2 = {2, 2, 1, 1, 1, 2, 2};
        System.out.println(majorityElement(nums2));
        int[] nums3 = {-1, 1, 1, 1, 2, 1};
        System.out.println(majorityElement(nums3));
    }

    private static int majorityElement(int[] nums) {
        int k = nums[0];
        int count = 1;
        for (int i : nums) {
            if (i == k) {
                count++;
            } else {
                count--;
                if (count == 0) {
                    count = 1;
                    k = i;
                }
            }
        }
        return k;
    }
}
