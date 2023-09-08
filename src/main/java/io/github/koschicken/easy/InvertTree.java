package io.github.koschicken.easy;

import io.github.koschicken.common.TreeNode;

public class InvertTree {

    public static TreeNode invertTree(TreeNode root) {
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
