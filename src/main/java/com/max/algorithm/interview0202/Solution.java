package com.max.algorithm.interview0202;

public class Solution {
    public int kthToLast(ListNode head, int k) {
        ListNode cur = head;
        ListNode curNode = null;

        do {
            ListNode newNode = new ListNode(cur.val);
            newNode.next = curNode;
            curNode = newNode;

            if (cur.next == null) {
                break;
            }

            cur = cur.next;
        } while (true);

        ListNode resNode = curNode;
        for (int i = 1; i < k; i++) {
            resNode = resNode.next;
        }

        return resNode.val;
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


        System.out.println(new Solution().kthToLast(head, 2));
    }
}
