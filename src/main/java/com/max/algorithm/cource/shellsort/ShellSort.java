package com.max.algorithm.cource.shellsort;

public class ShellSort {
    private ShellSort(){}

    public static <E extends Comparable<E>> void sort(E[] data){

        int h = data.length / 2;
        while(h >= 1){
            for(int start = 0; start < h; start ++){
                // 对 data[start, start + h, start + 2h, start + 3h ...], 进行插入排序
                for(int i = start + h; i < data.length; i += h){
                    E t = data[i];
                    int j;
                    for(j = i; j - h >= 0 && t.compareTo(data[j - h]) < 0; j -= h)
                        data[j] = data[j - h];
                    data[j] = t;
                }
            }
            h /= 2;
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] data){
        int h = 1;
        while(h < data.length)
            h = 3 * h + 1;
        // 1, 4, 13, 40 ...
        while(h >= 1){
            for(int i = h; i < data.length; i ++){
                E t = data[i];
                int j;
                for(j = i; j - h >= 0 && t.compareTo(data[j - h]) < 0; j -= h)
                    data[j] = data[j - h];
                data[j] = t;
            }

            h /= 3;
        }
    }
}
