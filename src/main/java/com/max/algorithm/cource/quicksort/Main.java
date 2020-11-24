package com.max.algorithm.cource.quicksort;

import com.max.algorithm.cource.mergesort.ArrayGenerator;

public class Main {
    public static void main(String[] args) {
        for (Integer item : ArrayGenerator.generateSpecialArray(5)) {
            System.out.print(item + " ");
        }
    }
}
