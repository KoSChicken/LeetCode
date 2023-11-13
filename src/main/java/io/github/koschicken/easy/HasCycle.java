package io.github.koschicken.easy;

import io.github.koschicken.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <a href="https://leetcode.cn/problems/linked-list-cycle/description/">141. 环形链表</a>
 */
public class HasCycle {

    @Test
    void solution() {
        ListNode n1 = new ListNode(3);
        ListNode n2 = new ListNode(2);
        ListNode n3 = new ListNode(0);
        ListNode n4 = new ListNode(-4);
        n1.next = n2;
        n2.next = n3;
        n3.next = n4;
        n4.next = n2;
        assertTrue(hasCycle(n1));
        ListNode nn1 = new ListNode(1);
        ListNode nn2 = new ListNode(2);
        nn1.next = nn2;
        nn2.next = nn1;
        assertTrue(hasCycle(nn1));
    }

    public boolean hasCycle(ListNode head) {
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
