package com.max.algorithm.cource.mergesort;

import java.util.Arrays;

public class MergeSortOptimizeSortedArray {
    private MergeSortOptimizeSortedArray() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr){
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r){
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;

        sort(arr, l, mid);

        sort(arr, mid + 1, r);

        // 优化：如果mid < mid + 1, 说明已经是排序好的
        if(arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r);
        }
    }

    // 合并两个有序区间arr[l, mid]和arr[mid + 1, r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        E[] temp = Arrays.copyOfRange(arr, l, r + 1);

        int i = l;
        int j = mid + 1;

        // 每轮循环为 arr[k] 赋值
        for (int k = l; k <= r; k++) {
            if (i > mid) {
                arr[k] = temp[j - l];
                j++;
            } else if (j > r) {
                arr[k] = temp[i - l];
                i ++;
            } else if (temp[i - l].compareTo(temp[j - l]) <= 0) {
                arr[k] = temp[i - l];
                i ++;
            } else {
                arr[k] = temp[j - l];
                j ++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 1000000;

        System.out.println("Random Array : ");
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("MergeSort", arr);
        SortingHelper.sortTest("MergeSortOptimizeSortedArray", arr2);


        System.out.println("\nOrdered Array : ");
        arr = ArrayGenerator.generateOrderedArray(n);
        arr2 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("MergeSort", arr);
        SortingHelper.sortTest("MergeSortOptimizeSortedArray", arr2);
    }
}
