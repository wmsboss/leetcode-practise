package com.max.algorithm.cource.queue;

import com.max.algorithm.cource.stack.ArrayStack;
import com.max.algorithm.cource.stack.Stack;

/**
 * Created by wumingshan on 2020/10/22.
 * push 是 O(1) 的，pop 是 O(n)
 */
public class QueueByStack1 {
    private ArrayStack<Integer> stack;
    int front;

    public QueueByStack1() {
        stack = new ArrayStack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if (empty()) {
            front = x;
        }

        stack.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        Stack<Integer> stack2 = new ArrayStack<>();

        while(stack.getSize() > 1) {
            front = stack.peek();
            stack2.push(stack.pop());
        }

        int ret = stack.pop();

        while(!stack2.isEmpty())
            stack.push(stack2.pop());

        return ret;
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
