package com.max.algorithm.cource.binarysearch;

public class BinarySearch3 {
    private BinarySearch3() {

    }

    public static <E extends Comparable<E>> int search(E[] data, E target) {
        int l = 0, r = data.length;

        // 在data[l, r]的范围中查找target
        while (l < r) {
            int mid = l + (r - l) / 2;

            if (data[mid].compareTo(target) == 0) {
                return mid;
            }

            if (data[mid].compareTo(target) < 0) {
                l = mid + 1;
            } else {
                r = mid;
            }
        }

        return -1;
    }

}
