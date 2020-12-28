package com.max.algorithm.cource.quicksort;

import com.max.algorithm.cource.mergesort.ArrayGenerator;
import com.max.algorithm.cource.mergesort.SortingHelper;

import java.util.Arrays;
import java.util.Random;

/**
 * Use two ways sort logic
 */
public class QuickSortThreeWays {

    private QuickSortThreeWays(){}

    public static <E extends Comparable<E>> void sort3ways(E[] arr) {
        Random rnd = new Random();
        sort3ways(arr, 0, arr.length - 1, rnd);
    }

    private static <E extends Comparable<E>> void sort3ways(E[] arr, int l, int r, Random rnd) {
        if(l >= r) return;

        // partition过程

        // 生成 [l, r] 之间的随机索引
        int p  = rnd.nextInt(r - l + 1) + l;
        swap(arr, l, p);

        // arr[l + 1, lt] < v, arr[lt + 1, i - 1] == v, arr[gt, r] > v
        int lt = l, i = l + 1, gt = r + 1;
        while(i < gt) {
            if (arr[i].compareTo(arr[l]) < 0) {
                lt ++;
                swap(arr, i, lt);
                i ++;
            } else if (arr[i].compareTo(arr[l]) > 0) {
                gt --;
                swap(arr, i, gt);
            } else {
                // arr[i] == v
                i ++;
            }
        }

        swap(arr, l, lt);

        //partition 过程结束

        // 递归调用
        sort3ways(arr, l, lt - 1, rnd);
        sort3ways(arr, gt, r, rnd);
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 1000000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);
        Integer[] arr3 = Arrays.copyOf(arr, arr.length);

        System.out.println("Random Array");
        SortingHelper.sortTest("QuickSort", arr);
        SortingHelper.sortTest("QuickSort2Ways", arr2);
        SortingHelper.sortTest("QuickSort3Ways", arr3);
        System.out.println();


        arr = ArrayGenerator.generateOrderedArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);

        System.out.println("Ordered Array");
        SortingHelper.sortTest("QuickSort", arr);
        SortingHelper.sortTest("QuickSort2Ways", arr2);
        SortingHelper.sortTest("QuickSort3Ways", arr3);
        System.out.println();


        arr = ArrayGenerator.generateRandomArray(n, 1);
        arr2 = Arrays.copyOf(arr, arr.length);
        arr3 = Arrays.copyOf(arr, arr.length);

        System.out.println("Same Value Array");
        SortingHelper.sortTest("QuickSort2Ways", arr2);
        SortingHelper.sortTest("QuickSort3Ways", arr3);
        System.out.println();
    }
}
