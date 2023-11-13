package io.github.koschicken.easy;

import io.github.koschicken.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list/description/">206. 反转链表</a>
 */
public class ReverseList {

    @Test
    void solution() {
        ListNode reversed = reverseListRecur(new ListNode(new int[]{1, 2, 3, 4, 5}));
        assertEquals(reversed.toString(), "5,4,3,2,1");
        assertEquals(reverseList(reversed).toString(), "1,2,3,4,5");
    }

    public ListNode reverseListRecur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = reverseListRecur(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
}
