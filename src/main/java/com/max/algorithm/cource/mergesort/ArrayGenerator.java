package com.max.algorithm.cource.mergesort;

import java.util.Random;

public class ArrayGenerator {
    private ArrayGenerator(){}

    public static Integer[] generateOrderedArray(int n) {
        Integer[] resultArray = new Integer[n];

        for(int i = 0; i < n; i ++) {
            resultArray[i] = i;
        }

        return resultArray;
    }

    // 生成一个长度为 n 的随机数组，每个数字的范围是 [0, bound)
    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] resultArray = new Integer[n];
        Random random = new Random();

        for(int i = 0; i < n; i ++) {
            resultArray[i] = random.nextInt(bound);
        }

        return resultArray;
    }
}
