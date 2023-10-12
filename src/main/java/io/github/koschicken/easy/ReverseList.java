package io.github.koschicken.easy;

import io.github.koschicken.common.ListNode;

/**
 * <a href="https://leetcode.cn/problems/reverse-linked-list/description/">206. 反转链表</a>
 */
public class ReverseList {

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode n1 = new ListNode(2);
        ListNode n2 = new ListNode(3);
        ListNode n3 = new ListNode(4);
        ListNode n4 = new ListNode(5);
        head.next = n1;
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode listNode = reverseListRecur(head);
        ListNode.printNode(listNode);
        System.out.println("-");
        ListNode listNode2 = reverseList(listNode);
        ListNode.printNode(listNode2);
    }

    private static ListNode reverseListRecur(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode listNode = reverseListRecur(head.next);
        head.next.next = head;
        head.next = null;
        return listNode;
    }

    private static ListNode reverseList(ListNode head) {
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
