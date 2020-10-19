package com.max.algorithm.backspacecompare;

import java.util.Stack;

public class Solution {

    public static void main(String[] args) {
        System.out.println(new Solution().backspaceCompare("ab#c", "ad#c"));
    }

    public boolean backspaceCompare(String S, String T) {
        String value1 = getRealValue(S);
        String value2 = getRealValue(T);

        return value1.equals(value2);
    }

    public String getRealValue(String inputValue) {
        Stack<Character> stack = new Stack<>();

        char[] data = inputValue.toCharArray();
        for (char item : data) {
            if (item == '#') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
                continue;
            }

            stack.push(item);
        }

        StringBuilder result = new StringBuilder();
        for (Character item : stack) {
            result.append(item);
        }

        return result.toString();
    }
}
