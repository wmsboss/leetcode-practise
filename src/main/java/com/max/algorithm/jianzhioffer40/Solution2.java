package com.max.algorithm.jianzhioffer40;

import java.util.Arrays;

public class Solution2 {
    public int[] smallestK(int[] arr, int k) {

        Arrays.sort(arr);
        return Arrays.copyOf(arr, k);
    }
}
