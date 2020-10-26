package com.max.algorithm.cource.queue;

/**
 * Created by wumingshan on 2020/10/22.
 */
public class LoopQueueWithNoSize<E> implements Queue<E> {
    private E[] data;

    private int front;

    private int tail;

    public LoopQueueWithNoSize(int capacity) {
        data = (E[])new Object[capacity + 1];
        front = 0;
        tail = 0;
    }

    public LoopQueueWithNoSize() {
        this(10);
    }

    public int getCapacity() {
        return data.length - 1;
    }

    @Override
    public boolean isEmpty() {
        return front == tail;
    }

    @Override
    public int getSize() {
        // 如果tail >= front，队列中的元素个数就是tail - front
        // 如果tail < front，队列中的元素个数为：tail - front + data.length
        // 也可以理解成，data中没有元素的数目为front - tail,
        // 整体元素个数就是 data.length - (front - tail) = data.length + tail - front

        return tail >= front ? tail - front : tail - front + data.length;
    }

    @Override
    public void enqueue(E e) {
        if ((tail + 1) % data.length == front) {
            resize(getCapacity() * 2);
        }

        data[tail] = e;
        tail = (tail + 1) % data.length;
    }

    @Override
    public E dequeue() {
        if(isEmpty()) {
            throw new IllegalArgumentException("Cannot dequeue from an empty queue.");
        }

        E ret = data[front];
        data[front] = null;
        front = (front + 1) % data.length;

        if(getSize() == getCapacity() / 4 && getCapacity() / 2 != 0) {
            resize(getCapacity() / 2);
        }

        return ret;
    }

    @Override
    public E getFront(){
        if(isEmpty()) {
            throw new IllegalArgumentException("Queue is empty.");
        }

        return data[front];
    }

    private void resize(int newCapacity){
        E[] newData = (E[]) new Object[newCapacity + 1];
        int oldSize = getSize();

        for(int i = 0 ; i < oldSize ; i ++) {
            newData[i] = data[(i + front) % data.length];
        }

        data = newData;
        front = 0;
        tail = oldSize;
    }

    @Override
    public String toString() {
        StringBuilder res = new StringBuilder();
        res.append(String.format("Queue: size = %d , capacity = %d\n", getSize(), getCapacity()));
        res.append("front [");

        for(int i = front; i != tail; i = (i + 1) % data.length) {
            res.append(data[i]);

            if((i + 1) % data.length != tail) {
                res.append(", ");
            }
        }

        res.append("] tail");

        return res.toString();
    }

    public static void main(String[] args) {
        LoopQueue<Integer> queue = new LoopQueue<>();

        for(int i = 0 ; i < 10 ; i ++){
            queue.enqueue(i);
            System.out.println(queue);

            if(i % 3 == 2){
                queue.dequeue();
                System.out.println(queue);
            }
        }
    }
}
