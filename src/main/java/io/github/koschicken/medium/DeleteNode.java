package io.github.koschicken.medium;

import io.github.koschicken.common.TreeNode;
import io.github.koschicken.easy.BSTTraversal;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/delete-node-in-a-bst/description/">450. 删除二叉搜索树中的节点</a>
 * <br/>
 * 值得注意的只有要删除的节点左右节点都存在的情况，记要删除的节点为N。
 * <ol>
 *     <li>找出N的右子树中最小的节点，方法是一直找N的右子树的左节点，直到叶子。</li>
 *     <li>将找到的最小节点的值替换给N。</li>
 *     <li>删除找到的最小节点。</li>
 * </ol>
 */
public class DeleteNode {

    @Test
    void solution() {
        Integer[] treeArray = {5, 3, 6, 2, 4, null, 7};
        TreeNode testTree1 = new TreeNode(treeArray);
        assertEquals(new BSTTraversal().preOrderTraversalNoRecursive(deleteNode(testTree1, 3)), Arrays.asList(5, 4, 6, 2, 7));
    }

    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) return null;
        if (key < root.val) {
            root.left = deleteNode(root.left, key);
        } else if (key > root.val) {
            root.right = deleteNode(root.right, key);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            } else {
                root.val = findMin(root.right);
                root.right = deleteNode(root.right, root.val);
            }
        }
        return root;
    }

    private int findMin(TreeNode root) {
        while (root.left != null) {
            root = root.left;
        }
        return root.val;
    }
}
