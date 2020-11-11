package com.max.algorithm.interview0202;

public class Solution2 {
    public int kthToLast(ListNode head, int k) {
        if (head.next == null) {
            return head.val;
        }

        ListNode temp = head;

        for (int i = 0; i < k; i++) {
            head = head.next;
        }

        if (head == null) {
            return temp.val;
        }

        while(head.next != null) {
            head = head.next;
            temp = temp.next;
        }

        return temp.next.val;
    }

    public static void main(String[] args) {
        //输入： 1->2->3->4->5 和 k = 2
        //输出： 4
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        head.next =  node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;


        System.out.println(new Solution2().kthToLast(head, 2));
    }
}
