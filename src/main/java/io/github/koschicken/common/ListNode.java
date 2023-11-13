package io.github.koschicken.common;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    public ListNode(int[] array) {
        if (array == null || array.length == 0) {
            throw new IllegalArgumentException("array cannot be null or empty");
        }
        this.val = array[0];
        ListNode current = this;
        for (int i = 1; i < array.length; i++) {
            current.next = new ListNode(array[i]);
            current = current.next;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(val);
        ListNode nextNode = this.next;
        while (nextNode != null) {
            sb.append(",").append(nextNode.val);
            nextNode = nextNode.next;
        }
        return sb.toString();
    }
}
