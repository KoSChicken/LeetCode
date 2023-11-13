package io.github.koschicken.easy;

import io.github.koschicken.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/">83. 删除排序链表中的重复元素</a>
 */
public class DeleteDuplicates {

    @Test
    void solution() {
        assertEquals(deleteDuplicates(new ListNode(new int[]{1, 1, 2, 3, 3, 4})).toString(), "1,2,3,4");
    }

    private ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pointer = head;
        while (pointer.next != null) {
            if (pointer.val == pointer.next.val) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
        }
        return head;
    }
}
