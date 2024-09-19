package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/length-of-the-longest-alphabetical-continuous-substring/submissions/566017173/">2414. 最长的字母序连续子字符串的长度</a>
 */
public class LongestContinuousSubstring {

    @Test
    void solution() {
        assertEquals(5, longestContinuousSubstring("abcde"));
    }

    public int longestContinuousSubstring(String s) {
        int reslut = 1;
        int current = 1;
        char[] array = s.toCharArray();
        for (int i = 1; i < array.length; i++) {
            if (array[i] - array[i - 1] == 1) {
                current++;
                reslut = Math.max(reslut, current);
            } else {
                current = 1;
            }
        }
        return reslut;
    }
}
