package io.github.koschicken.easy;

import io.github.koschicken.common.TreeNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <a href="https://leetcode.cn/problems/path-sum/description/">112. 路径总和</a>
 */
public class PathSum {

    @Test
    void solution() {
        assertTrue(hasPathSum(new TreeNode(new Integer[]{5, 4, 8, 11, null, 13, 4, 7, 2, null, null, null, 1}), 22));
        assertFalse(hasPathSum(new TreeNode(new Integer[]{1, 2, 3}), 5));
    }

    /**
     * 递归处理单个节点，基准：目标值和节点值的差值为0。未达基准时处理节点的子节点，直到达到基准。
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        boolean ans = false;
        int sub = targetSum - root.val;
        // 必须到达叶子节点
        if (sub == 0 && root.left == null && root.right == null) {
            return true;
        }
        if (root.left != null) {
            ans = hasPathSum(root.left, sub);
        }
        if (root.right != null) {
            ans = ans || hasPathSum(root.right, sub);
        }
        return ans;
    }
}
