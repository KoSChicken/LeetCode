package io.github.koschicken.easy;

import io.github.koschicken.common.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

/**
 * 遍历二叉树
 * 前序遍历：先输出根节点再遍历左子树，然后遍历右子树
 * 中序遍历：遍历完左子树后输出根节点，然后遍历右子树
 * 后序遍历：遍历完左子树后遍历右子树，然后输出根节点
 */
public class BSTTraversal {

    public static void main(String[] args) {
        TreeNode t1 = new TreeNode(1);
        TreeNode t2 = new TreeNode(2);
        TreeNode t3 = new TreeNode(3);
        TreeNode t4 = new TreeNode(4);
        TreeNode t5 = new TreeNode(5);
        TreeNode t6 = new TreeNode(6);
        TreeNode t7 = new TreeNode(7);
        TreeNode t8 = new TreeNode(8);
        t1.left = t2;
        t1.right = t3;
        t2.left = t4;
        t3.right = t5;
        t4.right = t6;
        t6.left = t7;
        t6.right = t8;
        // 前序
        printList(preOrderTraversalNoRecursive(t1));
        printList(preOrderTraversal(t1));
        // 中序
        printList(inOrderTraversalNoRecursive(t1));
        printList(inOrderTraversal(t1));
        // 后序
        printList(postOrderTraversalNoRecursive(t1));
        printList(postOrderTraversal(t1));
    }

    /**
     * 中序
     */
    public static List<Integer> inOrderTraversalNoRecursive(TreeNode root) {
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

    private static List<Integer> inOrderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrderTraversal(root, list);
        return list;
    }

    private static void inOrderTraversal(TreeNode treeNode, List<Integer> list) {
        if (treeNode != null) {
            inOrderTraversal(treeNode.left, list);
            list.add(treeNode.val);
            inOrderTraversal(treeNode.right, list);
        }
    }

    /**
     * 前序
     */
    public static List<Integer> preOrderTraversalNoRecursive(TreeNode root) {
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

    private static List<Integer> preOrderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        preOrderTraversal(root, list);
        return list;
    }

    private static void preOrderTraversal(TreeNode treeNode, List<Integer> list) {
        if (treeNode != null) {
            list.add(treeNode.val);
            preOrderTraversal(treeNode.left, list);
            preOrderTraversal(treeNode.right, list);
        }
    }

    /**
     * 后序
     */
    public static List<Integer> postOrderTraversalNoRecursive(TreeNode root) {
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

    private static List<Integer> postOrderTraversal(TreeNode root) {
        ArrayList<Integer> list = new ArrayList<>();
        postOrderTraversal(root, list);
        return list;
    }

    private static void postOrderTraversal(TreeNode treeNode, List<Integer> list) {
        if (treeNode != null) {
            postOrderTraversal(treeNode.left, list);
            postOrderTraversal(treeNode.right, list);
            list.add(treeNode.val);
        }
    }

    private static void printList(List<Integer> list) {
        System.out.println(Arrays.toString(list.toArray(new Integer[0])));
    }
}
