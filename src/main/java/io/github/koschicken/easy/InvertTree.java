package io.github.koschicken.easy;

import io.github.koschicken.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * <a href="https://leetcode.cn/problems/invert-binary-tree/description/">226. 翻转二叉树</a>
 */
public class InvertTree {

    @Test
    void solution() {
        TreeNode treeNode = new TreeNode(new Integer[]{1, 2, 3});
        assertIterableEquals(new BSTTraversal().preOrderTraversalNoRecursive(invertTree(treeNode)), Arrays.asList(1, 3, 2));
    }

    public TreeNode invertTree(TreeNode root) {
        if (root != null) {
            TreeNode left = root.left;
            root.left = root.right;
            root.right = left;
            invertTree(root.left);
            invertTree(root.right);
        }
        return root;
    }
}
