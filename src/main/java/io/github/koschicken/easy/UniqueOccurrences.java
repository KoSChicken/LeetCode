package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <a href="https://leetcode.cn/problems/unique-number-of-occurrences/">1207. 独一无二的出现次数</a>
 */
public class UniqueOccurrences {

    @Test
    void solution() {
        assertTrue(uniqueOccurrences(new int[]{1, 2, 2, 1, 1, 3}));
        assertFalse(uniqueOccurrences(new int[]{1, 2}));
        assertTrue(uniqueOccurrences(new int[]{-3, 0, 1, -3, 1, 1, 1, -3, 10, 0}));
    }

    public boolean uniqueOccurrences(int[] arr) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map.values().size() == new HashSet<>(map.values()).size();
    }
}
