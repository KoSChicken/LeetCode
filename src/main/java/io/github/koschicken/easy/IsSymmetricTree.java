package io.github.koschicken.easy;

import io.github.koschicken.common.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/symmetric-tree">101. 对称二叉树</a>
 */
public class IsSymmetricTree {

    public static void main(String[] args) {
        // 1223443
        TreeNode root = new TreeNode(1);
        TreeNode t1 = new TreeNode(2);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(4);
        TreeNode t6 = new TreeNode(4);
        root.left = t1;
        root.right = t2;
        t1.left = t3;
        t1.right = t5;
        t2.left = t6;
        t2.right = t4;
        System.out.println(isSymmetricRecursive(root));
    }

    private static boolean isSymmetricRecursive(TreeNode root) {
        return isSymmetricRecursive(root.left, root.right);
    }

    private static boolean isSymmetricRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q == null) return false;
        if (p == null) return false;
        if (p.val == q.val) {
            return isSymmetricRecursive(p.left, q.right) && isSymmetricRecursive(p.right, q.left);
        }
        return false;
    }

    private static boolean isSymmetric(TreeNode root) {
        // TODO 用队列实现遍历
        return false;
    }
}
