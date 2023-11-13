package io.github.koschicken.medium;

import io.github.koschicken.common.ListNode;
import io.github.koschicken.easy.ReverseList;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/maximum-twin-sum-of-a-linked-list/">2130. 链表最大孪生和</a>
 */
public class PairSum {

    @Test
    void solution() {
        assertEquals(pairSum(new ListNode(new int[]{5, 4, 2, 1})), 6);
        assertEquals(pairSum(new ListNode(new int[]{4, 2, 2, 3})), 7);
        assertEquals(pairSum(new ListNode(new int[]{1, 100000})), 100001);
    }

    public int pairSum(ListNode head) {
        ListNode[] split = split(head);
        ListNode node = split[0];
        ListNode reversed = reverse(split[1]);
        int max = 0;
        while (reversed != null) {
            max = Math.max(max, reversed.val + node.val);
            reversed = reversed.next;
            node = node.next;
        }
        return max;
    }

    private ListNode[] split(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast != null && fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode middle = head;
        if (prev != null) {
            middle = prev.next;
            prev.next = null;
        }
        return new ListNode[]{head, middle};
    }

    private ListNode reverse(ListNode head) {
        ReverseList reverseList = new ReverseList();
        return reverseList.reverseList(head);
    }
}
