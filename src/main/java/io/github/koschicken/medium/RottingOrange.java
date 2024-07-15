package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/rotting-oranges/description/">994. 腐烂的橘子</a>
 */
public class RottingOrange {

    @Test
    void solution() {
        // 输入：grid = [[2,1,1],[1,1,0],[0,1,1]]
        // 输出：4
        assertEquals(4, orangesRotting(new int[][]{{2, 1, 1}, {1, 1, 0}, {0, 1, 1}}));
        // 输入：grid = [[2,1,1],[0,1,1],[1,0,1]]
        // 输出：-1
        assertEquals(-1, orangesRotting(new int[][]{{2, 1, 1}, {0, 1, 1}, {1, 0, 1}}));
        // 输入：grid = [[0,2]]
        // 输出：0
        assertEquals(0, orangesRotting(new int[][]{{0, 2}}));
    }

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右 下 左 上

    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int orange = 0; // 好橘子的数量
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[m][n];
        // 将所有烂橘子加入队列
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 1) {
                    orange++;
                }
                if (grid[i][j] == 2) {
                    queue.offer(new int[]{i, j});
                    visited[i][j] = true;
                }
            }
        }
        // 先检测一次好橘子数量，如果为0直接返回
        if (orange == 0) {
            return 0;
        }
        int duration = 0;
        // BFS遍历，每次遍历到好橘子就减去一个好橘子的数量，当好橘子数量为0时中断遍历，返回遍历的层数
        while (!queue.isEmpty()) {
            int size = queue.size();
            duration++;
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                for (int[] direction : DIRECTIONS) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];
                    if (newX >= 0 && newY >= 0 && newX < m && newY < n && !visited[newX][newY]) {
                        visited[newX][newY] = true;
                        if (grid[newX][newY] == 1) {
                            orange--;
                            if (orange == 0) {
                                return duration;
                            }
                            queue.offer(new int[]{newX, newY});
                        }
                    }
                }
            }
        }
        // 遍历结束好橘子数量仍大于0，说明有桔子不会烂，返回-1
        return -1;
    }
}
