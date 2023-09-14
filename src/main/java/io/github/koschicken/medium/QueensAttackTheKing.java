package io.github.koschicken.medium;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class QueensAttackTheKing {

    @Test
    void solution() {
        // 输入：queens = [[0,1],[1,0],[4,0],[0,4],[3,3],[2,4]], king = [0,0]
        // 输出：[[0,1],[1,0],[3,3]]
        int[][] queens = {{0, 1}, {1, 0}, {4, 0}, {0, 4}, {3, 3}, {2, 4}};
        int[] king = {0, 0};
        queensAttacktheKing(queens, king).forEach(System.out::println);
        System.out.println();
        // 输入：queens = [[0,0],[1,1],[2,2],[3,4],[3,5],[4,4],[4,5]], king = [3,3]
        // 输出：[[2,2],[3,4],[4,4]]
        queensAttacktheKing(new int[][]{{0, 0}, {1, 1}, {2, 2}, {3, 4}, {3, 5}, {4, 4}, {4, 5}}, new int[]{3, 3}).forEach(System.out::println);
        System.out.println();
        // 输入：queens = {{5,6},{7,7},{2,1},{0,7},{1,6},{5,1},{3,7},{0,3},{4,0},{1,2},{6,3},{5,0},{0,4},{2,2},{1,1},{6,4},{5,4},{0,0},{2,6},{4,5},{5,2},{1,4},{7,5},{2,3},{0,5},{4,2},{1,0},{2,7},{0,1},{4,6},{6,1},{0,6},{4,3},{1,7}}, king = {3,4}
        // 输出：[[2,3],[1,4],[1,6],[3,7],[4,3],[5,4],[4,5]]
        queensAttacktheKing(new int[][]{{5, 6}, {7, 7}, {2, 1}, {0, 7}, {1, 6}, {5, 1}, {3, 7}, {0, 3}, {4, 0}, {1, 2}, {6, 3}, {5, 0}, {0, 4}, {2, 2}, {1, 1}, {6, 4}, {5, 4}, {0, 0}, {2, 6}, {4, 5}, {5, 2}, {1, 4}, {7, 5}, {2, 3}, {0, 5}, {4, 2}, {1, 0}, {2, 7}, {0, 1}, {4, 6}, {6, 1}, {0, 6}, {4, 3}, {1, 7}}, new int[]{3, 4}).forEach(System.out::println);
    }

    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        List<List<Integer>> res = new ArrayList<>();
        // 同一行
        List<List<Integer>> sameRow = sameRowNearest(queens, king);
        // 同一列
        List<List<Integer>> sameCol = sameColNearest(queens, king);
        // 对角线
        List<List<Integer>> diagonal = diagonalNearest(queens, king);
        res.addAll(sameRow);
        res.addAll(sameCol);
        res.addAll(diagonal);
        return res;
    }

    public List<List<Integer>> sameRowNearest(int[][] queens, int[] king) {
        List<List<Integer>> left = new ArrayList<>();
        List<List<Integer>> right = new ArrayList<>();
        for (int[] queen : queens) {
            if (queen[0] == king[0]) {
                // 是否在king的左边
                boolean isLeftSide = queen[1] < king[1];
                List<Integer> queenL = Arrays.stream(queen).boxed().toList();
                if (isLeftSide) {
                    left.add(queenL);
                } else {
                    right.add(queenL);
                }
            }
        }
        ArrayList<List<Integer>> res = new ArrayList<>();
        findNearest(res, left, king);
        findNearest(res, right, king);
        return res;
    }

    public List<List<Integer>> sameColNearest(int[][] queens, int[] king) {
        List<List<Integer>> up = new ArrayList<>();
        List<List<Integer>> down = new ArrayList<>();
        for (int[] queen : queens) {
            if (queen[1] == king[1]) {
                // 是否在king的上边
                boolean isUpSide = queen[0] < king[0];
                List<Integer> queenL = Arrays.stream(queen).boxed().toList();
                if (isUpSide) {
                    up.add(queenL);
                } else {
                    down.add(queenL);
                }
            }
        }
        ArrayList<List<Integer>> res = new ArrayList<>();
        findNearest(res, up, king);
        findNearest(res, down, king);
        return res;
    }

    public List<List<Integer>> diagonalNearest(int[][] queens, int[] king) {
        List<List<Integer>> westNorth = new ArrayList<>();
        List<List<Integer>> westSouth = new ArrayList<>();
        List<List<Integer>> estNorth = new ArrayList<>();
        List<List<Integer>> estSouth = new ArrayList<>();
        for (int[] queen : queens) {
            if (Math.abs(queen[0] - king[0]) == Math.abs(queen[1] - king[1])) {
                boolean isWest = queen[0] < king[0];
                boolean isNorth = queen[1] < king[1];
                List<Integer> queenL = Arrays.stream(queen).boxed().toList();
                if (isWest) {
                    if (isNorth) {
                        westNorth.add(queenL);
                    } else {
                        westSouth.add(queenL);
                    }
                } else {
                    if (isNorth) {
                        estNorth.add(queenL);
                    } else {
                        estSouth.add(queenL);
                    }
                }
            }
        }
        ArrayList<List<Integer>> res = new ArrayList<>();
        findNearest(res, westNorth, king);
        findNearest(res, westSouth, king);
        findNearest(res, estNorth, king);
        findNearest(res, estSouth, king);
        return res;
    }

    private void findNearest(List<List<Integer>> res, List<List<Integer>> list, int[] king) {
        if (!list.isEmpty()) {
            int min = 14;
            List<Integer> q = list.get(0);
            for (List<Integer> queen : list) {
                int distance = Math.abs(queen.get(0) - king[0]) + Math.abs(queen.get(1) - king[1]);
                if (distance < min) {
                    min = distance;
                    q = queen;
                }
            }
            res.add(q);
        }
    }
}
