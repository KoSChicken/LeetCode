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
        TreeNode treeNode = new TreeNode(new Integer[]{1, 2, 3, 4, null, null, 5, null, 6, null, null, 7, 8});
        List<String> treePaths = binaryTreePaths(treeNode);
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
