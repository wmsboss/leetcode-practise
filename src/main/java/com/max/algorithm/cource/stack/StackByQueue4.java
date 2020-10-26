package com.max.algorithm.cource.stack;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by wumingshan on 2020/10/22.
 * 使用队列实现栈
 *
 * 思考：我们可不可能只是用一个队列，而不使用第二个队列解决这个问题？
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

    /**
     * 1. 把新的x直接放在q的队尾
     * 2. 将x调整到q的队首，同时其他元素的位置不变。
     * 将q中的其他元素，出队再入队。执行n-1次以后，就是我们想要的结果了。
     * @param e
     */
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
