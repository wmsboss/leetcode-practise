package com.max.algorithm.cource.mergesort;

import com.max.algorithm.cource.quicksort.*;

public class SortingHelper {
    private SortingHelper(){}

    public static <E extends Comparable<E>> boolean isSorted(E[] arr){

        for(int i = 1; i < arr.length; i ++) {
            if (arr[i - 1].compareTo(arr[i]) > 0) {
                return false;
            }
        }

        return true;
    }

    public static <E extends Comparable<E>> void sortTest(String sortname, E[] arr){
        long startTime = System.nanoTime();
        if(sortname.equals("SelectionSort"))
            SelectionSort.sort(arr);
        else if(sortname.equals("InsertionSort"))
            InsertionSort.sort(arr);
        else if(sortname.equals("MergeSort"))
            MergeSort.sort(arr);
        else if(sortname.equals("MergeSort2"))
            MergeSort02.sort(arr);
        else if(sortname.equals("MergeSortTrace"))
            MergeSortWithTrackInfo.sort(arr);
        else if(sortname.equals("MergeSortOptimizeSortedArray"))
            MergeSortOptimizeSortedArray.sort(arr);
        else if(sortname.equals("MergeSortOptimizeByInsertionSort"))
            MergeSortOptimizeByInsertionSort.sort(arr);
        else if(sortname.equals("MergeSortOptimizeMemory"))
            MergeSortOptimizeMemory.sort(arr);
        else if(sortname.equals("MergeSortBottomUp"))
            MergeSortBottomUp.sortBottomUp(arr);
        else if(sortname.equals("QuickSort"))
            QuickSort.sort(arr);
        else if(sortname.equals("QuickSort2"))
            QuickSort2.sort(arr);
        else if(sortname.equals("QuickSort3"))
            QuickSort3.sort(arr);
        else if(sortname.equals("QuickSort4"))
            QuickSort4.sort(arr);
        else if(sortname.equals("QuickSort2Ways"))
            QuickSortTwoWays.sort2ways(arr);
        else if(sortname.equals("QuickSort3Ways"))
            QuickSortThreeWays.sort3ways(arr);

        long endTime = System.nanoTime();

        double time = (endTime - startTime) / 1000000000.0;

        if(!SortingHelper.isSorted(arr)) {
            throw new RuntimeException(sortname + " failed");
        }

        System.out.println(String.format("%s , n = %d : %f s", sortname, arr.length, time));
    }
}
