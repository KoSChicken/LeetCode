package io.github.koschicken.easy;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * <a href="https://leetcode.cn/problems/find-the-difference-of-two-arrays/">2215. 找出两数组的不同</a>
 */
public class FindDifference {

    @Test
    void solution() {
        assertIterableEquals(findDifference(new int[]{1, 2, 3}, new int[]{2, 4, 6}), List.of(List.of(1, 3), List.of(4, 6)));
        assertIterableEquals(findDifference(new int[]{1, 2, 3, 3}, new int[]{1, 1, 2, 2}), List.of(List.of(3), List.of()));
    }

    public List<List<Integer>> findDifference(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1).boxed().collect(Collectors.toSet());
        Set<Integer> set2 = Arrays.stream(nums2).boxed().collect(Collectors.toSet());
        List<Integer> list1 = new ArrayList<>(set1);
        list1.removeAll(set2);
        List<Integer> list2 = new ArrayList<>(set2);
        list2.removeAll(set1);
        List<List<Integer>> result = new ArrayList<>();
        result.add(list1);
        result.add(list2);
        return result;
    }
}
