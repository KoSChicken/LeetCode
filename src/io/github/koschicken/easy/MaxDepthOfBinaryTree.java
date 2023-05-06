package io.github.koschicken.easy;

import io.github.koschicken.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;

public class MaxDepthOfBinaryTree {

    public static void main(String[] args) {
        TreeNode tree = buildTree();
        System.out.println(maxDepth(tree));
        System.out.println(maxDepthRecur(tree));
    }

    public static int maxDepthRecur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepthRecur(root.left);
        int rightDepth = maxDepthRecur(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                TreeNode poll = queue.poll();
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
                size--;
            }
            depth++;
        }
        return depth;
    }

    private static TreeNode buildTree() {
        TreeNode root = new TreeNode(3);
        TreeNode node1 = new TreeNode(9);
        TreeNode node2 = new TreeNode(20);
        TreeNode node3 = new TreeNode(15);
        TreeNode node4 = new TreeNode(7);
        TreeNode node5 = new TreeNode(14);
        TreeNode node6 = new TreeNode(6);
        root.left = node1;
        root.right = node2;
        node1.left = node5;
        node1.right = node6;
        node2.left = node3;
        node2.right = node4;
        return root;
    }
}
