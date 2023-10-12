package io.github.koschicken.easy;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/plus-one/description/">66. 加一</a>
 * <br/>
 * 吐槽：中文版的leetcode，有些题干翻译的简直不说人话，比如这一题，只看题干基本不知所云。
 */
public class PlusOne {

    public static void main(String[] args) {
        int[] digits = {9, 8, 9};
//        int[] digits = {9, 9, 9};
        int[] nums = plusOne(digits);
        System.out.println(Arrays.toString(nums));
    }

    private static int[] plusOne(int[] digits) {
        if (digits[digits.length - 1] != 9) {
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            return digits;
        }
        int ten;
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = (digits[i] + 1) % 10;
            ten = digits[i];
            if (ten == 0) {
                if (i == 0) {
                    // return addANumber(digits); // 着实是没什么必要，因为需要增加元素时，肯定是n个9，直接创建一个第一位为1，其他为0，长度n+1的数组即可。
                    digits = new int[digits.length + 1];
                    digits[0] = 1;
                }
            } else {
                break;
            }
        }
        return digits;
    }

    private static int[] addANumber(int[] arr) {
        int[] result = new int[arr.length + 1];
        result[0] = 1;
        System.arraycopy(arr, 0, result, 1, arr.length);
        return result;
    }
}
