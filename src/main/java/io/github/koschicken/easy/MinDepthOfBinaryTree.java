package io.github.koschicken.easy;

import io.github.koschicken.common.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree">111. 二叉树的最小深度</a>
 */
public class MinDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode tree = buildTree();
        System.out.println(minDepthRecur(tree));
    }

    public static int minDepthRecur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepthRecur(root.left);
        int rightDepth = minDepthRecur(root.right);
        return Math.min(leftDepth, rightDepth) + 1;
    }

    private static TreeNode buildTree() {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        return root;
    }
}
