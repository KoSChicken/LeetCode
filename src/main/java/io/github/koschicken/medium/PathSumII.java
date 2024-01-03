package io.github.koschicken.medium;

import io.github.koschicken.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <a href="https://leetcode.cn/problems/path-sum-ii/description/">113. 路径总和 II</a>
 */
public class PathSumII {

    @Test
    void solution() {
        List<List<Integer>> expected = pathSum(new TreeNode(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1}), 22);
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(Arrays.asList(5, 4, 11, 2));
        ans.add(Arrays.asList(5, 8, 4, 5));
        assertIterableEquals(expected, ans);
        assertTrue(pathSum(new TreeNode(new Integer[]{1, 2, 3}), 5).isEmpty());
    }

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        List<List<Integer>> paths = new ArrayList<>();
        pathSum(root, new ArrayList<>(), paths, targetSum);
        return paths;
    }

    /**
     * dfs，但只记录符合条件的路径
     */
    private void pathSum(TreeNode node, List<Integer> path, List<List<Integer>> paths, int target) {
        if (node != null) {
            path.add(node.val);
            int sub = target - node.val;
            if (node.left == null && node.right == null && sub == 0) {
                paths.add(new ArrayList<>(path));
            }
            pathSum(node.left, new ArrayList<>(path), paths, sub);
            pathSum(node.right, new ArrayList<>(path), paths, sub);
            path.remove(path.size() - 1);
        }
    }
}
