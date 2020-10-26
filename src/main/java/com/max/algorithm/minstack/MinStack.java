package com.max.algorithm.minstack;

/**
 * Created by wumingshan on 2020/10/26.
 */
class MinStack {
    private Node topNode;

    public MinStack() {

    }

    public void push(int x) {
        if (null == topNode) {
            topNode = new Node(x, x);
        } else {
            int min = topNode.getMin();

            if (x < min) {
                min = x;
            }

            Node newNode = new Node(x, min);
            newNode.next = topNode;

            topNode = newNode;
        }
    }

    public void pop() {
        if (null != topNode) {
            topNode = topNode.next;
        }
    }

    public int top() {
        if (null != topNode) {
            return topNode.value;
        }

        return 0;
    }

    public int getMin() {
        if (null != topNode) {
            return topNode.min;
        }

        return 0;
    }

    public class Node {
        private int value;

        private int min;

        private Node next;

        public Node(int value, int min) {
            this.value = value;
            this.min = min;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getMin() {
            return min;
        }

        public void setMin(int min) {
            this.min = min;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        System.out.println(minStack.getMin());   // 返回 -3.
        minStack.pop();
        System.out.println(minStack.top());      // 返回 0.
        System.out.println(minStack.getMin());   // 返回 -2.
    }
}
