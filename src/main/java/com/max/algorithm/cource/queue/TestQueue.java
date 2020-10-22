package com.max.algorithm.cource.queue;

import java.util.Random;

/**
 * Created by wumingshan on 2020/10/22.
 */
public class TestQueue {
    public static void main(String[] args) {
        int opCount = 100000;

        ArrayQueue<Integer> arrayQueue = new ArrayQueue<>();
        double time1 = testQueue(arrayQueue, opCount);
        System.out.println("ArrayQueue, time: " + time1 + " s");

        LoopQueue<Integer> loopQueue = new LoopQueue<>();
        double time2 = testQueue(loopQueue, opCount);
        System.out.println("LoopQueue, time: " + time2 + " s");
    }

    // Test execute opCount enQueue and deQueue operation, return total time consumes
    private static double testQueue(Queue<Integer> q, int opCount){
        long startTime = System.nanoTime();

        Random random = new Random();
        for(int i = 0 ; i < opCount ; i ++) {
            q.enqueue(random.nextInt(Integer.MAX_VALUE));
        }

        for(int i = 0 ; i < opCount ; i ++) {
            q.dequeue();
        }

        return (System.nanoTime() - startTime) / 1000 * 1000 * 1000 * 1.0;
    }
}
