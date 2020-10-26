package com.max.algorithm.buildAnArrayWithStackOperations;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by wumingshan on 2020/10/26.
 */
class Solution {
    public List<String> buildArray(int[] target, int n) {
        List<String> resultList = new ArrayList<>();

        int index = 0;
        for (int i = 0; i < n; i++) {
            resultList.add("Push");

            if (target[index] != i + 1) {
                resultList.add("Pop");
                continue;
            }

            if (target.length == index + 1) {
                break;
            }

            index++;
        }

        return resultList;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().buildArray(new int[]{2, 3, 4}, 4));
    }
}
