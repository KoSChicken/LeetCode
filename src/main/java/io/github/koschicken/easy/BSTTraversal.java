package io.github.koschicken.easy;

import io.github.koschicken.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * 遍历二叉树
 * <br/>
 * 前序遍历：先输出根节点再遍历左子树，然后遍历右子树
 * <br/>
 * 中序遍历：遍历完左子树后输出根节点，然后遍历右子树
 * <br/>
 * 后序遍历：遍历完左子树后遍历右子树，然后输出根节点
 * <br/>
 * <a href="https://leetcode.cn/problems/binary-tree-preorder-traversal/description/">144. 二叉树的中序遍历</a>
 * <br/>
 * <a href="https://leetcode.cn/problems/binary-tree-inorder-traversal/description/">94. 二叉树的中序遍历</a>
 * <br/>
 * <a href="https://leetcode.cn/problems/binary-tree-postorder-traversal/description/">145. 二叉树的中序遍历</a>
 */
public class BSTTraversal {

    @Test
    void solution() {
        TreeNode treeNode = new TreeNode(new Integer[]{1, 2, 3, 4, null, null, 5, null, 6, null, null, 7, 8});
        // 前序
        assertIterableEquals(preOrderTraversalNoRecursive(treeNode), Arrays.asList(1, 2, 4, 6, 7, 8, 3, 5));
        assertIterableEquals(preOrderTraversal(treeNode), Arrays.asList(1, 2, 4, 6, 7, 8, 3, 5));
        // 中序
        assertIterableEquals(inOrderTraversalNoRecursive(treeNode), Arrays.asList(4, 7, 6, 8, 2, 1, 3, 5));
        assertIterableEquals(inOrderTraversal(treeNode), Arrays.asList(4, 7, 6, 8, 2, 1, 3, 5));
        // 后序
        assertIterableEquals(postOrderTraversalNoRecursive(treeNode), Arrays.asList(7, 8, 6, 4, 2, 5, 3, 1));
        assertIterableEquals(postOrderTraversal(treeNode), Arrays.asList(7, 8, 6, 4, 2, 5, 3, 1));
    }

    /**
     * 中序
     */
    public List<Integer> inOrderTraversalNoRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            if (!deque.isEmpty()) {
                root = deque.pop();
                list.add(root.val);
                root = root.right;
            }
        }
        return list;
    }

    private List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        return list;
    }

    private void inOrderTraversal(TreeNode treeNode, List<Integer> list) {
        if (treeNode != null) {
            inOrderTraversal(treeNode.left, list);
            list.add(treeNode.val);
            inOrderTraversal(treeNode.right, list);
        }
    }

    /**
     * 前序
     */
    public List<Integer> preOrderTraversalNoRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                list.add(root.val);
                deque.push(root);
                root = root.left;
            }
            if (!deque.isEmpty()) {
                root = deque.pop();
                root = root.right;
            }
        }
        return list;
    }

    private List<Integer> preOrderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preOrderTraversal(root, list);
        return list;
    }

    private void preOrderTraversal(TreeNode treeNode, List<Integer> list) {
        if (treeNode != null) {
            list.add(treeNode.val);
            preOrderTraversal(treeNode.left, list);
            preOrderTraversal(treeNode.right, list);
        }
    }

    /**
     * 后序
     */
    public List<Integer> postOrderTraversalNoRecursive(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        Deque<TreeNode> deque = new ArrayDeque<>();
        TreeNode lastVisit = root;
        while (root != null || !deque.isEmpty()) {
            while (root != null) {
                deque.push(root);
                root = root.left;
            }
            root = deque.peek();
            if (root.right == null || root.right == lastVisit) {
                list.add(root.val);
                deque.pop();
                lastVisit = root;
                root = null;
            } else {
                root = root.right;
            }
        }
        return list;
    }

    private List<Integer> postOrderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postOrderTraversal(root, list);
        return list;
    }

    private void postOrderTraversal(TreeNode treeNode, List<Integer> list) {
        if (treeNode != null) {
            postOrderTraversal(treeNode.left, list);
            postOrderTraversal(treeNode.right, list);
            list.add(treeNode.val);
        }
    }
}
