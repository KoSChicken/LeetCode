package io.github.koschicken.easy;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/merge-sorted-array/description/">88. 合并两个有序数组</a>
 */
public class MergeSortedArray {

    public static void main(String[] args) {
        int[] nums1 = {0};
        int m = 0;
        int[] nums2 = {1, 2, 3, 4, 5};
        int n = 5;
        merge(nums1, m, nums2, n);
        System.out.println(Arrays.toString(nums1));
    }

    private static void merge(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
    }
}
