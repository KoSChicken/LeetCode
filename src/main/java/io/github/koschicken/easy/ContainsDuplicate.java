package io.github.koschicken.easy;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/contains-duplicate/description/">217. 存在重复元素</a>
 */
public class ContainsDuplicate {

    public static void main(String[] args) {
        int[] nums1 = {1, 2, 3, 1};
        System.out.println(containsDuplicate(nums1));
        int[] nums2 = {1, 2, 3, 4};
        System.out.println(containsDuplicate(nums2));
        int[] nums3 = {1, 1, 1, 3, 3, 4, 3, 2, 4, 2};
        System.out.println(containsDuplicate(nums3));
    }

    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int i : nums) {
            if (!hashSet.add(i)) {
                return true;
            }
        }
        return false;
    }
}
