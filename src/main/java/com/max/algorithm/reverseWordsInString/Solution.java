package com.max.algorithm.reverseWordsInString;


/**
 * Created by wumingshan on 2020/10/27.
 */
class Solution {
    public String reverseWords(String s) {
        if (s == null) {
            return null;
        }

        char[] charArray = s.toCharArray();
        int size = charArray.length;

        // 翻转这个数组
        reverse(charArray, 0, size - 1);
        System.out.println(new String(charArray));

        // 翻转每个单词
        reverseWord(charArray, size);
        System.out.println(new String(charArray));

        // 去除多余空格
        return cleanSpace(charArray, size);
    }

    private void reverse(char[] charArray, int i, int j) {
        while (i < j) {
            char t = charArray[i];
            charArray[i++] = charArray[j];
            charArray[j--] = t;
        }
    }

    private void reverseWord(char[] charArray, int n) {
        int i = 0;
        int j = 0;
        while (j < n) {
            // 找到第一个首字母
            while (i < n && charArray[i] == ' ') i++;

            j = i;
            // 末位置
            while (j < n && charArray[j] != ' ') {
                j++;
            }

            reverse(charArray, i, j - 1);
            i = j;
        }
    }

    private String cleanSpace(char[] charArray, int n) {
        int i = 0;
        int j = 0;
        while (j < n) {
            while (j < n && charArray[j] == ' ') j++;
            while (j < n && charArray[j] != ' ') charArray[i++] = charArray[j++];
            while (j < n && charArray[j] == ' ') j++;
            if (j < n) charArray[i++] = ' ';
        }

        return new String(charArray).substring(0, i);
    }
}
