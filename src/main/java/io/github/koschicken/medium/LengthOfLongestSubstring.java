package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/longest-substring-without-repeating-characters/description/">3. 无重复字符的最长子串</a>
 */
public class LengthOfLongestSubstring {

    @Test
    void solution() {
        // 示例 1:
        //
        // 输入: s = "abcabcbb"
        // 输出: 3
        // 解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
        assertEquals(3, lengthOfLongestSubstring("abcabcbb"));
        // 示例 2:
        //
        // 输入: s = "bbbbb"
        // 输出: 1
        // 解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
        assertEquals(1, lengthOfLongestSubstring("bbbbb"));
        // 示例 3:
        //
        // 输入: s = "pwwkew"
        // 输出: 3
        // 解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
        //      请注意，你的答案必须是 子串 的长度，"pwke" 是一个子序列，不是子串。
        assertEquals(3, lengthOfLongestSubstring("pwwkew"));
        assertEquals(5, lengthOfLongestSubstring("qrsvbspk"));
    }

    public int lengthOfLongestSubstring(String s) {
        int n = s.length();
        if (n == 0) {
            return 0;
        }
        char[] chars = s.toCharArray();
        // 双指针记录子串的开始和结束
        int left = -1;
        int right = 0;
        int max = 1;
        // 用map记录字符和下标，无重复时移动结束指针，发现重复时将字串的起始指针移动到最新发现的重复字符
        Map<Character, Integer> map = new HashMap<>();
        while (right < n) {
            if (map.containsKey(chars[right])) {
                left = Math.max(left, map.get(chars[right]));
            }
            map.put(chars[right], right);
            max = Math.max(max, right - left);
            right++;
        }
        return max;
    }
}
