package io.github.koschicken.common;

import java.util.LinkedList;
import java.util.Queue;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode() {
    }

    public TreeNode(int val) {
        this.val = val;
    }

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(Integer[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        this.val = array[0];
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(this);
        for (int i = 1; i < array.length; i++) {
            TreeNode node = queue.poll();
            if (array[i] != null) {
                node.left = new TreeNode(array[i]);
                queue.offer(node.left);
            }
            if (++i < array.length && array[i] != null) {
                node.right = new TreeNode(array[i]);
                queue.offer(node.right);
            }
        }
    }
}