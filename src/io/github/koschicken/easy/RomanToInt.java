package io.github.koschicken.easy;

import java.util.HashMap;

public class RomanToInt {

    private static final HashMap<Character, Integer> MAP = new HashMap<>();

    static {
        MAP.put('I', 1);
        MAP.put('V', 5);
        MAP.put('X', 10);
        MAP.put('L', 50);
        MAP.put('C', 100);
        MAP.put('D', 500);
        MAP.put('M', 1000);
    }

    public static void main(String[] args) {
        System.out.println(romanToInt("MCMXCIV"));
    }

    public static int romanToInt(String s) {
        if (s.length() == 1) return MAP.get(s.charAt(0));
        int result = 0;
        for (int i = 1; i < s.length(); i++) {
            Integer current = MAP.get(s.charAt(i - 1));
            Integer next = MAP.get(s.charAt(i));
            if (i == s.length() - 1) {
                result += next;
            }
            if (current < next) {
                result -= current;
            } else {
                result += current;
            }
        }
        return result;
    }
}
