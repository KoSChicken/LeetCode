package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/group-anagrams/description/">49. 字母异位词分组</a>
 */
public class GroupAnagrams {

    @Test
    void solution() {
        // 输入: strs = ["cab","tin","pew","duh","may","ill","buy","bar","max","doc"]
        // 输出: [["max"],["buy"],["doc"],["may"],["ill"],["duh"],["tin"],["bar"],["pew"],["cab"]]
        List<List<String>> lists = groupAnagrams(new String[]{"cab", "tin", "pew", "duh", "may", "ill", "buy", "bar", "max", "doc"});
        lists.forEach(list -> {
            System.out.println();
            list.forEach(System.out::println);
        });
    }

    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs) {
            String calc = sortString(str);
            List<String> list = map.get(calc);
            if (list == null) {
                list = new ArrayList<>();
                list.add(str);
                map.put(calc, list);
            } else {
                list.add(str);
            }
        }
        return new ArrayList<>(map.values());
    }

    private String sortString(String str) {
        char[] charArray = str.toCharArray();
        Arrays.sort(charArray);
        return new String(charArray);
    }
}
