package com.max.algorithm.lc24reverselist;

public class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode pref = null;
        ListNode cur = head;

        while(cur != null) {
            ListNode next = cur.next;
            cur.next = pref;
            pref = cur;
            cur = next;
        }

        return pref;
    }
}
