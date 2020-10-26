package com.max.algorithm.cource.queue;

import java.util.Stack;

/**
 * Created by wumingshan on 2020/10/22.
 *
 * 复杂度：push 是 O(n) 的，pop 是 O(1)
 */
public class QueueByStack {
    private Stack<Integer> stack;

    public QueueByStack() {
        stack = new Stack<>();
    }

    /**
     * 复杂度：O(n)
     * Push element x to the back of queue.
     * */
    public void push(int x) {
        // 创建一个新的stack2
        Stack<Integer> stack2 = new Stack<>();

        // 将stack的元素暂存进stack2
        while(!stack.isEmpty()) {
            stack2.push(stack.pop());
        }

        // 在stack中添加新元素x
        stack.push(x);

        // 把stack2中的元素放回stack
        while(!stack2.isEmpty()) {
            stack.push(stack2.pop());
        }
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

            if(i % 3 == 2) {
                queue.pop();
                System.out.println(queue);
            }
        }
    }
}
