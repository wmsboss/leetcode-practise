package com.max.algorithm.jianzhioffer22;

public class Solution {
    public ListNode getKthFromEnd(ListNode head, int k) {
        if (head ==null || head.next == null) {
            return head;
        }

        ListNode temp = head;

        for (int i = 0; i < k; i++) {
            head = head.next;
        }

        if (head == null) {
            return temp;
        }

        while(head.next != null) {
            head = head.next;
            temp = temp.next;
        }

        return temp.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        ListNode result = new Solution().getKthFromEnd(head, 2);
        System.out.println(result);
        System.out.println("End");
    }
}
