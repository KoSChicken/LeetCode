package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/merge-strings-alternately/description/">1768. 交替合并字符串</a>
 */
public class MergeAlternately {

    @Test
    void solution() {
        assertEquals(mergeAlternately("abc", "pqr"), "apbqcr");
        assertEquals(mergeAlternately("ab", "pqrs"), "apbqrs");
        assertEquals(mergeAlternately("abcd", "pq"), "apbqcd");
    }

    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int length1 = word1.length();
        int length2 = word2.length();
        int length = Math.max(length1, length2);
        for (int i = 0; i < length; i++) {
            if (i < length1) {
                sb.append(word1.charAt(i));
            }
            if (i < length2) {
                sb.append(word2.charAt(i));
            }
        }
        return sb.toString();
    }
}
