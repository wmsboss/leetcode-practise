package com.max.algorithm.cource.recursion;

import javafx.util.Pair;

public class LinkedListImplementByRecursion<E> {
    // 在链表的递归实现中，我们不使用虚拟头结点，也能无差异的处理位置0的问题
    private Node head;
    private int size;

    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * 在链表的index(0-based)位置添加新元素e
     * 在链表中不是一个常用的操作，练习用：
     */
    public void add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed, Illegal index.");
        }

        head = add(head, index, e);
        size ++;
    }

    // 在头结点的位置插入元素
    private Node add(Node node, int index, E e) {
        if (index == 0) {
            return new Node(e, node);
        }

        node.next = add(node.next, index  - 1, e);

        return node;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Get failed, Illegal index.");
        }

        return get(head, index);
    }

    private E get(Node node, int index) {
        if (index == 0) {
            return node.e;
        }

        return get(node.next, index - 1);
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Update failed, Illegal index.");
        }

        set(head, index, e);
    }

    private void set(Node node, int index, E e) {
        if (index == 0) {
            node.e = e;
            return;
        }

        set(node.next, index - 1, e);
    }

    public boolean contains(E e) {
        return contains(head, e);
    }

    private boolean contains(Node node, E e) {
        if (node == null) {
            return false;
        }

        if (node.e.equals(e)) {
            return true;
        }

        return contains(node.next, e);
    }

    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed, Illegal index.");
        }

        Pair<Node, E> res = remove(head, index);
        size --;
        head = res.getKey();
        return res.getValue();
    }

    private Pair<Node, E> remove(Node node, int index) {
        if (index == 0) {
            return new Pair<>(node.next, node.e);
        }

        Pair<Node, E> res = remove(node.next, index - 1);
        node.next = res.getKey();

        return new Pair<>(node, res.getValue());
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public void removeElement(E e) {
        head = removeElement(head, e);
    }

    private Node removeElement(Node node, E e) {
        if (node == null) {
            return null;
        }

        node.next = removeElement(node.next, e);

        if (node.e.equals(e)) {
            size --;
            return node.next;
        }

        return node;
    }

    private class Node {
        public E e;

        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node() {
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    public static void main(String[] args) {
        LinkedListImplementByRecursion<Integer> list = new LinkedListImplementByRecursion<>();
        for (int i = 0; i < 10; i++) {
            list.addFirst(i);
        }

        while (!list.isEmpty()) {
            System.out.println("Removed: " + list.removeFirst());
        }
    }
}
