package com.max.algorithm.cource.quicksort;

import com.max.algorithm.cource.mergesort.ArrayGenerator;
import com.max.algorithm.cource.mergesort.SortingHelper;

import java.util.Arrays;
import java.util.Random;

/**
 * Use two ways sort logic
 */
public class QuickSortTwoWays {

    private QuickSortTwoWays(){}

    public static <E extends Comparable<E>> void sort(E[] arr) {
        Random rnd = new Random();
        sort(arr, 0, arr.length - 1, rnd);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, Random rnd) {
        if(l >= r) return;

        int p = partition(arr, l, r, rnd);
        sort(arr, l, p - 1, rnd);
        sort(arr, p + 1, r, rnd);
    }

    private static <E extends Comparable<E>> int partition(E[] arr, int l, int r, Random rnd) {
        // 生成 [l, r] 之间的随机索引
        int p = l + rnd.nextInt(r - l + 1);
        swap(arr, l, p);

        // arr[l+1...i-1] <= v; arr[j+1...r] >= v
        int i = l + 1, j = r;
        while (true) {
            while (i <= j && arr[i].compareTo(arr[l]) < 0)
                i ++;

            while (j >= i && arr[j].compareTo(arr[l]) > 0)
                j --;

            if(i >= j) break;

            swap(arr, i, j);

            i ++;
            j --;
            j --;
        }

        swap(arr, l, j);

        return j;
    }

    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int n = 100000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

        System.out.println("Random Array");
        SortingHelper.sortTest("QuickSort", arr);
        SortingHelper.sortTest("QuickSort2Ways", arr2);

        System.out.println();


        arr = ArrayGenerator.generateOrderedArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);

        System.out.println("Ordered Array");
        SortingHelper.sortTest("QuickSort", arr);
        SortingHelper.sortTest("QuickSort2Ways", arr2);
        System.out.println();


        arr = ArrayGenerator.generateRandomArray(n, 1);
        arr2 = Arrays.copyOf(arr, arr.length);

        System.out.println("Same Value Array");
        SortingHelper.sortTest("QuickSort", arr);
        SortingHelper.sortTest("QuickSort2Ways", arr2);
        System.out.println();
    }
}
