package io.github.koschicken.easy;

/**
 * <a href="https://leetcode.cn/problems/single-number/description/">136. 只出现一次的数字</a>
 */
public class SingleNumber {

    public static void main(String[] args) {
        System.out.println(singleNumber(new int[]{2, 2, 1}));
    }

    public static int singleNumber(int[] nums) {
        int single = 0;
        for (int i : nums) {
            single ^= i;
        }
        return single;
    }
}
