package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/string-compression/description/">443. 压缩字符串</a>
 */
public class CompressString {

    @Test
    void solution() {
        assertEquals(compress(new char[]{'a', 'b', 'c'}), 3); // {'a','b','c'}
        // assertEquals(compress(new char[]{'a', 'a', 'a', 'b', 'b', 'a', 'a'}), 6); // {'a','3','b','2','a','2'}
        // assertEquals(compress(new char[]{'a', 'a', 'b', 'b', 'c', 'c', 'c'}), 6); // {'a','2','b','2','c','3'}
        // assertEquals(compress(new char[]{'a'}), 1); // {'a'}
        // assertEquals(compress(new char[]{'a', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b', 'b'}), 4); // {'a', 'b', '1', '2'}
    }

    public int compress(char[] chars) {
        int length = chars.length;
        if (length == 1) {
            return 1;
        }
        int count = 1;
        int index1 = 0;
        int index2 = 1;
        int ans = 0;
        while (index2 <= length) {
            if (index2 < length && chars[index1] == chars[index2]) {
                index2++;
                count++;
            }
            if (index2 == length || chars[index1] != chars[index2]) {
                char[] compressed = compress(chars[index1], count);
                for (char c : compressed) {
                    chars[ans] = c;
                    ans++;
                }
                index1 = index2;
                index2++;
                count = 1;
            }
        }
        System.out.println(new String(chars).substring(0, ans));
        return ans;
    }

    private char[] compress(char ch, int count) {
        if (count == 1) {
            return new char[]{ch};
        }
        int length = (int) (Math.log10(count) + 1);
        char[] temp = new char[length + 1];
        temp[0] = ch;
        for (int i = length - 1; i >= 0; i--) {
            temp[i + 1] = (char) ('0' + count % 10);
            count /= 10;
        }
        return temp;
    }

    @Test
    void testFill() {
        char[] temp = new char[5];
        compress('a', 1999);
        System.out.println(Arrays.toString(temp));
    }
}
