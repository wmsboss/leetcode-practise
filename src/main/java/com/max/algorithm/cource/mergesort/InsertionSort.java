package com.max.algorithm.cource.mergesort;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InsertionSort {
    private InsertionSort(){
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        for(int i = 0; i < arr.length; i ++){
            // 将 arr[i] 插入到合适的位置
            E t = arr[i];
            int j;
            for(j = i; j - 1 >= 0 && t.compareTo(arr[j - 1]) < 0; j --) {
                arr[j] = arr[j - 1];
            }

            arr[j] = t;
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr, int l, int r){
        for(int i = l; i <= r; i ++){

            // 将 arr[i] 插入到合适的位置
            E t = arr[i];
            int j;
            for(j = i; j - 1 >= l && t.compareTo(arr[j - 1]) < 0; j --){
                arr[j] = arr[j - 1];
            }
            arr[j] = t;
        }
    }

    public static void main(String[] args) {

    }

}


