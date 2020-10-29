package com.max.algorithm.cource.linkedlist;

import com.max.algorithm.cource.array.Array2;

public class Main {
    public static void main(String[] args) {
        performanceTest();

        LinkedList2<Integer> linkedList = new LinkedList2<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2, 666);
        System.out.println(linkedList);

        linkedList.remove(2);
        System.out.println(linkedList);

        linkedList.removeFirst();
        System.out.println(linkedList);

        linkedList.removeLast();
        System.out.println(linkedList);
    }

    public static void performanceTest() {
        Array2<Integer> array = new Array2<>();
        LinkedList2<Integer> list = new LinkedList2<>();

        int n = 1000000;
        System.out.println("n = " + n);

        long startTime = System.nanoTime();
        for(int i = 0; i < n; i ++)
            array.addLast(i);
        long endTime = System.nanoTime();
        double time = (endTime - startTime) / 1000000000.0;
        System.out.println("Array : " + time + " s");

        startTime = System.nanoTime();
        for(int i = 0; i < n; i ++)
            list.addFirst(i);
        endTime = System.nanoTime();
        time = (endTime - startTime) / 1000000000.0;
        System.out.println("LinkedList : " + time + " s");
    }
}
