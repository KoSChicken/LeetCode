package io.github.koschicken.medium;

import io.github.koschicken.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/">236. 二叉树的最近公共祖先</a>
 */
public class LowestCommonAncestor {

    @Test
    void solution() {
        TreeNode root = new TreeNode(new Integer[]{3, 5, 1, 6, 2, 0, 8, null, null, 7, 4});
        assertEquals(lowestCommonAncestor(root, root.left, root.left.left.right), root.left);
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return null;
        }
        // 如果p或q就是root，则LCA是root
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if (left != null && right != null) {
            return root;
        }
        return left != null ? left : right;  // 如果左右子树都不为空，则root就是LCA，否则就是null
    }
}
