package com.max.algorithm.designAStackWithIncrementOperation;

/**
 * Created by wumingshan on 2020/10/26.
 */
class CustomStack {
    private Node topNode;
    private int maxSize = 0;

    public CustomStack(int maxSize) {
        this.maxSize = maxSize;
    }

    public void push(int x) {
        if (null == topNode) {
            topNode = new Node(x, 1);
        } else {
            int previousIndex = topNode.index;
            if (previousIndex >= maxSize) {
                return;
            }

            Node newNode = new Node(x, previousIndex + 1);
            newNode.next = topNode;

            topNode = newNode;
        }
    }

    public int pop() {
        if (null == topNode) {
            return -1;
        }

        int result = topNode.value;

        topNode = topNode.next;

        return result;
    }

    public void increment(int k, int val) {
        Node node = topNode;

        while (node != null) {
            if (node.index <= k) {
                node.value = node.value + val;
            }

            node = node.next;
        }
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer("Stack: top [");

        Node node = topNode;
        while (node != null) {
            sb.append(node.value);
            if (node.index != 1) {
                sb.append(", ");
            }

            node = node.next;
        }
        sb.append("]");

        return sb.toString();
    }

    public class Node {
        private int index;

        private int value;

        private Node next;

        public Node(int value, int index) {
            this.value = value;
            this.index = index;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getIndex() {
            return index;
        }

        public void setIndex(int index) {
            this.index = index;
        }

        public Node getNext() {
            return next;
        }

        public void setNext(Node next) {
            this.next = next;
        }
    }

    public static void main(String[] args) {
        CustomStack customStack = new CustomStack(3); // 栈是空的 []
        customStack.push(1);                          // 栈变为 [1]
        System.out.println(customStack);
        customStack.push(2);                          // 栈变为 [1, 2]
        System.out.println(customStack);
        customStack.pop();                            // 返回 2 --> 返回栈顶值 2，栈变为 [1]
        System.out.println(customStack);
        customStack.push(2);                          // 栈变为 [1, 2]
        System.out.println(customStack);
        customStack.push(3);                          // 栈变为 [1, 2, 3]
        System.out.println(customStack);
        customStack.push(4);                          // 栈仍然是 [1, 2, 3]，不能添加其他元素使栈大小变为 4
        System.out.println(customStack);
        customStack.increment(5, 100);                // 栈变为 [101, 102, 103]
        System.out.println(customStack);
        customStack.increment(2, 100);                // 栈变为 [201, 202, 103]
        System.out.println(customStack);
        customStack.pop();                            // 返回 103 --> 返回栈顶值 103，栈变为 [201, 202]
        System.out.println(customStack);
        customStack.pop();                            // 返回 202 --> 返回栈顶值 202，栈变为 [201]
        System.out.println(customStack);
        customStack.pop();                            // 返回 201 --> 返回栈顶值 201，栈变为 []
        System.out.println(customStack);
        System.out.println(customStack.pop());;                            // 返回 -1 --> 栈为空，返回 -1
        System.out.println(customStack);
    }
}
