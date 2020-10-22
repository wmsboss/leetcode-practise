package com.max.algorithm.cource.queue;

/**
 * Created by wumingshan on 2020/10/22.
 */
public class DeQueue<E> {
    private E[] data;

    private int front;

    private int tail;

    private int size;

    public DeQueue(int capacity){
        data = (E[]) new Object[capacity];
        front = 0;
        tail = 0;
        size = 0;
    }

    public DeQueue(){
        this(10);
    }

    public int getCapacity() {
        return data.length;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }

    public void addLast(E e) {
        if(size == getCapacity()) {
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
        size ++;
    }

    public void addFront(E e){
        if(size == getCapacity()) {
            resize(getCapacity() * 2);
        }

        front = front == 0 ? data.length - 1 : front - 1;
        data[front] = e;
        size ++;
    }

    public E removeFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;
        size --;

        if(getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return ret;
    }

    public E removeLast() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        tail = tail == 0 ? data.length - 1 : tail - 1;

        E ret = data[tail];
        data[tail] = null;
        size --;

        if(getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return ret;
    }

    public E getFront() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }

        return data[front];
    }

    public E getLast(){
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }

        int index = tail == 0 ? data.length - 1 : tail - 1;

        return data[index];
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity];

        for(int i = 0 ; i < size ; i ++) {
            newData[i] = data[(i + front) % data.length];
        }

        data = newData;
        front = 0;
        tail = size;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", getSize(), getCapacity()));
        res.append("front [");

        for(int i = 0 ; i < size ; i ++){
            res.append(data[(i + front) % data.length]);

            if(i != size - 1) {
                res.append(", ");
            }
        }
        res.append("] tail");

        return res.toString();
    }

    public static void main(String[] args){
        // 在下面的双端队列的测试中，偶数从队尾加入；奇数从队首加入
        DeQueue<Integer> dq = new DeQueue<>();
        for(int i = 0 ; i < 16 ; i ++){
            if(i % 2 == 0) dq.addLast(i);
            else dq.addFront(i);
            System.out.println(dq);
        }

        // 之后，我们依次从队首和队尾轮流删除元素
        System.out.println();
        for(int i = 0; !dq.isEmpty(); i ++){
            if(i % 2 == 0) dq.removeFront();
            else dq.removeLast();
            System.out.println(dq);
        }
    }
}

