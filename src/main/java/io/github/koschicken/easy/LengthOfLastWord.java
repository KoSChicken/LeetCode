package io.github.koschicken.easy;

/**
 * <a href="https://leetcode.cn/problems/length-of-last-word/description/">58. 最后一个单词的长度</a>
 */
public class LengthOfLastWord {

    public static void main(String[] args) {
//        String s = "hello world";
        String s = "b a    ";
        System.out.println(lengthOfLastWord(s));
        System.out.println(lengthOfLastWordSeriously(s));
    }

    private static int lengthOfLastWord(String s) {
        if (s.isBlank()) {
            return 0;
        }
        if (s.endsWith(" ")) {
            s = s.trim();
        }
        String[] s1 = s.split(" ");
        return s1[s1.length - 1].length();
    }

    private static int lengthOfLastWordSeriously(String s) {
        if (s.isBlank()) {
            return 0;
        }
        int length = 0;
        boolean notEmpty = false;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (notEmpty && s.charAt(i) == ' ') {
                break;
            }
            if (s.charAt(i) != ' ') {
                length++;
                notEmpty = true;
            }
        }
        return length;
    }
}
