package com.max.algorithm.majorityelement;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by wumingshan on 2020/10/30.
 */
public class Solution {
    public int majorityElement(int[] nums) {
        Map<Integer, Integer> countMap = new HashMap<>();

        for (int num : nums) {
            if (countMap.containsKey(num)) {
                int newCount = countMap.get(num) + 1;
                if (newCount > nums.length / 2) {
                    return num;
                }

                countMap.put(num, newCount);
            } else {
                countMap.put(num, 1);
            }
        }

        return nums[0];
    }
}