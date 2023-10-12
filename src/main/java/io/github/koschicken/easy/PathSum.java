package io.github.koschicken.easy;

import io.github.koschicken.common.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/path-sum/description/">112. 路径总和</a>
 */
public class PathSum {

    public static void main(String[] args) {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        root.left = node1;
        root.right = node2;
        node2.left = node3;
        node2.right = node4;
        System.out.println(hasPathSum(root, 38));
    }

    /**
     * 递归处理单个节点，基准：目标值和节点值的差值为0。未达基准时处理节点的子节点，直到达到基准。
     */
    private static boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        boolean ans = false;
        int sub = targetSum - root.val;
        if (sub == 0 && root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null) {
            ans = hasPathSum(root.left, sub);
        }
        if (root.right != null) {
            ans = ans || hasPathSum(root.right, sub);
        }
        return ans;
    }
}
