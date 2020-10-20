package com.max.algorithm.cource.stack;

/**
 * Created by wumingshan on 2020/10/19.
 */
public interface Stack<E> {
    int getSize();
    boolean isEmpty();
    void push(E e);
    E pop();
    E peek();
}
