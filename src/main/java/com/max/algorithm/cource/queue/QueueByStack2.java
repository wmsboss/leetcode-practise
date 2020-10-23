package com.max.algorithm.cource.queue;

import com.max.algorithm.cource.stack.ArrayStack;
import com.max.algorithm.cource.stack.Stack;

/**
 * Created by wumingshan on 2020/10/22.
 * push 是 O(1) 的，pop 是 O(n)
 */
public class QueueByStack2 {
    private Stack<Integer> stack1;
    private Stack<Integer> stack2;
    int front;

    public QueueByStack2() {
        stack1 = new ArrayStack<>();
        stack2 = new ArrayStack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        if(stack1.isEmpty()) {
            front = x;
        }

        stack1.push(x);
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        // 如果 stack2 不为空，直接返回 stack2 的栈首元素
        if(!stack2.isEmpty())
            return stack2.pop();

        while(stack1.getSize() > 1)
            stack2.push(stack1.pop());

        return stack1.pop();
    }

    /** Get the front element. */
    public int peek() {
        if(!stack2.isEmpty())
            return stack2.peek();
        return front;
    }

    /** Returns whether the queue is empty. */
    public boolean empty() {
        return stack1.isEmpty() && stack2.isEmpty();
    }

    @Override
    public String toString() {
        return stack1.toString();
    }

    public static void main(String[] args) {
        QueueByStack2 queue = new QueueByStack2();

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
