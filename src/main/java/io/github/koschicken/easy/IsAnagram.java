package io.github.koschicken.easy;

/**
 * <a href="https://leetcode.cn/problems/valid-anagram/description/">242. 有效的字母异位词</a>
 */
public class IsAnagram {

    public static void main(String[] args) {
        System.out.println(isAnagram("anagram", "nagaram"));
        System.out.println(isAnagram("rat", "car"));
    }

    private static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] arr = new int['{'];
        for (int i = 0; i < s.length(); i++) {
            arr[s.charAt(i)]++;
            arr[t.charAt(i)]--;
        }
        for (int i : arr) {
            if (i != 0) {
                return false;
            }
        }
        return true;
    }
}
