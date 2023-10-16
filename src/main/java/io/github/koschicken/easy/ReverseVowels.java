package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/reverse-vowels-of-a-string/">345. 反转字符串中的元音字母</a>
 */
public class ReverseVowels {

    @Test
    void solution() {
        assertEquals(reverseVowels("A man, a plan, a canal: Panama"), "a man, a plan, a canal: PanamA");
        assertEquals(reverseVowels("hello"), "holle");
    }

    public String reverseVowels(String s) {
        char[] charArray = s.toCharArray();
        int head = 0;
        int tail = s.length() - 1;
        while (head < tail) {
            if (isVowels(charArray[head]) && isVowels(charArray[tail])) {
                char t = charArray[head];
                charArray[head] = charArray[tail];
                charArray[tail] = t;
                head++;
                tail--;
            }
            if (!isVowels(charArray[head])) {
                head++;
            }
            if (!isVowels(charArray[tail])) {
                tail--;
            }
        }
        return new String(charArray);
    }

    private boolean isVowels(char ch) {
        return ch == 'a' || ch == 'A'
                || ch == 'e' || ch == 'E'
                || ch == 'i' || ch == 'I'
                || ch == 'o' || ch == 'O'
                || ch == 'u' || ch == 'U';
    }
}
