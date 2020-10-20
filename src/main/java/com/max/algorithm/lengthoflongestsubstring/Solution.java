package com.max.algorithm.lengthoflongestsubstring;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public static void main(String[] args) {
        System.out.println(new Solution().lengthOfLongestSubstring(" "));
    }

    public int lengthOfLongestSubstring(String s) {
        char [] charArray = s.toCharArray();
        List<Character> list = new ArrayList<>();
        int result = 0;

        for (char c : charArray) {
            if (list.contains(c)) {
                do {
                    list.remove(0);
                } while (list.contains(c));
            }

            list.add(c);

            if (list.size() > result) {
                result = list.size();
            }
        }

        return result;
    }
}
