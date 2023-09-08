package io.github.koschicken.easy;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

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
            if (!deque.isEmpty() && map.get(str.charAt(i)) == deque.peek()) {
                deque.pop();
            } else {
                deque.push(str.charAt(i));
            }
        }
        return deque.isEmpty();
    }
}
