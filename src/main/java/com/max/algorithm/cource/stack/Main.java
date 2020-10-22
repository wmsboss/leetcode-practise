package com.max.algorithm.cource.stack;

/**
 * Created by wumingshan on 2020/10/19.
 */
public class Main {

    public static void main(String[] args) {
        ArrayStack<Integer> stack = new ArrayStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
