package com.max.algorithm.cource.binarysearchtree;

public class BST<E extends Comparable<E>> {
    private class Node {
        public E e;

        public Node left, right;

        public Node(E e) {
            this.e = e;
            this.left = null;
            this.right = null;
        }
    }

    private Node root;
    private int size;

    public BST() {
        root = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(E e) {
        if (root == null) {
            root = new Node(e);
        } else {
            add(root, e);
        }
    }

    private void add(Node node, E e) {
        if(e.equals(node.e))
            return;
        else if(e.compareTo(node.e) < 0 && node.left == null){
            node.left = new Node(e);
            size ++;
            return;
        }
        else if(e.compareTo(node.e) > 0 && node.right == null){
            node.right = new Node(e);
            size ++;
            return;
        }

        if(e.compareTo(node.e) < 0) {
            add(node.left, e);
        } else {
            //e.compareTo(node.e) > 0
            add(node.right, e);
        }
    }

    // 向二分搜索树中添加新的元素e
    public void add2(E e){
        root = add2(root, e);
    }

    // 向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add2(Node node, E e){
        if(node == null){
            size ++;
            return new Node(e);
        }

        if(e.compareTo(node.e) < 0)
            node.left = add2(node.left, e);
        else if(e.compareTo(node.e) > 0)
            node.right = add2(node.right, e);

        return node;
    }
}
