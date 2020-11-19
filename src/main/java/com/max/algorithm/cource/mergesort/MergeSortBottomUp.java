package com.max.algorithm.cource.mergesort;

import java.awt.geom.Point2D;
import java.util.Arrays;

public class MergeSortBottomUp {
    private MergeSortBottomUp(){}

    // 自底向上的归并排序
    public static <E extends Comparable<E>> void sortBottomUp(E[] arr){
        E[] temp = Arrays.copyOf(arr, arr.length);

        int n = arr.length;

        // 遍历合并的区间长度
        for(int arrSize = 1; arrSize < n; arrSize += arrSize){
            // 遍历合并的两个区间的起始位置 i
            // 合并 [i, i + sz - 1] 和 [i + sz, Math.min(i + sz + sz - 1, n - 1)]
            for(int i = 0; i + arrSize < n; i += arrSize + arrSize) {
                if(arr[i + arrSize - 1].compareTo(arr[i + arrSize]) > 0) {
                    merge(arr, i, i + arrSize - 1, Math.min(i + arrSize + arrSize - 1, n - 1), temp);
                }
            }
        }
    }

    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r, E[] aux){
        System.arraycopy(arr, l, aux, l, r - l + 1);

        int i = l, j = mid + 1;

        // 每轮循环为 arr[k] 赋值
        for (int k = l; k <= r; k ++) {
            if (i > mid) {
                arr[k] = aux[j]; j ++;
            } else if(j > r) {
                arr[k] = aux[i]; i ++;
            } else if(aux[i].compareTo(aux[j]) <= 0) {
                arr[k] = aux[i]; i ++;
            } else {
                arr[k] = aux[j]; j ++;
            }
        }
    }

    public static void main(String[] args){
        int n = 10000000;
        Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
        Integer[] arr2 = Arrays.copyOf(arr, arr.length);

        SortingHelper.sortTest("MergeSort", arr);
        SortingHelper.sortTest("MergeSortBottomUp", arr2);
    }
}
