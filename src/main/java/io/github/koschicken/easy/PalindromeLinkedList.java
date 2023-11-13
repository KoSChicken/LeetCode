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
        assertTrue(isPalindrome(new ListNode(new int[]{1, 1, 2, 1, 1})));
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
