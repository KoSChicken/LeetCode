package io.github.koschicken.medium;

import io.github.koschicken.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/count-good-nodes-in-binary-tree/description/">1448. 统计二叉树中好节点的数目</a>
 */
public class GoodNodes {

    @Test
    void solution() {
        assertEquals(goodNodes(new TreeNode(new Integer[]{3, 1, 4, 3, null, 1, 5})), 4);
        assertEquals(goodNodes(new TreeNode(new Integer[]{3, 3, null, 4, 2})), 3);
        assertEquals(goodNodes(new TreeNode(new Integer[]{1})), 1);
        assertEquals(goodNodes(new TreeNode(new Integer[]{9, null, 3, 6})), 1);
        assertEquals(goodNodes(new TreeNode(new Integer[]{2, null, 4, 10, 8, null, null, 4})), 4);
    }

    public int goodNodes(TreeNode root) {
        int max = root.val;
        return 1 + goodNodes(root.left, max) + goodNodes(root.right, max);
    }

    /**
     * dfs，设置根节点的值为最大值，遍历中如果当前节点的值更大，则更新该值，同时计数+1
     */
    private int goodNodes(TreeNode node, int max) {
        if (node == null) {
            return 0;
        }
        if (node.val >= max) {
            max = node.val;
            return 1 + goodNodes(node.left, max) + goodNodes(node.right, max);
        } else {
            return goodNodes(node.left, max) + goodNodes(node.right, max);
        }
    }

}
