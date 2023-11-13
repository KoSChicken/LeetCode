package io.github.koschicken.easy;

import io.github.koschicken.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/intersection-of-two-linked-lists/description/">160. 相交链表</a>
 */
public class IntersectionNode {

    @Test
    void solution() {
        ListNode headA = new ListNode(4);
        ListNode a1 = new ListNode(1);

        ListNode headB = new ListNode(5);
        ListNode b1 = new ListNode(6);
        ListNode b2 = new ListNode(1);

        ListNode ab1 = new ListNode(8);
        ListNode ab2 = new ListNode(4);
        ListNode ab3 = new ListNode(5);

        headA.next = a1;
        a1.next = ab1;

        headB.next = b1;
        b1.next = b2;
        b2.next = ab1;

        ab1.next = ab2;
        ab2.next = ab3;

        assertEquals(getIntersectionNode(headA, headB).toString(), "8,4,5");
    }

    private ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode itA = headA;
        ListNode itB = headB;
        while (itA != itB) {
            itA = itA == null ? headB : itA.next;
            itB = itB == null ? headA : itB.next;
        }
        return itA;
    }
}
