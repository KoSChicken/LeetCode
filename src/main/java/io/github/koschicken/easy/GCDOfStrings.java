package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/greatest-common-divisor-of-strings/description/">1071. 字符串的最大公因子</a>
 */
public class GCDOfStrings {

    @Test
    void solution() {
        assertEquals(gcdOfStrings("NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM", "NLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGMNLZGM"), "NLZGM");
        assertEquals(gcdOfStrings("ABABCCABAB", "ABAB"), "");
        assertEquals(gcdOfStrings("AABB", "AB"), "");
        assertEquals(gcdOfStrings("ABABABAB", "ABAB"), "ABAB");
        assertEquals(gcdOfStrings("ABAB", "ABABABAB"), "ABAB");
        assertEquals(gcdOfStrings("ABCABC", "ABC"), "ABC");
        assertEquals(gcdOfStrings("ABC", "ABCABC"), "ABC");
        assertEquals(gcdOfStrings("ABABAB", "ABAB"), "AB");
        assertEquals(gcdOfStrings("LEET", "CODE"), "");
    }

    public String gcdOfStrings(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return gcdOfStrings(str2, str1);
        } else if (!str1.startsWith(str2)) {
            return "";
        } else if (str2.isEmpty()) {
            return str1;
        } else {
            return gcdOfStrings(str1.substring(str2.length()), str2);
        }
    }
}
