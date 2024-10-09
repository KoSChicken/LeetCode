package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/longest-common-subsequence/description/">1143. 最长公共子序列</a>
 */
public class LongestCommonSubsequence {

    @Test
    void solution() {
        assertEquals(1, longestCommonSubsequence("abcde", "ace"));
    }

    /**
     * <pre>
     *     假设text1="abcde"，text2="ace"。
     *     想象如下矩阵:
     *       a c e
     *     a 1 1 1
     *     b 1 1 1
     *     c 1 2 2
     *     d 1 2 2
     *     e 1 2 3
     *     矩阵中的数字代表当前两个字符串的最长公共子串的长度。
     *     可以很明显的看出来，矩阵中的某一位置(x,y)：
     *     当text1.charAt(x)==text2.charAt(y)时，(x,y)的值是(x-1,y-1)的值加一；
     *     当text1.charAt(x)!=text2.charAt(y)时，(x,y)的值是(x-1,y)和(x,y-1)中较大的那个值。
     *     在编写代码的时候，要处理x和y为0的情况，可以通过构建一个更大的矩阵，使得x=0和y=0时，矩阵内的值为0，此时可以从1开始循环，避免下标越界
     * </pre>
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int l1 = text1.length();
        int l2 = text2.length();
        int[][] dp = new int[l1 + 1][l2 + 1];
        for (int i = 1; i <= l1; i++) {
            char c1 = text1.charAt(i - 1);
            for (int j = 1; j <= l2; j++) {
                char c2 = text2.charAt(j - 1);
                if (c1 == c2) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[l1][l2];
    }
}
