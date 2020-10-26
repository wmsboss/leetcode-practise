package com.max.algorithm.designCircularQueue;

/**
 * Created by wumingshan on 2020/10/26.
 */
class MyCircularQueue {
    private Integer[] data;

    private int front;

    private int tail;

    /** Initialize your data structure here. Set the size of the queue to be k. */
    public MyCircularQueue(int k) {
        data = new Integer[k + 1];
        front = 0;
        tail = 0;
    }

    /** Insert an element into the circular queue. Return true if the operation is successful. */
    public boolean enQueue(int value) {
        // 队列已满
        if((tail + 1) % data.length == front) {
            return false;
        }

        data[tail] = value;
        tail = (tail + 1) % data.length;

        return true;
    }

    /** Delete an element from the circular queue. Return true if the operation is successful. */
    public boolean deQueue() {
        if(isEmpty()) {
            return false;
        }

        data[front] = null;
        front = (front + 1) % data.length;

        return true;
    }

    /** Get the front item from the queue. */
    public int Front() {
        if(isEmpty()) {
            return -1;
        }

        return data[front];
    }

    /** Get the last item from the queue. */
    public int Rear() {
        if(isEmpty()) {
            return -1;
        }

        int index = tail == 0 ? data.length - 1 : tail - 1;

        return data[index];
    }

    /** Checks whether the circular queue is empty or not. */
    public boolean isEmpty() {
        return front == tail;
    }

    /** Checks whether the circular queue is full or not. */
    public boolean isFull() {
        return((tail + 1) % data.length == front);
    }

    public static void main(String[] args) {
        MyCircularQueue circularQueue = new MyCircularQueue(3); // 设置长度为 3

        System.out.println(circularQueue.enQueue(1)); // 返回 true
        System.out.println(circularQueue.enQueue(2)); // 返回 true
        System.out.println(circularQueue.enQueue(3)); // 返回 true
        System.out.println(circularQueue.enQueue(4)); // 返回 false，队列已满
        System.out.println(circularQueue.Rear()); // 返回 3
        System.out.println(circularQueue.isFull()); // 返回 true
        System.out.println(circularQueue.deQueue()); // 返回 true
        System.out.println(circularQueue.enQueue(4)); // 返回 true
        System.out.println(circularQueue.Rear()); // 返回 4
    }
}
