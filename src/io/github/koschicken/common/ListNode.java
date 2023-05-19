package io.github.koschicken.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public static void printNode(ListNode head) {
        StringBuilder sb = new StringBuilder();
        if (head == null) {
            return;
        }
        sb.append(head.val);
        while (head.next != null) {
            sb.append(" ").append(head.next.val);
            head = head.next;
        }
        System.out.println(sb);
    }
}
