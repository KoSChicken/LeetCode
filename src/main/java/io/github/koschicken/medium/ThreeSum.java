package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/3sum/description/">15. 三数之和</a>
 */
public class ThreeSum {

    @Test
    void solution() {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        for (List<Integer> list : lists) {
            list.forEach(e -> System.out.print(e + " "));
            System.out.println();
        }
    }

    /**
     * 排序之后可以转换为两数之和问题，用双指针解决即可
     */
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;
        for (int i = 0; i < n; i++) {
            int curr = nums[i];
            // 如果数组里全是正数不可能找出和为0的三元组
            if (curr > 0) {
                return result;
            }
            // 跳过重复数字
            if (i > 0 && curr == nums[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = n - 1;
            while (left < right) {
                int sum = nums[left] + nums[right] + curr;
                if (sum == 0) {
                    List<Integer> list = new ArrayList<>();
                    list.add(curr);
                    list.add(nums[left]);
                    list.add(nums[right]);
                    result.add(list);
                    // 跳过满足条件但重复的数字
                    do {
                        left++;
                    } while (left < right && nums[left] == nums[left - 1]);
                    do {
                        right--;
                    } while (left < right && nums[right] == nums[right + 1]);
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }
}
