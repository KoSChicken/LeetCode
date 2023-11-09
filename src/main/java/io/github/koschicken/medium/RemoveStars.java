package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/removing-stars-from-a-string/">2390. 从字符串中移除星号</a>
 */
public class RemoveStars {

    @Test
    void solution() {
        assertEquals(removeStars("leet**cod*e"), "lecoe");
        assertEquals(removeStars("erase*****"), "");
    }

    public String removeStars(String s) {
        Deque<Character> deque = new ArrayDeque<>();
        for (char c : s.toCharArray()) {
            if (c != '*') {
                deque.push(c);
            } else {
                deque.pop();
            }
        }
        StringBuilder sb = new StringBuilder();
        while (!deque.isEmpty()) {
            sb.append(deque.pollLast());
        }
        return sb.toString();
    }
}
