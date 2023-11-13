package io.github.koschicken.medium;

import io.github.koschicken.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/delete-the-middle-node-of-a-linked-list/description/">2095. 删除链表的中间节点</a>
 */
public class DeleteMiddle {

    @Test
    void solution() {
        assertEquals(deleteMiddle(new ListNode(new int[]{1, 3, 4, 7, 1, 2, 6})).toString(), "1,3,4,1,2,6");
        assertEquals(deleteMiddle(new ListNode(new int[]{1, 2, 3, 4})).toString(), "1,2,4");
    }

    /**
     * <ol>
     * <li>创建三个指针，设置prev的后继节点为当前链表的头，slow和fast都指向头</li>
     * <li>按顺序将prev和slow每次移动1格，fast每次移动2格</li>
     * <li>当fast指向null时，slow就是链表的中间节点，把prev的next指向slow的next即可</li>
     * </ol>
     */
    public ListNode deleteMiddle(ListNode head) {
        ListNode slow = head;
        if (slow.next == null) {
            return null;
        }
        ListNode fast = head;
        ListNode prev = new ListNode(-1);
        prev.next = head;
        while (fast.next != null) {
            prev = prev.next;
            slow = slow.next;
            if (fast.next.next != null) {
                fast = fast.next.next;
            } else {
                break;
            }
        }
        prev.next = slow.next;
        return head;
    }
}
