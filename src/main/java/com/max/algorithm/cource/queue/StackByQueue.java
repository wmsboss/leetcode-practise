package com.max.algorithm.cource.queue;

/**
 * Created by wumingshan on 2020/10/22.
 */
public class StackByQueue {
    private Queue<Integer> queue;

    public StackByQueue() {
        queue = new ArrayQueue<>();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public void push(int x) {
        queue.enqueue(x);
    }

    public int pop() {
        Queue<Integer> queue2 = new ArrayQueue<>();

        // 除了最后一个元素，将 q 中的所有元素放入 q2
        while (queue.getSize() > 1) {
            queue2.enqueue(queue.dequeue());
        }

        // q 中剩下的最后一个元素就是“栈顶”元素
        int ret = queue.dequeue();

        // 此时 q2 是整个数据结构存储的所有其他数据，赋值给 q
        queue = queue2;

        // 返回“栈顶元素”
        return ret;
    }

    public int top() {
        int ret = pop();

        push(ret);

        return ret;
    }

    @Override
    public String toString(){
        return queue.toString();
    }

    public static void main(String[] args) {
        StackByQueue stack = new StackByQueue();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
