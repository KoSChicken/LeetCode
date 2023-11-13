package io.github.koschicken.easy;

import io.github.koschicken.common.ListNode;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * <a href="https://leetcode.cn/problems/merge-two-sorted-lists/description/">21. 合并两个有序链表</a>
 */
public class MergeTwoLists {

    @Test
    void solution() {
        ListNode listNode1 = new ListNode(new int[]{1, 2, 4});
        ListNode listNode2 = new ListNode(new int[]{1, 3, 4});
        assertEquals(mergeTwoLists(listNode1, listNode2).toString(), "1,1,2,3,4,4");
    }

    public ListNode mergeTwoLists(ListNode listNode1, ListNode listNode2) {
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
