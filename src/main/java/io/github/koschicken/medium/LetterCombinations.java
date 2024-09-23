package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/letter-combinations-of-a-phone-number/description/">17. 电话号码的字母组合</a>
 */
public class LetterCombinations {

    @Test
    void solution() {
        System.out.println(letterCombinations(""));
        System.out.println(letterCombinations("2"));
        System.out.println(letterCombinations("23"));
        System.out.println(letterCombinations("234"));
        System.out.println(letterCombinations("7777"));
    }

    public List<String> letterCombinations(String digits) {
        if ("".equals(digits)) {
            return Collections.emptyList();
        }
        String[] dict = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        List<String> input = new ArrayList<>();
        for (Character ch : digits.toCharArray()) {
            input.add(dict[ch - 48]);
        }
        List<String> result = new ArrayList<>();
        cartesianProduct(result, "", input, 0);
        return result;
    }

    /**
     * 递归求笛卡尔积
     */
    private void cartesianProduct(List<String> result, String current, List<String> strings, int depth) {
        if (depth == strings.size()) {
            result.add(current);
            return;
        }
        for (char c : strings.get(depth).toCharArray()) {
            current += c;
            cartesianProduct(result, current, strings, depth + 1);
            current = current.substring(0, current.length() - 1);
        }
    }
}
