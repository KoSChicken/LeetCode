package io.github.koschicken.easy;

import io.github.koschicken.common.ListNode;

public class RemoveElements {

    public static void main(String[] args) {
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(1);
        ListNode n4 = new ListNode(1);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        ListNode listNode = removeElements(n1, 1);
        printNode(listNode);
    }

    public static ListNode removeElementsRecur(ListNode head, int val) {
        if (head == null) {
            return null;
        }
        head.next = removeElementsRecur(head.next, val);
        return head.val == val ? head.next : head;
    }

    public static ListNode removeElements(ListNode head, int val) {
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

    private static void printNode(ListNode head) {
        StringBuilder sb = new StringBuilder();
        sb.append(head.val);
        while (head.next != null) {
            sb.append(" ").append(head.next.val);
            head = head.next;
        }
        System.out.println(sb);
    }
}
