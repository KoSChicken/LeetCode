package io.github.koschicken.easy;

import io.github.koschicken.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-paths/description/">257. 二叉树的所有路径</a>
 */
public class TreePaths {

    @Test
    void test() {
        TreeNode root = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        root.left = t2;
        root.right = t3;
        t2.left = t4;
        t3.right = t5;
        t4.right = t6;
        t6.left = t7;
        t6.right = t8;
        List<String> treePaths = binaryTreePaths(root);
        treePaths.forEach(System.out::println);
        assert treePaths.get(0).equals("1->2->4->6->7")
                && treePaths.get(1).equals("1->2->4->6->8")
                && treePaths.get(2).equals("1->3->5");
    }

    public List<String> binaryTreePaths(TreeNode root) {
        List<String> paths = new ArrayList<>();
        constructPaths(root, "", paths);
        return paths;
    }

    private void constructPaths(TreeNode root, String path, List<String> paths) {
        if (root != null) {
            StringBuilder stringBuilder = new StringBuilder(path);
            stringBuilder.append(root.val);
            if (isLeft(root)) {
                paths.add(stringBuilder.toString());
            } else {
                stringBuilder.append("->");
                constructPaths(root.left, stringBuilder.toString(), paths);
                constructPaths(root.right, stringBuilder.toString(), paths);
            }
        }
    }

    private boolean isLeft(TreeNode root) {
        return root.left == null && root.right == null;
    }
}
