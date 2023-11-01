package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <a href="https://leetcode.cn/problems/is-subsequence/">392. 判断子序列</a>
 */
public class IsSubsequence {

    @Test
    void solution() {
        assertTrue(isSubsequence("abc", "ahbgdc"));
        assertFalse(isSubsequence("axc", "ahbgdc"));
        assertTrue(isSubsequence("b", "abc"));
    }

    public boolean isSubsequence(String s, String t) {
        if (s.isEmpty()) {
            return true;
        }
        if (t.isEmpty()) {
            return false;
        }
        int i1 = 0;
        int i2 = t.indexOf(s.charAt(0));
        while (i1 < s.length() && i2 != -1 && i2 < t.length()) {
            if (s.charAt(i1) == t.charAt(i2)) {
                i1++;
            }
            i2++;
        }
        return i1 == s.length();
    }
}
