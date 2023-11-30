package io.github.koschicken.easy;

import io.github.koschicken.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/maximum-depth-of-binary-tree">104. 二叉树的最大深度</a>
 */
public class MaxDepthOfBinaryTree {


    @Test
    void solution() {
        TreeNode tree = new TreeNode(new Integer[]{3, 9, 20, null, null, 15, 7});
        assertEquals(maxDepth(tree), 3);
        assertEquals(maxDepthRecur(tree), 3);
    }

    public int maxDepthRecur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = maxDepthRecur(root.left);
        int rightDepth = maxDepthRecur(root.right);
        return Math.max(leftDepth, rightDepth) + 1;
    }

    public int maxDepth(TreeNode root) {
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

}
