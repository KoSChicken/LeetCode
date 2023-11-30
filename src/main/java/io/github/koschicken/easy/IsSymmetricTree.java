package io.github.koschicken.easy;

import io.github.koschicken.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <a href="https://leetcode.cn/problems/symmetric-tree">101. 对称二叉树</a>
 */
public class IsSymmetricTree {

    @Test
    void solution() {
        TreeNode symmetricTree = new TreeNode(new Integer[]{1, 2, 2, 3, 4, 4, 3});
        assertTrue(isSymmetricRecursive(symmetricTree));
    }

    public boolean isSymmetricRecursive(TreeNode root) {
        return isSymmetricRecursive(root.left, root.right);
    }

    public boolean isSymmetricRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q == null) return false;
        if (p == null) return false;
        if (p.val == q.val) {
            return isSymmetricRecursive(p.left, q.right) && isSymmetricRecursive(p.right, q.left);
        }
        return false;
    }

    public boolean isSymmetric(TreeNode root) {
        // TODO 用队列实现遍历
        return false;
    }
}
