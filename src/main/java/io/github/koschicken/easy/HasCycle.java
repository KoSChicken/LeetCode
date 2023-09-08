package io.github.koschicken.easy;

import io.github.koschicken.common.ListNode;

public class HasCycle {

    public static void main(String[] args) {
//        ListNode n1 = new ListNode(3);
//        ListNode n2 = new ListNode(2);
//        ListNode n3 = new ListNode(0);
//        ListNode n4 = new ListNode(-4);
//        n1.next = n2;
//        n2.next = n3;
//        n3.next = n4;
//        n4.next = n2;
//        System.out.println(hasCycle(n1));
        ListNode n1 = new ListNode(1);
        ListNode n2 = new ListNode(2);
        n1.next = n2;
        n2.next = n1;
        System.out.println(hasCycle(n1));
    }

    public static boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        ListNode fast = head.next;
        if (fast == null) {
            return false;
        }
        ListNode slow = head;
        while (fast != null && fast.next != null && slow.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (fast == slow) {
                return true;
            }
        }
        return false;
    }
}
