package com.max.algorithm.jianzhioffer24;

public class Solution2 {
    public ListNode reverseList(ListNode head) {
        if (null == head || head.next == null) {
            return head;
        }

        ListNode reversedListNode = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return reversedListNode;
    }
}
