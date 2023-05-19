package io.github.koschicken.easy;

import java.util.HashMap;
import java.util.Map;

public class IsIsomorphic {

    public static void main(String[] args) {
        System.out.println(isIsomorphic("badc", "baba"));
    }

    private static boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        Map<Character, Character> map1 = new HashMap<>();
        Map<Character, Character> map2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            map1.putIfAbsent(s.charAt(i), t.charAt(i));
            if (map1.get(s.charAt(i)) != t.charAt(i)) {
                return false;
            }
            map2.putIfAbsent(t.charAt(i), s.charAt(i));
            if (map2.get(t.charAt(i)) != s.charAt(i)) {
                return false;
            }
        }
        return true;
    }
}
