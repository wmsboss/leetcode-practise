package com.max.algorithm.cource.queue;

import java.util.Stack;

/**
 * Created by wumingshan on 2020/10/22.
 *
 * 复杂度：push 是 O(1) 的，pop 是 O(n)
 */
public class QueueByStack1 {
    private Stack<Integer> stack;
    int front;

    public QueueByStack1() {
        stack = new Stack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (empty()) {
            front = x;
        }

        stack.push(x);
    }

    /**
     * O(n)
     * Removes the element from in front of queue and returns that element.
     * */
    public int pop() {
        // 暂存除了最后一个元素以外的所有元素
        Stack<Integer> stack2 = new Stack<>();

        while (stack.size() > 1) {
            front = stack.peek(); // 需要注意front的维护

            stack2.push(stack.pop());
        }

        // 取出栈底元素
        int result = stack.pop();

        // 把stack2的所有元素放回stack中
        while (!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }


        return result;
    }

    /** Get the front element. */
    public int peek() {
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack.isEmpty();
    }

    @Override
    public String toString() {
        return stack.toString();
    }

    public static void main(String[] args) {
        QueueByStack1 queue = new QueueByStack1();

        for(int i = 0 ; i < 8 ; i ++) {
            queue.push(i);
            System.out.println(i +  " " + queue);

            if(i % 3 == 2) {
                queue.pop();
                System.out.println(queue);
            }
        }
    }
}
