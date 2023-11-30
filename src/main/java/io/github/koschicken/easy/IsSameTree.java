package io.github.koschicken.easy;

import io.github.koschicken.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <a href="https://leetcode.cn/problems/same-tree/description/">100. 相同的树</a>
 */
public class IsSameTree {

    @Test
    void solution() {
        TreeNode tree1 = new TreeNode(new Integer[]{1, 2, 3});
        TreeNode tree2 = new TreeNode(new Integer[]{1, 2, 3});
        assertTrue(isSameTreeRecursive(tree1, tree2));
    }

    public boolean isSameTreeRecursive(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        if (p != null && q == null) return false;
        if (p == null) return false;
        if (p.val == q.val) {
            return isSameTreeRecursive(p.left, q.left) && isSameTreeRecursive(p.right, q.right);
        }
        return false;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
        // 第94题里用栈实现的各种遍历会忽略空节点，过不了[1, 1] [1 null, 1]这种测试用例，故用队列的方式遍历树，然后比较两个队列是否相同。
        // TODO 队列遍历
        return false;
    }
}
