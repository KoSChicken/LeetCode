package io.github.koschicken.easy;

import io.github.koschicken.common.ListNode;

/**
 * <a href="https://leetcode.cn/problems/remove-duplicates-from-sorted-list/description/">83. 删除排序链表中的重复元素</a>
 */
public class DeleteDuplicates {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(1);
        ListNode l3 = new ListNode(2);
        ListNode l4 = new ListNode(3);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        l5.next = l6;

        ListNode listNode = deleteDuplicates(l1);
        printListNode(listNode);
    }

    private static ListNode deleteDuplicates(ListNode head) {
        if (head == null) {
            return null;
        }
        ListNode pointer = head;
        while (pointer.next != null) {
            if (pointer.val == pointer.next.val) {
                pointer.next = pointer.next.next;
            } else {
                pointer = pointer.next;
            }
        }
        return head;
    }

    private static void printListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }
        System.out.println();
    }
}
