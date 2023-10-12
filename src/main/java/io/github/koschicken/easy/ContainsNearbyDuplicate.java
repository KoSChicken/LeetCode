package io.github.koschicken.easy;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/contains-duplicate-ii/description/">219. 存在重复元素 II</a>
 */
public class ContainsNearbyDuplicate {
    public static void main(String[] args) {
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        System.out.println(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        System.out.println(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    /**
     * 建立一个set，最多保存k+1个元素，利用set的add方法的返回值判断是否有符合条件的元素
     */
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {
            if (i > k) {
                set.remove(nums[i - k - 1]);
            }
            if (!set.add(nums[i])) { // 无法插入，说明存在符合条件的元素
                return true;
            }
        }
        return false;
    }

    public static boolean containsNearbyDuplicateByMap(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            Integer index = map.get(nums[i]);
            if (index != null && Math.abs(index - i) <= k) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    /**
     * 2673 ms，这都不超时，简直了。
     */
    public static boolean containsNearbyDuplicate_(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i; j <= i + k; j++) {
                if (i != j && j < nums.length && nums[i] == nums[j]) {
                    return true;
                }
            }
        }
        return false;
    }
}
