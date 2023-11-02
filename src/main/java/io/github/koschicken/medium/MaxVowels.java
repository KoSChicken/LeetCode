package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/maximum-number-of-vowels-in-a-substring-of-given-length/">1456. 定长子串中元音的最大数目</a>
 */
public class MaxVowels {

    @Test
    void solution() {
        assertEquals(maxVowels("ibpbhixfiouhdljnjfflpapptrxgcomvnb", 33), 7);
    }

    public int maxVowels(String s, int k) {
        int count = 0;
        for (int i = 0; i < k; i++) {
            count += isVowel(s.charAt(i));
        }
        int max = count;
        for (int i = k; i < s.length(); i++) {
            count += isVowel(s.charAt(i)) - isVowel(s.charAt(i - k));
            max = Math.max(max, count);
        }
        return max;
    }

    private int isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' ? 1 : 0;
    }
}
