package io.github.koschicken.medium;

import io.github.koschicken.common.UnionFindSet;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.LinkedList;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/number-of-provinces/description/">547. 省份数量</a>
 */
public class NumberOfProvinces {

    @Test
    void solution() {
        assertEquals(1, findCircleNumDFS(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}));
        assertEquals(1, findCircleNumBFS(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}));
        assertEquals(1, findCircleNumUFS(new int[][]{{1, 0, 0, 1}, {0, 1, 1, 0}, {0, 1, 1, 1}, {1, 0, 1, 1}}));
    }

    public int findCircleNumDFS(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                dfs(isConnected, n, i, visited);
                provinces++;
            }
        }
        return provinces;
    }

    private void dfs(int[][] isConnected, int n, int i, boolean[] visited) {
        for (int j = 0; j < n; j++) {
            if (isConnected[i][j] == 1 && !visited[j]) {
                visited[j] = true;
                dfs(isConnected, n, j, visited);
            }
        }
    }

    public int findCircleNumBFS(int[][] isConnected) {
        int n = isConnected.length;
        boolean[] visited = new boolean[n];
        LinkedList<Integer> queue = new LinkedList<>();
        int provinces = 0;
        for (int i = 0; i < n; i++) {
            if (!visited[i]) {
                queue.offer(i);
                while (!queue.isEmpty()) {
                    Integer poll = queue.poll();
                    visited[poll] = true;
                    for (int j = 0; j < n; j++) {
                        if (isConnected[poll][j] == 1 && !visited[j]) {
                            queue.offer(j);
                        }
                    }
                }
                provinces++;
            }
        }
        return provinces;
    }

    /**
     * 使用并查集
     */
    public int findCircleNumUFS(int[][] isConnected) {
        int n = isConnected.length;
        if (n == 1) return 1;
        UnionFindSet unionFindSet = new UnionFindSet(n);
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (isConnected[i][j] == 1) {
                    unionFindSet.union(i, j);
                }
            }
        }
        HashSet<Integer> res = new HashSet<>();
        for (int i = 0; i < n; i++) {
            res.add(unionFindSet.find(i));
        }
        return res.size();
    }
}