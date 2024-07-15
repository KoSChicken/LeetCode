package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/nearest-exit-from-entrance-in-maze/description/">1926. 迷宫中离入口最近的出口</a>
 */
public class NearestExit {

    @Test
    void solution() {
        /*
            输入：maze = [["+","+",".","+"],[".",".",".","+"],["+","+","+","."]], entrance = [1,2]
            输出：1
         */
        assertEquals(1, nearestExit(new char[][]{{'+', '+', '.', '+'}, {'.', '.', '.', '+'}, {'+', '+', '+', '.'}}, new int[]{1, 2}));

        /*
            输入：maze = [["+","+","+"],[".",".","."],["+","+","+"]], entrance = [1,0]
            输出：2
         */
        assertEquals(2, nearestExit(new char[][]{{'+', '+', '+'}, {'.', '.', '.'}, {'+', '+', '+'}}, new int[]{1, 0}));
    }

    private static final int[][] DIRECTIONS = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; // 右 下 左 上

    public int nearestExit(char[][] maze, int[] entrance) {
        int step = 0;
        Queue<int[]> queue = new LinkedList<>();
        boolean[][] visited = new boolean[maze.length][maze[0].length];
        queue.offer(entrance);
        visited[entrance[0]][entrance[1]] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            step++;
            for (int i = 0; i < size; i++) {
                int[] current = queue.poll();
                int x = current[0];
                int y = current[1];
                // 入口不算出口，所以无论如何要先走一步
                for (int[] direction : DIRECTIONS) {
                    int newX = x + direction[0];
                    int newY = y + direction[1];

                    if (newX >= 0 && newY >= 0 && newX < maze.length && newY < maze[0].length && maze[newX][newY] == '.' && !visited[newX][newY]) {
                        if (newX == 0 || newX == maze.length - 1 || newY == 0 || newY == maze[0].length - 1) {
                            return step;
                        }
                        visited[newX][newY] = true;
                        queue.offer(new int[]{newX, newY});
                    }
                }
            }
        }
        return -1;
    }
}
