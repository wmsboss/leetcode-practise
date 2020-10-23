package com.max.algorithm.cource.stack;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wumingshan on 2020/10/22.
 * 使用队列实现栈
 * push是O(n)的，pop是o(1)的
 */
public class StackByQueue4 {
    private Queue<Integer> queue;
    private int top; // 追踪记录栈顶元素

    public StackByQueue4() {
        queue = new LinkedList<>();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public void push(int e) {
        // 首先，将 x 入队
        queue.add(e);

        // 执行 n - 1 次出队再入队的操作
        for(int i = 1; i < queue.size(); i ++) {
            queue.add(queue.remove());
        }
    }

    public int pop() {
        return queue.remove();
    }

    public int top() {
        return queue.peek();
    }

    @Override
    public String toString(){
        return queue.toString();
    }

    public static void main(String[] args) {
        StackByQueue4 stack = new StackByQueue4();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
