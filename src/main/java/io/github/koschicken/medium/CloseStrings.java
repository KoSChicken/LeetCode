package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <a href="https://leetcode.cn/problems/determine-if-two-strings-are-close/">1657. 确定两个字符串是否接近</a>
 */
public class CloseStrings {

    @Test
    void solution() {
        assertTrue(closeStrings("abc", "bca"));
        assertFalse(closeStrings("a", "aa"));
        assertTrue(closeStrings("cabbba", "abbccc"));
        assertFalse(closeStrings("cabbba", "aabbss"));
    }

    /**
     * 本质和下面用Map的一样，但是数组速度快一点
     */
    public boolean closeStrings(String word1, String word2) {
        char[] charArr1 = word1.toCharArray();
        char[] charArr2 = word2.toCharArray();
        if (charArr1.length != charArr2.length) {
            return false;
        }
        int length = charArr1.length;
        int[] arr1 = new int[26];
        int[] arr2 = new int[26];
        for (int i = 0; i < length; i++) {
            arr1[charArr1[i] - 'a']++;
            arr2[charArr2[i] - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (arr1[i] == 0 && arr2[i] != 0) {
                return false;
            }
        }
        Arrays.sort(arr1);
        Arrays.sort(arr2);
        for (int i = 0; i < 26; i++) {
            if (arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }

    public boolean closeStringsByMap(String word1, String word2) {
        if (word1.length() != word2.length()) {
            return false;
        }
        char[] word1CharArray = word1.toCharArray();
        HashMap<Character, Integer> map1 = new HashMap<>();
        for (char c : word1CharArray) {
            map1.put(c, map1.getOrDefault(c, 0) + 1);
        }
        char[] word2CharArray = word2.toCharArray();
        HashMap<Character, Integer> map2 = new HashMap<>();
        for (char c : word2CharArray) {
            map2.put(c, map2.getOrDefault(c, 0) + 1);
        }
        Set<Character> keySet1 = map1.keySet();
        Set<Character> keySet2 = map2.keySet();
        if (!keySet1.equals(keySet2)) {
            return false;
        }
        List<Integer> list1 = map1.values().stream().sorted().toList();
        List<Integer> list2 = map2.values().stream().sorted().toList();
        return list1.equals(list2);
    }
}
