package io.github.koschicken.easy;

public class StrStr {

    // Unsolved
    public static void main(String[] args) {
//        int[] next = getNext("abababca");
//        System.out.println(Arrays.toString(next));
        int i = strStr("ababababca", "abababca");
        System.out.println(i);
    }

    /**
     * 查找子串 AKA KMP算法
     *
     * @param haystack 主串
     * @param needle   模式串
     */
    public static int strStr(String haystack, String needle) {
        int n = haystack.length(), m = needle.length();
        if (m == 0) {
            return 0;
        }
//        int[] pi = new int[m];
//        for (int i = 1, j = 0; i < m; i++) {
//            while (j > 0 && needle.charAt(i) != needle.charAt(j)) {
//                j = pi[j - 1];
//            }
//            if (needle.charAt(i) == needle.charAt(j)) {
//                j++;
//            }
//            pi[i] = j;
//        }
        int[] pi = getNext(needle);
        for (int i = 0, j = 0; i < n; i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = pi[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            if (j == m) {
                return i - m + 1;
            }
        }
        return -1;
    }

    private static int[] getNext(String needle) {
        int[] next = new int[needle.length()];
        int i = 1;
        int now = 0;
        while (i < needle.length()) {
            if (needle.charAt(i) == needle.charAt(now)) {
                now++;
                next[i] = now;
                i++;
            } else if (now != 0) {
                now = next[now - 1];
            } else {
                i++;
                next[i] = now;
            }
        }
        return next;
    }
}
