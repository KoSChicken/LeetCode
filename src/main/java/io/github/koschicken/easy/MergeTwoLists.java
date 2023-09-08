package io.github.koschicken.easy;

import io.github.koschicken.common.ListNode;

public class MergeTwoLists {

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(4);
        l1.next = l2;
        l2.next = l3;
        ListNode l4 = new ListNode(1);
        ListNode l5 = new ListNode(3);
        ListNode l6 = new ListNode(4);
        l4.next = l5;
        l5.next = l6;

        ListNode listNode = mergeTwoLists(l1, l4);
        printListNode(listNode);
    }

    private static void printListNode(ListNode listNode) {
        while (listNode != null) {
            System.out.print(listNode.val + ", ");
            listNode = listNode.next;
        }
        System.out.println();
    }

    /**
     * 合并链表
     *
     * @param listNode1 链表1
     * @param listNode2 链表2
     * @return 合并后的链表
     */
    public static ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {
        // 最简单的情况：两个链表中有一个是null，则合并之后的链表就是另外一个链表；
        if (listNode1 == null) {
            return listNode2;
        }
        if (listNode2 == null) {
            return listNode1;
        }
        /*
            如果两个链表都不是null，则用头元素更小的那个作为合并后链表的头
            最简单的情况是两个链表都只有1个元素，分别是1和2，此时以1为头，递归调用方法时参数为null, 2
            由上面的判断可知此时返回结果为2，所以得出的新链表为1->2
            两个链表分别为1->4, 2->3时，先以1为头 //1->2->3->4
            第一次递归的参数是4, 2->3 //2->3->4
            第二次递归的参数是4, 3 //3->4
            第三次递归的参数是4, null，结果是4，并由此得出之前递归的结果
            1->(4, 2->3)->(4, 3)->(4, null)
         */
        ListNode head;
        if (listNode1.val < listNode2.val) {
            head = listNode1;
            head.next = mergeTwoLists(head.next, listNode2);
        } else {
            head = listNode2;
            head.next = mergeTwoLists(listNode1, head.next);
        }
        return head;
    }
}
