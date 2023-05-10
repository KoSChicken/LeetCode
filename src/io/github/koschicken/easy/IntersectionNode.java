package io.github.koschicken.easy;

import io.github.koschicken.common.ListNode;

public class IntersectionNode {

    public static void main(String[] args) {
        ListNode headA = new ListNode(4);
        ListNode node1 = new ListNode(1);

        ListNode node2 = new ListNode(8);
        ListNode node3 = new ListNode(4);
        ListNode node4 = new ListNode(5);

        ListNode headB = new ListNode(5);
        ListNode node5 = new ListNode(6);
        ListNode node6 = new ListNode(1);

        headA.next = node1;
        node1.next = node2;

        headB.next = node5;
        node5.next = node6;
        node6.next = node2;

        node2.next = node3;
        node3.next = node4;

        System.out.println(getIntersectionNode(headA, headB));
    }

    private static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode itA = headA;
        ListNode itB = headB;
        while (itA != itB) {
            itA = itA == null ? headB : itA.next;
            itB = itB == null ? headA : itB.next;
        }
        return itA;
    }
}
