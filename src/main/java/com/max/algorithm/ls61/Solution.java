package com.max.algorithm.ls61;

public class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode temp = head;
        ListNode cur = head;

        for (int i = 0; i < k; i++) {
            cur = cur.next;

            if (cur == null) {
                cur = head;
            }
        }

        while(cur.next != null) {
            cur = cur.next;
            temp = temp.next;
        }

        cur.next = head;
        ListNode newHead = temp.next;
        temp.next = null;

        return newHead;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        ListNode listNode3 = new ListNode(3);
//        ListNode listNode4 = new ListNode(4);
//        ListNode listNode5 = new ListNode(5);
        listNode1.next = listNode2;
        listNode2.next = listNode3;
//        listNode3.next = listNode4;
//        listNode4.next = listNode5;

        ListNode resultNode = new Solution().rotateRight(listNode1, 4);

        System.out.println(resultNode);
    }
}
