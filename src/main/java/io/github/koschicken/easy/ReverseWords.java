package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/reverse-words-in-a-string/description/">151. 反转字符串中的单词</a>
 */
public class ReverseWords {

    @Test
    void solution() {
        assertEquals(reverseWords("the sky is blue"), "blue is sky the");
        assertEquals(reverseWords("  hello world  "), "world hello");
        assertEquals(reverseWords("a good   example"), "example good a");
    }

    public String reverseWords(String s) {
        String[] words = s.trim().split("\\s+");
        int i;
        String t;
        for (i = 0; i < words.length / 2; i++) {
            t = words[i];
            words[i] = words[words.length - i - 1];
            words[words.length - i - 1] = t;
        }
        return String.join(" ", words);
    }
}
