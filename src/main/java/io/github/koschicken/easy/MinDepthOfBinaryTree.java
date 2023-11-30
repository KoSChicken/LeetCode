package io.github.koschicken.easy;

import io.github.koschicken.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/minimum-depth-of-binary-tree">111. 二叉树的最小深度</a>
 */
public class MinDepthOfBinaryTree {

    @Test
    void solution() {
        assertEquals(minDepthRecur(new TreeNode(new Integer[]{3, 9, 20, null, null, 15, 7})), 2);
        assertEquals(minDepthRecur(new TreeNode(new Integer[]{2, null, 3, null, 4, null, 5, null, 6})), 5);
    }

    public int minDepthRecur(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int leftDepth = minDepthRecur(root.left);
        int rightDepth = minDepthRecur(root.right);
        // 和最大深度解法一样，区别在于最小深度取较小的高度，并且需要处理退化的树（某一边完全没有节点）
        if (leftDepth == 0) {
            return rightDepth + 1;
        }
        if (rightDepth == 0) {
            return leftDepth + 1;
        }
        return Math.min(leftDepth, rightDepth) + 1;
    }
}
