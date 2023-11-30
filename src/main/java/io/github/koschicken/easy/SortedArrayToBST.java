package io.github.koschicken.easy;

import io.github.koschicken.common.TreeNode;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;

/**
 * <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/">108. 将有序数组转换为二叉搜索树</a>
 * <br/>
 * <a href="https://www.geeksforgeeks.org/convert-normal-bst-balanced-bst/">convert normal bst to balanced bst</a>
 * <br/>
 * <a href="https://www.geeksforgeeks.org/sorted-array-to-balanced-bst/">sorted array to balanced bst</a>
 */
public class SortedArrayToBST {

    @Test
    void solution() {
        int[] nums = {0, 1, 2, 3, 4, 5};
        TreeNode treeNode = sortedArrayToBST(nums);
        BSTTraversal bstTraversal = new BSTTraversal();
        // 中序遍历有序
        assertIterableEquals(bstTraversal.inOrderTraversalNoRecursive(treeNode), Arrays.asList(0, 1, 2, 3, 4, 5));
        // 后序遍历 1, 0, 3, 5, 4, 2
        assertIterableEquals(bstTraversal.postOrderTraversalNoRecursive(treeNode), Arrays.asList(1, 0, 3, 5, 4, 2));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    private TreeNode sortedArrayToBST(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode treeNode = new TreeNode(nums[mid]);
        treeNode.left = sortedArrayToBST(nums, start, mid - 1);
        treeNode.right = sortedArrayToBST(nums, mid + 1, end);
        return treeNode;
    }
}
