package com.max.algorithm.addtwonumberspractise;

class Solution {
    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode param1 = new ListNode();
        param1.val = 2;

        ListNode param1_1 = new ListNode();
        param1_1.val = 4;
        param1.next = param1_1;

        ListNode param1_2 = new ListNode();
        param1_2.val = 3;
        param1_1.next = param1_2;

        ListNode param2 = new ListNode();
        param2.val = 5;

        ListNode param2_1 = new ListNode();
        param2_1.val = 6;
        param2.next = param2_1;

        ListNode param2_2 = new ListNode();
        param2_2.val = 4;
        param2_1.next = param2_2;

        ListNode result = solution.addTwoNumbers(param1, param2);

        System.out.println(result.val);
        System.out.println(result.next.val);
        System.out.println(result.next.next.val);
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode result = null;
        ListNode previousNode = null;
        boolean isCarryOver = false;

        do {
            ListNode currentNode = new ListNode();

            int sumValue = 0;

            if (null != l1) {
                sumValue += l1.val;
            }

            if (null != l2) {
                sumValue += l2.val;
            }

            if (isCarryOver) {
                sumValue += 1;
            }

            if (sumValue >= 10) {
                currentNode.val = sumValue % 10;
                isCarryOver = true;
            } else {
                currentNode.val = sumValue;
                isCarryOver = false;
            }

            if (null == result) {
                result = currentNode;
                previousNode = currentNode;
            } else {
                previousNode.next = currentNode;
                previousNode = currentNode;
            }

            if (null != l1) {
                l1 = l1.next;
            }

            if (null != l2) {
                l2 = l2.next;
            }
        } while(null != l1 || null != l2);

        // last carry over value, need to add logic
        if (isCarryOver) {
            ListNode currentNode = new ListNode();
            currentNode.val = 1;

            previousNode.next = currentNode;
        }

        return result;
    }

     public static class ListNode {
      int val;

      ListNode next;

      ListNode() {}

      ListNode(int val) { this.val = val; }

      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
}
