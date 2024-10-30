package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * <a href="https://leetcode.cn/problems/find-all-anagrams-in-a-string/">438. 找到字符串中所有字母异位词</a>
 */
public class FindAnagrams {

    @Test
    void solution() {
        // 示例 1:
        //
        // 输入: s = "cbaebabacd", p = "abc"
        // 输出: [0,6]
        // 解释:
        // 起始索引等于 0 的子串是 "cba", 它是 "abc" 的异位词。
        // 起始索引等于 6 的子串是 "bac", 它是 "abc" 的异位词。
        assertIterableEquals(List.of(0, 6), findAnagrams("cbaebabacd", "abc"));
        //  示例 2:
        //
        // 输入: s = "abab", p = "ab"
        // 输出: [0,1,2]
        // 解释:
        // 起始索引等于 0 的子串是 "ab", 它是 "ab" 的异位词。
        // 起始索引等于 1 的子串是 "ba", 它是 "ab" 的异位词。
        // 起始索引等于 2 的子串是 "ab", 它是 "ab" 的异位词。
        assertIterableEquals(List.of(0, 1, 2), findAnagrams("abab", "ab"));
        assertIterableEquals(List.of(1), findAnagrams("baa", "aa"));
    }

    /**
     * 固定长度窗口，利用数组判断窗口中的字符与p是否异位词
     */
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> list = new ArrayList<>();
        if (p.length() > s.length()) {
            return list;
        }
        int[] countP = new int[26];
        for (char ch : p.toCharArray()) {
            countP[ch - 'a']++;
        }
        int[] countS = new int[26];
        for (int r = 0; r < s.length(); r++) {
            countS[s.charAt(r) - 'a']++;
            int l = r - p.length() + 1;
            if (l < 0) {
                continue;
            }
            if (Arrays.equals(countS, countP)) {
                list.add(l);
            }
            countS[s.charAt(l) - 'a']--;
        }
        return list;
    }

    /**
     * 固定长度窗口，利用Map判断窗口中的字符与p是否异位词，相比数组的速度慢一点
     */
    public List<Integer> findAnagramsUsingMap(String s, String p) {
        List<Integer> list = new ArrayList<>();
        int windowSize = p.length();
        Map<Character, Integer> pMap = new HashMap<>();
        for (char c : p.toCharArray()) {
            pMap.put(c, pMap.getOrDefault(c, 0) + 1);
        }
        Map<Character, Integer> sMap = new HashMap<>();
        for (int i = 0; i < windowSize; i++) {
            sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
        }
        for (int i = windowSize; i <= s.length(); i++) {
            if (pMap.equals(sMap)) {
                list.add(i - windowSize);
            }
            sMap.put(s.charAt(i - windowSize), sMap.getOrDefault(s.charAt(i - windowSize), 0) - 1);
            if (sMap.get(s.charAt(i - windowSize)) == 0) {
                sMap.remove(s.charAt(i - windowSize));
            }
            if (i < s.length()) {
                sMap.put(s.charAt(i), sMap.getOrDefault(s.charAt(i), 0) + 1);
            }
        }
        return list;
    }
}
