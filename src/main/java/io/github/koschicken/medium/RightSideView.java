package io.github.koschicken.medium;

import io.github.koschicken.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.*;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <a href="https://leetcode.cn/problems/binary-tree-right-side-view/">199. 二叉树的右视图</a>
 */
public class RightSideView {

    @Test
    void solution() {
        assertIterableEquals(rightSideView(new TreeNode(new Integer[]{1, 2, 3, null, 5, null, 4})), List.of(1, 3, 4));
        assertIterableEquals(rightSideView(new TreeNode(new Integer[]{1, null, 3})), List.of(1, 3));
        assertTrue(rightSideView(null).isEmpty());
    }

    /**
     * 层序遍历，但每层只记录最后一个
     */
    public List<Integer> rightSideView(TreeNode root) {
        if (root == null) return Collections.emptyList();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int cur = 1;
        int next = 0;
        List<Integer> result = new ArrayList<>();
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.left != null) {
                queue.offer(poll.left);
                next++;
            }
            if (poll.right != null) {
                queue.offer(poll.right);
                next++;
            }
            cur--;
            if (cur == 0) {
                cur = next;
                next = 0;
                result.add(poll.val);
            }
        }
        return result;
    }
}
