package io.github.koschicken.easy;

import io.github.koschicken.common.ListNode;
import org.junit.jupiter.api.Test;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * <a href="https://leetcode.cn/problems/palindrome-linked-list/description/">234. 回文链表</a>
 */
public class PalindromeLinkedList {

    @Test
    void test() {
        ListNode head = new ListNode(1);
        ListNode node1 = new ListNode(1);
        head.next = node1;
        ListNode node2 = new ListNode(2);
        node1.next = node2;
        ListNode node3 = new ListNode(1);
        node2.next = node3;
        node3.next = new ListNode(1);
        assertTrue(isPalindrome(head));
    }

    private boolean isPalindrome(ListNode head) {
        assert head != null;
        ListNode next = head.next;
        if (next == null) {
            return true;
        }
        Deque<Integer> deque = new ArrayDeque<>();
        while (next != null) {
            deque.add(next.val);
            next = next.next;
        }
        while (!deque.isEmpty()) {
            if (head.val != deque.pollLast()) {
                return false;
            }
            head = head.next;
        }
        return true;
    }
}
