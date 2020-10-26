package com.max.algorithm.cource.linkedlist;

/**
 * 引入dummyHeader概念
 */
public class LinkedList2<E> {
    private final Node dummyHead;
    private int size;

    public LinkedList2() {
        this.dummyHead = new Node(null);
        this.size = 0;
    }

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

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }

        // Node node = new Node(e);
        // node.next = prev.next;
        // prev.next = node;

        prev.next = new Node(e, prev.next);
        size ++;
    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    /**
     * 获取链表的第(0-based)个位置的元素
     * 在链表中不是一个常用的操作，联系用：
     */
    public E get(int index) {
        if (index < 0 || index  >= size) {
            throw new IllegalArgumentException("Get failed, Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        return cur.e;
    }

    public E getFirst() {
        return get(0);
    }

    public E getLast() {
        return get(size - 1);
    }

    public void set(int index, E e) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Set failed, Illegal index.");
        }

        Node cur = dummyHead.next;
        for (int i = 0; i < index; i++) {
            cur = cur.next;
        }

        cur.e = e;
    }

    public boolean contains(E e) {
        Node cur = dummyHead.next;

        while (cur != null) {
            if (cur.e.equals(e)) {
                return true;
            }

            cur = cur.next;
        }

        return false;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append("HEAD->");

        // Node cur = dummyHead.next;
        // while (cur != null) {
        //     result.append(cur + "->");
        //     cur = cur.next;
        // }

        for (Node cur = dummyHead.next; cur != null; cur = cur.next) {
            result.append(cur + "->");
        }

        result.append("NULL");

        return result.toString();
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
}
