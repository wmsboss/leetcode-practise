package com.max.algorithm.cource.heap;

public class MaxHeap<E extends Comparable<E>> {
    private Array<E> data;

    public MaxHeap() {
        data = new Array<>();
    }

    public MaxHeap(int capacity) {
        data = new Array<>(capacity);
    }

    public MaxHeap(E[] arr){
        data = new Array<E>(arr);
        if(arr.length != 1){
            for(int i = parent(arr.length - 1) ; i >= 0 ; i --)
                siftDown(i);
        }
    }

    public int size() {
        return data.getSize();
    }

    public boolean isEmpty() {
        return data.isEmpty();
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的父亲节点的索引
    private int parent(int index) {
        if (index == 0) {
            throw new IllegalArgumentException("index-0 doesn't have parent.");
        }

        return (index - 1) / 2;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的左孩子节点的索引
    private int leftChild(int index) {
        return index * 2 + 1;
    }

    // 返回完全二叉树的数组表示中，一个索引所表示的元素的右孩子节点的索引
    private int rightChild(int index) {
        return index * 2 + 2;
    }

    // 向堆中添加元素
    public void add(E e) {
        data.addLast(e);

        siftUp(data.getSize() - 1);
    }

    private void siftUp(int k) {
        while (k > 0 && data.get(parent(k)).compareTo(data.get(k)) < 0) {
            data.swap(k, parent(k));

            k = parent(k);
        }
    }

    // 查看堆中的最大元素，不操作
    public E findMax() {
        if (data.getSize() == 0) {
            throw new IllegalArgumentException("Can't find max value, the heap is empty!");
        }

        return data.get(0);
    }

    // 取出堆中最大值
    public E extractMax() {
        E result = findMax();

        data.swap(0, data.getSize() - 1);
        data.removeLast();
        siftDown(0);

        return result;
    }

    private void siftDown(int k) {
        while (leftChild(k) < data.getSize()) {
            // 在此轮循环中,data[k]和data[j]交换位置
            int j  = leftChild(k);
            // data[j] 是 leftChild 和 rightChild 中的最大值
            if (j + 1 < data.getSize() && data.get(j + 1).compareTo(data.get(j)) > 0) {
                j ++;
            }

            if (data.get(k).compareTo(data.get(j)) >= 0) {
                break;
            }

            data.swap(k, j);
            k = j;
        }
    }

    // 取出堆中的最大元素，并且替换成元素e
    public E replace(E e) {
        E ret = findMax();

        data.set(0, e);
        siftDown(0);

        return ret;
    }
}
