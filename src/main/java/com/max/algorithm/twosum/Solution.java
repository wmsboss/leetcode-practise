package com.max.algorithm.twosum;

class Solution {
    public static void main(String[] args) {
        int[] nums = new int[] {-3,4,3,90};
        int target = 0;

        int [] result = new Solution().twoSum(nums, target);
        System.out.println(result[0]);
        System.out.println(result[1]);
    }

    public int[] twoSum(int[] nums, int target) {
        for (int i = 0; i < nums.length - 1; i ++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[]{i, j};
                }
            }
        }

        return new int[0];
    }
}
