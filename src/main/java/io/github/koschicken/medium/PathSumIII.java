package io.github.koschicken.medium;

import io.github.koschicken.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/path-sum-iii/">437. 路径总和 III</a>
 */
public class PathSumIII {

    @Test
    void solution() {
        TreeNode tree1 = new TreeNode(new Integer[]{8, 5, -3, 3, 2, null, 11, 8, -2, null, 1});
        assertEquals(pathSum(tree1, 8), 5);
        assertEquals(pathSumPrefix(tree1, 8), 5);
        TreeNode tree2 = new TreeNode(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, 5, 1});
        assertEquals(pathSum(tree2, 22), 3);
        assertEquals(pathSumPrefix(tree2, 22), 3);
    }

    public int pathSumPrefix(TreeNode root, int targetSum) {
        Map<Long, Integer> prefix = new HashMap<>();
        prefix.put(0L, 1);
        return dfs(root, prefix, 0, targetSum);
    }

    /**
     * 官解：前缀和+dfs
     *
     * @param prefix key是当前节点前缀和，value是前缀和为key的节点数量
     * @param curr   当前节点的前缀和
     */
    private int dfs(TreeNode root, Map<Long, Integer> prefix, long curr, int targetSum) {
        if (root == null) {
            return 0;
        }
        // 计算当前节点前缀和
        curr += root.val;
        // 如果map里存在一个前缀和等于当前节点前缀和减去目标路径和，说明根节点到当前节点的路径上，存在一个路径的和等于目标路径和，则把计数加一
        int ret = prefix.getOrDefault(curr - targetSum, 0);
        // 将当前节点的前缀和更新到map里
        prefix.put(curr, prefix.getOrDefault(curr, 0) + 1);
        // 对当前节点的左右节点进行递归
        ret += dfs(root.left, prefix, curr, targetSum);
        ret += dfs(root.right, prefix, curr, targetSum);
        // 运行到这一行，说明节点遍历的方向发生了改变，此时要将路径前缀和清除，避免获取到不存在路径上的节点的数据
        prefix.put(curr, prefix.getOrDefault(curr, 0) - 1);
        return ret;
    }

    /**
     * 嵌套的递归，遍历树，并对每个节点进行dfs
     */
    public int pathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return 0;
        }
        int count = fromRoot(root, targetSum);
        count += pathSum(root.left, targetSum);
        count += pathSum(root.right, targetSum);
        return count;
    }

    /**
     * dfs
     */
    private int fromRoot(TreeNode root, long targetSum) {
        if (root == null) {
            return 0;
        }
        int count = 0;
        long sub = targetSum - root.val;
        if (sub == 0) {
            count++;
        }
        count += fromRoot(root.left, sub);
        count += fromRoot(root.right, sub);
        return count;
    }
}
