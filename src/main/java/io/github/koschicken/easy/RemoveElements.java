package io.github.koschicken.easy;

import io.github.koschicken.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/remove-linked-list-elements/description/">203. 移除链表元素</a>
 */
public class RemoveElements {

    @Test
    void solution() {
        assertEquals(removeElementsRecur(new ListNode(new int[]{1, 2, 1, 1}), 1).toString(), "2");
        assertEquals(removeElements(new ListNode(new int[]{1, 2, 1, 1}), 1).toString(), "2");
    }

    public ListNode removeElementsRecur(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElementsRecur(head.next, val);
        return head.val == val ? head.next : head;
    }

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        ListNode dummy = new ListNode();
        dummy.next = head;
        ListNode it = dummy;
        while (it.next != null) {
            if (it.next.val == val) {
                it.next = it.next.next;
            } else {
                it = it.next;
            }
        }
        return dummy.next;
    }
}
