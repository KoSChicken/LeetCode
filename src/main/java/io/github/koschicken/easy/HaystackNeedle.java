package io.github.koschicken.easy;

/**
 * <a href="https://leetcode.cn/problems/find-the-index-of-the-first-occurrence-in-a-string/description/">28. 找出字符串中第一个匹配项的下标</a>
 */
public class HaystackNeedle {

    public static void main(String[] args) {
//        int r1 = strStr("sadbutsad", "sad");
//        System.out.println(r1);
//        int r2 = strStr("leetcode", "leeto");
//        System.out.println(r2);
        int r3 = strStr("mississippi", "issip");
        System.out.println(r3);
    }

    public static int strStr(String haystack, String needle) {
        int longLength = haystack.length();
        int shortLength = needle.length();
        int slow = 0;
        int fast1 = 0;
        int fast2 = 0;
        while (fast1 < longLength && fast2 < shortLength) {
            if (haystack.charAt(fast1) != needle.charAt(fast2)) {
                slow++;
                fast1 = slow;
                fast2 = 0;
            } else {
                fast1++;
                fast2++;
            }
            if (fast2 == shortLength) {
                return slow;
            }
        }
        return -1;
    }
}
