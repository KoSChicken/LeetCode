package io.github.koschicken.medium;

import io.github.koschicken.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/odd-even-linked-list/description/">328. 奇偶链表</a>
 */
public class OddEvenList {

    @Test
    void solution() {
        assertEquals(oddEvenList(new ListNode(new int[]{1, 2, 3, 4, 5})).toString(), "1,3,5,2,4");
        assertEquals(oddEvenList(new ListNode(new int[]{1, 2, 3, 4})).toString(), "1,3,2,4");
        assertEquals(oddEvenList(new ListNode(new int[]{1, 2, 3, 4, 5, 6})).toString(), "1,3,5,2,4,6");
    }

    public ListNode oddEvenList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) {
            return head;
        }
        ListNode oddCursor = head;
        ListNode evenHead = head.next;
        ListNode evenCursor = evenHead;
        while (oddCursor.next != null && evenCursor.next != null) {
            oddCursor.next = oddCursor.next.next;
            oddCursor = oddCursor.next;
            evenCursor.next = evenCursor.next.next;
            evenCursor = evenCursor.next;
        }
        oddCursor.next = evenHead;
        return head;
    }
}
