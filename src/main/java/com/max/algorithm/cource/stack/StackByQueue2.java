package com.max.algorithm.cource.stack;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wumingshan on 2020/10/22.
 * 使用队列实现栈
 *
 * 使top的复杂度降到1
 * 复杂度：push是O(1)的，pop是o(n)的
 */
public class StackByQueue2 {
    private Queue<Integer> queue;

    // 追踪记录栈顶元素
    private int top;

    public StackByQueue2() {
        queue = new LinkedList<>();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public void push(int e) {
        queue.add(e);
        top = e;
    }

    public int pop() {
        Queue<Integer> queue2 = new LinkedList<>();
        while (queue.size() > 1){
            // 每从 queue 中取出一个元素，都给 top 赋值
            // top 最后存储的就是 queue 中除了队尾元素以外的最后一个元素
            // 即新的栈顶元素
            top = queue.peek();
            queue2.add(queue.remove());
        }

        int ret = queue.remove();
        queue = queue2;

        return ret;
    }

    public int top() {
        return top;
    }

    @Override
    public String toString(){
        return queue.toString();
    }

    public static void main(String[] args) {
        StackByQueue2 stack = new StackByQueue2();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
