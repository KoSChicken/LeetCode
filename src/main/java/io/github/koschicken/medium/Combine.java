package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combinations/description/">77. 组合</a>
 */
public class Combine {

    @Test
    void solution() {
        System.out.println(combine(4, 2));
    }

    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<>();
        dfs(n, k, new LinkedList<>(), result);
        return result;
    }

    private void dfs(int n, int k, LinkedList<Integer> path, List<List<Integer>> result) {
        if (path.size() == k) {
            result.add(new ArrayList<>(path));
            return;
        }
        for (int j = n; j > 0; j--) {
            path.push(j);
            dfs(j - 1, k, path, result);
            path.poll();
        }
    }
}
