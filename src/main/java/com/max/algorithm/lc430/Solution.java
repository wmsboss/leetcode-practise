package com.max.algorithm.lc430;

public class Solution {
    public Node flatten(Node head) {
        doFlatten(head);

        return head;
    }

    private Node doFlatten(Node head) {
        if (head == null) {
            return null;
        }

        Node nextNode = head.next;

        Node tailingNode = flattenChildNode(head);
        tailingNode.next = nextNode;
        if (null == nextNode) {
            return tailingNode;
        } else {
            nextNode.prev = tailingNode;
            return doFlatten(nextNode);
        }
    }

    private Node flattenChildNode(Node node) {
        if (node.child == null) {
            return node;
        }

        Node childNode = node.child;

        node.next = childNode;
        node.child = null;
        childNode.prev = node;

        return doFlatten(childNode);
    }

    public static void main(String[] args) {
        Node node1 = new Node(1);
        Node node2 = new Node(2);
        Node node3 = new Node(3);
        node1.child = node2;
        node2.child = node3;

        System.out.println(new Solution().flatten(node1));
    }
}
