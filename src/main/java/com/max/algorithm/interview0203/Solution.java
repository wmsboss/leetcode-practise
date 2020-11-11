package com.max.algorithm.interview0203;

public class Solution {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        ListNode tempNode = node.next;
        node.next = tempNode.next;

        tempNode.next = null;
    }
}
