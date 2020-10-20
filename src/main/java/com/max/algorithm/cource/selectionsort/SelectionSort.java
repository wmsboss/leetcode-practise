package com.max.algorithm.cource.selectionsort;

/**
 * Created by wumingshan on 2020/10/16.
 */
public class SelectionSort {

    public static void sort(int[] arr) {
        // arr[0...i) 是有序的；arr[i...n) 是无序的
        for (int i = 0; i < arr.length; i++) {
            // 选择 arr[i...n) 中的最小值的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j ++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }

            swap(arr, i, minIndex);
        }
    }

    public static <E extends Comparable> void sort2(E[] arr) {
        // arr[0...i) 是有序的；arr[i...n) 是无序的
        for (int i = 0; i < arr.length; i++) {
            // 选择 arr[i...n) 中的最小值的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j ++) {
                if (arr[j].compareTo(arr[minIndex]) < 0) {
                    minIndex = j;
                }
            }

            swap2(arr, i, minIndex);
        }
    }

    public static <E extends Comparable> void sort3(E[] arr) {
        for(int i = arr.length - 1; i >= 0; i --){
            // 选择 arr[0...i] 中的最大值
            int maxIndex = i;
            for(int j = i; j >= 0; j --){
                if(arr[j].compareTo(arr[maxIndex]) > 0)
                    maxIndex = j;
            }

            swap2(arr, i, maxIndex);
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    private static <E> void swap2(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args){
        int[] arr = {1, 4, 2, 3, 6, 5};
        SelectionSort.sort(arr);

        for(int e: arr)
            System.out.print(e + " ");

        System.out.println();

        // Use Generic
        Integer[] arr2 = {1, 4, 2, 3, 6, 5};
        SelectionSort.sort2(arr2);
        for(int e: arr2)
            System.out.print(e + " ");
        System.out.println();

        Student[] students = {new Student("Alice", 98),
                new Student("Bobo", 100),
                new Student("Charles", 66)};
        SelectionSort.sort2(students);
        for(Student student: students)
            System.out.print(student + " ");
        System.out.println();

        int[] dataSize = {10000, 100000};
        for(int n: dataSize){
            Integer[] arr3= ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("SelectionSort", arr3);
        }

        for(int n: dataSize){
            Integer[] arr4 = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("SelectionSort3", arr4);
        }
    }
}
