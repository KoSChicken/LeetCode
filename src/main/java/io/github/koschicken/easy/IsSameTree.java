package io.github.koschicken.easy;

import io.github.koschicken.common.TreeNode;

/**
 * <a href="https://leetcode.cn/problems/same-tree/description/">100. 相同的树</a>
 */
public class IsSameTree {

    public static void main(String[] args) {
        TreeNode p1 = new TreeNode(1);
        TreeNode p2 = new TreeNode(2);
        TreeNode p3 = new TreeNode(3);
        p1.left = p2;
        p1.right = p3;
        TreeNode q1 = new TreeNode(1);
        TreeNode q2 = new TreeNode(2);
        TreeNode q3 = new TreeNode(3);
        q1.left = q2;
        q1.right = q3;
        System.out.println(isSameTreeRecursive(p1, q1));
    }

    private static boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q == null) return false;
        if (p == null) return false;
        if (p.val == q.val) {
            return isSameTreeRecursive(p.left, q.left) && isSameTreeRecursive(p.right, q.right);
        }
        return false;
    }

    private static boolean isSameTree(TreeNode p, TreeNode q) {
        // 第94题里用栈实现的各种遍历会忽略空节点，过不了[1, 1] [1 null, 1]这种测试用例，故用队列的方式遍历树，然后比较两个队列是否相同。
        // TODO 队列遍历
        return false;
    }
}
