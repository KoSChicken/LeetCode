package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/add-strings/description/">415. 字符串相加</a>
 */
public class AddString {

    @Test
    void solution() {
        assertEquals("134", addStrings("11", "123"));
        assertEquals(String.valueOf(99999999999999L + 99999999999999L), addStrings("99999999999999", "99999999999999"));
    }

    public String addStrings(String num1, String num2) {
        int length = Math.max(num1.length(), num2.length());
        int[] ansArr = new int[length + 1];
        for (int i = length; i > 0; i--) {
            int i1 = num1.length() - 1 - length + i;
            if (i1 >= 0) {
                ansArr[i] += num1.charAt(i1) - 48;
            }
            int i2 = num2.length() - 1 - length + i;
            if (i2 >= 0) {
                ansArr[i] += num2.charAt(i2) - 48;
            }
            if (ansArr[i] > 9) {
                ansArr[i - 1] += 1;
                ansArr[i] -= 10;
            }
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < ansArr.length; i++) {
            if (i == 0 && ansArr[i] == 0) {
                continue;
            }
            sb.append(ansArr[i]);
        }
        return sb.toString();
    }
}
