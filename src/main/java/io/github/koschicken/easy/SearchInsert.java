package io.github.koschicken.easy;

/**
 * <a href="https://leetcode.cn/problems/search-insert-position/description/">35. 搜索插入位置</a>
 */
public class SearchInsert {

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 6};
        int i = searchInsert(nums, 0);
        System.out.println(i);
    }

    private static int searchInsert(int[] nums, int target) {
        for (int i = 0; i < nums.length; i++) {
            if (target == nums[i]) {
                return i;
            }
            if (target < nums[i]) {
                return i;
            }
        }
        return nums.length;
    }
}
