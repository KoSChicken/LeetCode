package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/lexicographically-smallest-string-after-a-swap/">3216. 交换后字典序最小的字符串</a>
 */
public class GetSmallestString {

    @Test
    void solution() {
        assertEquals("43520", getSmallestString("45320"));
        assertEquals("001", getSmallestString("001"));
        assertEquals("113", getSmallestString("131"));
        assertEquals("02", getSmallestString("20"));
        assertEquals("54321", getSmallestString("54321"));
    }

    public String getSmallestString(String s) {
        char[] chars = s.toCharArray();
        int length = chars.length;
        for (int i = 0; i < length - 1; i++) {
            int n1 = chars[i];
            int n2 = chars[i + 1];
            if (n1 % 2 == n2 % 2 && n1 > n2) {
                char t = chars[i];
                chars[i] = chars[i + 1];
                chars[i + 1] = t;
                return new String(chars);
            }
        }
        return s;
    }
}
