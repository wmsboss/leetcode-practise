package com.max.algorithm.cource.stack;


import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wumingshan on 2020/10/22.
 * 使用队列实现栈
 * push是O(n)的，pop是o(1)的
 */
public class StackByQueue3 {
    private Queue<Integer> queue;
    private int top; // 追踪记录栈顶元素

    public StackByQueue3() {
        queue = new LinkedList<>();
    }

    public boolean empty() {
        return queue.isEmpty();
    }

    public void push(int e) {
        Queue<Integer> q2 = new LinkedList<>();

        while(!queue.isEmpty())
            q2.add(queue.remove());

        queue.add(e);

        while (!q2.isEmpty()) {
            queue.add(q2.remove());
        }
    }

//    public void push(int x) {
//
//        Queue<Integer> q2 = new LinkedList<>();
//
//        q2.add(x);
//        while(!queue.isEmpty()) {
//            q2.add(queue.remove());
//        }
//
//        queue = q2;
//    }

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
        StackByQueue3 stack = new StackByQueue3();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
