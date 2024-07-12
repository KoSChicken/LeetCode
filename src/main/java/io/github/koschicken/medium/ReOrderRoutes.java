package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/reorder-routes-to-make-all-paths-lead-to-the-city-zero/">1466. 重新规划路线</a>
 */
public class ReOrderRoutes {

    @Test
    void solution() {
        assertEquals(2, minReorder(5, new int[][]{{4, 3}, {2, 3}, {1, 2}, {1, 0}}));
    }

    public int minReorder(int n, int[][] connections) {
        // 建图，第一层List的下标含义是城市序号，内容是与该城市相邻的城市。
        // 第二层List中的数组中第一个元素是城市序号，第二个元素是道路情况。
        List<List<int[]>> graph = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            graph.add(new ArrayList<>());
        }
        for (int[] connection : connections) {
            // 保存道路情况，例如connection为[4,3]，则对于城市4，去城市3的道路是正向；而对于城市3，去城市4的道路为逆向。
            graph.get(connection[0]).add(new int[]{connection[1], 1});
            graph.get(connection[1]).add(new int[]{connection[0], 0});
        }
        boolean[] visited = new boolean[n];
        return dfs(0, graph, visited);
    }

    private int dfs(int node, List<List<int[]>> graph, boolean[] visited) {
        visited[node] = true;
        int changeCount = 0;
        if (Objects.nonNull(graph.get(node))) {
            for (int[] neighbor : graph.get(node)) {
                if (!visited[neighbor[0]]) {
                    // 如果当前路线需要改变方向，则增加计数
                    changeCount += neighbor[1];
                    // 递归调用 dfs 方法，继续检查从相邻城市出发的路线，并累加返回的计数
                    changeCount += dfs(neighbor[0], graph, visited);
                }
            }
        }
        return changeCount;
    }
}
