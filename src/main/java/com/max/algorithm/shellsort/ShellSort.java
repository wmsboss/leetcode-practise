package com.max.algorithm.shellsort;

import java.util.Arrays;

public class ShellSort {

    public static void main(String[] args) {
        ShellSort shellSort = new ShellSort();
        int [] sourceArray = new int[] {3, 2, 4, 1, 5};

        int [] targetArray = shellSort.sort(sourceArray);
        for (int targetItem : targetArray) {
            System.out.print(targetItem + " ");
        }
        System.out.println();
    }

    public int[] sort(int[] sourceArray) {
        // 对 arr 进行拷贝，不改变参数内容
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);

        int gap = 1;
        while (gap < arr.length) {
            gap = gap * 3 + 1;
        }

        while (gap > 0) {
            for (int i = gap; i < arr.length; i++) {
                int tmp = arr[i];
                int j = i - gap;
                while (j >= 0 && arr[j] > tmp) {
                    arr[j + gap] = arr[j];
                    j -= gap;
                }
                arr[j + gap] = tmp;
            }
            gap = (int) Math.floor(gap / 3);
        }

        return arr;
    }
}

