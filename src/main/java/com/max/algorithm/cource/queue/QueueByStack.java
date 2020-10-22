package com.max.algorithm.cource.queue;

import com.max.algorithm.cource.array.Array;
import com.max.algorithm.cource.stack.ArrayStack;

/**
 * Created by wumingshan on 2020/10/22.
 */
public class QueueByStack {
    private ArrayStack<Integer> stack;

    public QueueByStack() {
        stack = new ArrayStack<>();
    }

    /** Push element x to the back of queue. */
    public void push(int x) {
        ArrayStack<Integer> stack2 = new ArrayStack<>();

        while(!stack.isEmpty())
            stack2.push(stack.pop());

        stack.push(x);

        while(!stack2.isEmpty())
            stack.push(stack2.pop());
    }

    /** Removes the element from in front of queue and returns that element. */
    public int pop() {
        return stack.pop();
    }

    /** Get the front element. */
    public int peek() {
        return stack.peek();
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
        QueueByStack queue = new QueueByStack();

        for(int i = 0 ; i < 8 ; i ++) {
            queue.push(i);
            System.out.println(i +  " " + queue);

//            if(i % 3 == 2) {
//                queue.pop();
//                System.out.println(queue);
//            }
        }
    }
}
