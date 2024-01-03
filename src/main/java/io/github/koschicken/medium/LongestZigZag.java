package io.github.koschicken.medium;

import io.github.koschicken.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/longest-zigzag-path-in-a-binary-tree/">1372. 二叉树中的最长交错路径</a>
 */
public class LongestZigZag {

    private int max;

    @Test
    void solution() {
        TreeNode root = new TreeNode(new Integer[]{1, null, 1, 1, 1, null, null, 1, 1, null, 1, null, null, null, 1});
        assertEquals(longestZigZag(root), 3);
    }

    public int longestZigZag(TreeNode root) {
        if (root == null) {
            return 0;
        }
        max = 0;
        maxZigZag(root, 0, 0);
        maxZigZag(root, 1, 0);
        return max;
    }

    private void maxZigZag(TreeNode node, int direction, int length) {
        max = Math.max(max, length);
        if (direction == 0) {
            if (node.left != null) {
                maxZigZag(node.left, 1, length + 1);
            }
            if (node.right != null) {
                maxZigZag(node.right, 0, 1);
            }
        } else {
            if (node.right != null) {
                maxZigZag(node.right, 0, length + 1);
            }
            if (node.left != null) {
                maxZigZag(node.left, 1, 1);
            }
        }
    }
}
