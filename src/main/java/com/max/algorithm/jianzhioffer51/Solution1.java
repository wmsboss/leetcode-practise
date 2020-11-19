package com.max.algorithm.jianzhioffer51;

public class Solution1 {
    public int reversePairs(int[] nums) {
        int res = 0;
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] > nums[j]) {
                    res ++;
                }
            }
        }
        return res;
    }
}
