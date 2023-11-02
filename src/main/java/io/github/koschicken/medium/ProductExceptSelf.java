package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

/**
 * <a href="https://leetcode.cn/problems/product-of-array-except-self/description/">238. 除自身以外数组的乘积</a>
 */
public class ProductExceptSelf {

    @Test
    void solution() {
        assertArrayEquals(productExceptSelf(new int[]{1, 2, 3, 4}), new int[]{24, 12, 8, 6});
        assertArrayEquals(productExceptSelf(new int[]{-1, 1, 0, -3, 3}), new int[]{0, 0, 9, 0, 0});
    }

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] pre = new int[n];
        pre[0] = nums[0];
        for (int i = 1; i < n; i++) {
            pre[i] = pre[i - 1] * nums[i];
        }
        int[] suf = new int[n];
        suf[n - 1] = nums[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            suf[i] = suf[i + 1] * nums[i];
        }
        int[] ans = new int[n];
        ans[0] = suf[1];
        ans[n - 1] = pre[n - 2];
        for (int i = 1; i < n - 1; i++) {
            ans[i] = pre[i - 1] * suf[i + 1];
        }
        return ans;
    }
}
