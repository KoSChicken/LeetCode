package io.github.koschicken.easy;

import io.github.koschicken.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <a href="https://leetcode.cn/problems/leaf-similar-trees/description/">872. 叶子相似的树</a>
 */
public class LeafSimilar {

    @Test
    void solution() {
        assertTrue(leafSimilar(new TreeNode(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4}),
                new TreeNode(new Integer[]{3, 5, 1, 6, 7, 4, 2, null, null, null, null, null, null, 9, 8})));
    }

    public boolean leafSimilar(TreeNode root1, TreeNode root2) {
        List<Integer> leaves1 = leaves(root1);
        List<Integer> leaves2 = leaves(root2);
        return leaves1.equals(leaves2);
    }

    private List<Integer> leaves(TreeNode treeNode) {
        List<Integer> leaves = new ArrayList<>();
        traverse(treeNode, leaves);
        return leaves;
    }

    private void traverse(TreeNode treeNode, List<Integer> leaves) {
        if (treeNode != null) {
            traverse(treeNode.left, leaves);
            if (treeNode.left == null && treeNode.right == null) {
                leaves.add(treeNode.val);
            }
            traverse(treeNode.right, leaves);
        }
    }

    @Test
    void testLeafs() {
        assertIterableEquals(leaves(new TreeNode(new Integer[]{3, 5, 1, 6, 2, 9, 8, null, null, 7, 4})),
                Arrays.asList(6, 7, 4, 9, 8));
    }
}
