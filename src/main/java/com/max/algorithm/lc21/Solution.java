package com.max.algorithm.lc21;

public class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l2 == null) {
            return l1;
        }

        if (l1 == null) {
            return l2;
        }

        ListNode prevL1 = null;
        ListNode curL1 = l1;
        ListNode curL2 = l2;

        while (curL2 != null) {
            while (curL1 != null && curL2.val >= curL1.val) {
                prevL1 = curL1;
                curL1 = curL1.next;
            }

            if (curL1 == null) {
                prevL1.next = curL2;
                break;
            }

            if (prevL1 != null) {
                ListNode l2Next = curL2.next;
                prevL1.next = curL2;
                curL2.next = curL1;
                prevL1 = curL2;
                curL2 = l2Next;
            } else {
                ListNode l2Next = curL2.next;
                prevL1 = curL2;
                l1 = curL2;
                curL2.next = curL1;
                curL2 = l2Next;
            }
        }

        return l1;
    }

    public static void main(String[] args) {
        ListNode l1_1 = new ListNode(5);

        ListNode l2_1 = new ListNode(1);
        ListNode l2_2 = new ListNode(2);
        ListNode l2_3 = new ListNode(4);
        l2_1.next = l2_2;
        l2_2.next = l2_3;

        System.out.println(new Solution().mergeTwoLists(l1_1, l2_1));
    }
}
