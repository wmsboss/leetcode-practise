package com.max.algorithm.cource.mergesort;

import java.util.Arrays;

public class MergeSortOptimizeMemory {
    private MergeSortOptimizeMemory(){}

    public static <E extends Comparable<E>> void sort(E[] arr){
        E[] temp = Arrays.copyOf(arr, arr.length);

        sort(arr, 0, arr.length - 1, temp);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r, E[] temp){
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;
        sort(arr, l, mid, temp);
        sort(arr, mid + 1, r, temp);

        if(arr[mid].compareTo(arr[mid + 1]) > 0) {
            merge(arr, l, mid, r, temp);
        }
    }

    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] temp) {
        System.arraycopy(arr, l, temp, l, r - l + 1);

        int i = l, j = mid + 1;

        // 每轮循环为 arr[k] 赋值
        for(int k = l; k <= r; k ++) {
            if(i > mid){
                arr[k] = temp[j]; j ++;
            } else if(j > r) {
                arr[k] = temp[i]; i ++;
            } else if(temp[i].compareTo(temp[j]) <= 0) {
                arr[k] = temp[i]; i ++;
            } else {
                arr[k] = temp[j]; j ++;
            }
        }
    }

    public static void main(String[] args){
        int n = 5000000;

        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("MergeSort", arr);
        SortingHelper.sortTest("MergeSortOptimizeMemory", arr2);
    }
}
