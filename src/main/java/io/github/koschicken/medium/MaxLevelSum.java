package io.github.koschicken.medium;

import io.github.koschicken.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/maximum-level-sum-of-a-binary-tree/">1161. 最大层内元素和</a>
 */
public class MaxLevelSum {

    @Test
    void solution() {
        assertEquals(maxLevelSum(new TreeNode(new Integer[]{1, 7, 0, 7, -8, null, null})), 2);
        assertEquals(maxLevelSum(new TreeNode(new Integer[]{989, null, 10250, 98693, -89388, null, null, null, -32127})), 2);
        assertEquals(maxLevelSum(new TreeNode(new Integer[]{-100, -200, -300, -20, -5, -10, null})), 3);
    }

    /**
     * 层序遍历，每层都计算总和，同时更新最大和，记录最大和层号，但只有在总和大于已记录的最大和时才更新最大和层号
     */
    public int maxLevelSum(TreeNode root) {
        int maxSumLevel = 0;
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cur = 1;
        int next = 0;
        int currentLevel = 0;
        long maxLevelSum = Long.MIN_VALUE;
        long levelSum = 0;
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            cur--;
            if (poll.left != null) {
                queue.offer(poll.left);
                next++;
            }
            if (poll.right != null) {
                queue.offer(poll.right);
                next++;
            }
            levelSum += poll.val;
            if (cur == 0) {
                currentLevel++;
                if (levelSum > maxLevelSum) {
                    maxLevelSum = levelSum;
                    maxSumLevel = currentLevel;
                }
                cur = next;
                next = 0;
                levelSum = 0;
            }
        }
        return maxSumLevel;
    }
}
