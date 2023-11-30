package io.github.koschicken.easy;

import io.github.koschicken.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <a href="https://leetcode.cn/problems/balanced-binary-tree/description/">110. 平衡二叉树</a>
 */
public class IsBalancedTree {

    @Test
    void solution() {
        assertTrue(isBalanced(new TreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})));
        assertFalse(isBalanced(new TreeNode(new Integer[]{1, 2, 2, 3, 3, null, null, 4, 4})));
        assertFalse(isBalanced(new TreeNode(new Integer[]{1, 2, 2, 3, null, null, 3, 4, null, null, 4})));
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }
        int leftDepth = maxDepthRecur(root.left);
        int rightDepth = maxDepthRecur(root.right);
        if (Math.abs(leftDepth - rightDepth) > 1) {
            return false;
        }
        return isBalanced(root.left) && isBalanced(root.right);
    }

    private int maxDepthRecur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepthRecur(root.left);
        int rightDepth = maxDepthRecur(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
