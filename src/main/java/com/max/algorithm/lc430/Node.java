package com.max.algorithm.lc430;

public class Node {
    public int val;
    public Node prev;
    public Node next;
    public Node child;

    public Node() {

    }

    public Node(int val) {
        this.val = val;
    }

    @Override
    public String toString() {
        return toString(this);
    }

    private String toString(Node node) {
        StringBuilder sb = new StringBuilder();

        sb.append(val).append("->");
        if (null != node.child) {
            sb.append(node.child.toString());
        }

        if (null != node.next) {
            sb.append(node.next.toString());
        }

        return sb.toString();
    }
}
