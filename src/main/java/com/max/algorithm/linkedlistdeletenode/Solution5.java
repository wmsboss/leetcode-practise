package com.max.algorithm.linkedlistdeletenode;

class Solution5 {
    public ListNode deleteNode(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        head.next = deleteNode(head.next, val);

        return head.val == val ? head.next : head;
    }

    public static void main(String[] args) {

        int[] nums = {1, 2, 6, 3, 4, 5, 6};
        ListNode head = new ListNode(nums);
        System.out.println(head);

        ListNode res = (new Solution5()).deleteNode(head, 6);
        System.out.println(res);
    }
}