package com.max.algorithm.cource.linkedlist;

import com.max.algorithm.cource.stack.Stack;

/**
 * Created by wumingshan on 2020/10/29.
 */
public class LinkedListStack<E> implements Stack<E> {
    private LinkedList2<E> list;

    public LinkedListStack(){
        list = new LinkedList2<>();
    }

    @Override
    public int getSize() {
        return list.getSize();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public void push(E e) {
        list.addFirst(e);
    }

    @Override
    public E pop() {
        return list.removeFirst();
    }

    @Override
    public E peek() {
        return list.getFirst();
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();

        result.append("Stack: top ");
        result.append(list);

        return result.toString();
    }

    public static void main(String[] args) {
        LinkedListStack<Integer> stack = new LinkedListStack<>();

        for(int i = 0 ; i < 5 ; i ++){
            stack.push(i);
            System.out.println(stack);
        }

        stack.pop();
        System.out.println(stack);
    }
}
