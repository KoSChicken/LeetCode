package io.github.koschicken.easy;

import io.github.koschicken.common.TreeNode;

public class IsBalancedTree {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(2);
        TreeNode t4 = new TreeNode(3);
        TreeNode t5 = new TreeNode(3);
        TreeNode t6 = new TreeNode(4);
        TreeNode t7 = new TreeNode(4);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.left = t5;
        t4.left = t6;
        t5.left = t7;
        System.out.println(isBalanced(t1));
    }

    public static boolean isBalanced(TreeNode root) {
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

    private static int maxDepthRecur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepthRecur(root.left);
        int rightDepth = maxDepthRecur(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }
}
