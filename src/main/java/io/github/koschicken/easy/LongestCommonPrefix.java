package io.github.koschicken.easy;

/**
 * <a href="https://leetcode.cn/problems/longest-common-prefix/description/">14. 最长公共前缀</a>
 */
public class LongestCommonPrefix {

    public static void main(String[] args) {
        String[] strings = {"cir", "car"};
        String longestCommonPrefix = longestCommonPrefix(strings);
        System.out.println(longestCommonPrefix);
        // System.out.println(longestCommonPrefix("flower", "flow"));
    }

    public static String longestCommonPrefix(String[] strs) {
        String s = strs[0];
        for (int i = 0; i < strs.length - 1; i++) {
            s = longestCommonPrefix(strs[i], strs[i + 1]);
            if (s.isEmpty()) return s;
            strs[i + 1] = s;
        }
        return s;
    }

    private static String longestCommonPrefix(String str1, String str2) {
        int length = 0;
        for (int i = 0; i < (Math.min(str1.length(), str2.length())); i++) {
            if (str1.charAt(i) == str2.charAt(i)) {
                length++;
            } else {
                break;
            }
        }
        return str1.substring(0, length);
    }
}
