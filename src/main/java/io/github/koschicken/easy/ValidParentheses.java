package io.github.koschicken.easy;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/valid-parentheses/description/">20. 有效的括号</a>
 */
public class ValidParentheses {

    private static final Map<Character, Character> map = new HashMap<>();

    static {
        map.put(')', '(');
        map.put(']', '[');
        map.put('}', '{');
    }

    public static void main(String[] args) {
        // boolean valid = isValid("([{}])");
        boolean valid = isValid("()[]{}");
        System.out.println(valid);
    }

    public static boolean isValid(String str) {
        if (str.isEmpty() || str.length() % 2 != 0) return false;
        Deque<Character> deque = new ArrayDeque<>();
        deque.push(str.charAt(0));
        for (int i = 1; i < str.length(); i++) {
            if (!deque.isEmpty() && Objects.equals(map.get(str.charAt(i)), deque.peek())) {
                deque.pop();
            } else {
                deque.push(str.charAt(i));
            }
        }
        return deque.isEmpty();
    }
}
