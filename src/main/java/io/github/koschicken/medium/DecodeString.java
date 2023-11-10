package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/decode-string/">394. 字符串解码</a>
 */
public class DecodeString {

    @Test
    void solution() {
        assertEquals(decodeString("3[a]2[bc]"), "aaabcbc");
        assertEquals(decodeString("3[a2[c]]"), "accaccacc");
        assertEquals(decodeString("2[abc]3[cd]ef"), "abcabccdcdcdef");
        assertEquals(decodeString("abc3[cd]xyz"), "abccdcdcdxyz");
        assertEquals(decodeString("13[z]2[2[y]pq4[2[jk]e1[f]]]ef"), "zzzzzzzzzzzzzyypqjkjkefjkjkefjkjkefjkjkefyypqjkjkefjkjkefjkjkefjkjkefef");
    }

    /**
     * 1. 顺序压栈.
     * 2. 当遇到右括号时，开始弹出，先弹到左括号，再继续弹出到下一个非数字为止
     * 3. 调用解码方法得到结果，拼接到最终结果上。
     */
    public String decodeString(String s) {
        Deque<String> deque = new ArrayDeque<>();
        for (char ch : s.toCharArray()) {
            deque.push(String.valueOf(ch));
            if (ch == ']') {
                ArrayList<String> list = new ArrayList<>();
                boolean meetLeftBracket = false;
                boolean meetLetter = false;
                while (!deque.isEmpty() && !(meetLeftBracket && meetLetter)) {
                    String c = deque.peek();
                    // 弹出左括号之后，继续查看栈顶，直到栈顶元素不是数字
                    if (c.equals("[") && !meetLeftBracket) {
                        meetLeftBracket = true;
                        list.add(deque.pop());
                    } else {
                        if (!isNumber(c) && meetLeftBracket) {
                            meetLetter = true;
                        } else {
                            list.add(deque.pop());
                        }
                    }
                }
                String decode = decode(list);
                deque.push(decode);
            }
        }
        StringBuilder res = new StringBuilder();
        while (!deque.isEmpty()) {
            res.append(deque.pollLast());
        }
        return res.toString();
    }

    private boolean isNumber(String str) {
        return str.charAt(0) >= '0' && str.charAt(0) <= '9';
    }

    private String decode(List<String> list) {
        StringBuilder sb = new StringBuilder();
        for (int i = list.size() - 1; i > 0; i--) {
            sb.append(list.get(i));
        }
        String str = sb.toString();
        String[] split = str.split("\\[");
        String countStr = split[0];
        String string = split[1].replace("]", "");
        return string.repeat(Math.max(0, Integer.parseInt(countStr)));
    }
}
