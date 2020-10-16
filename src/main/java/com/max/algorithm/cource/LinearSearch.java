package com.max.algorithm.cource;

import com.max.algorithm.cource.pojo.Student;
import com.max.algorithm.cource.util.ArrayGenerator;

public class LinearSearch {
    public static int search(int [] data, int target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i] == target) {
                return i;
            }
        }

        return -1;
    }

    public static <E> int search2(E [] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }

        return -1;
    }

    public static void main(String[] args) {
        // Test int
        int[] data = {24, 18, 12, 9, 16, 66, 32, 4};

        int res = LinearSearch.search(data, 16);
        System.out.println(res);

        int res2 = LinearSearch.search(data, 666);
        System.out.println(res2);

        // Test Integer
        Integer[] data2 = {24, 18, 12, 9, 16, 66, 32, 4};

        res = LinearSearch.search2(data2, 16);
        System.out.println(res);

        res2 = LinearSearch.search2(data2, 666);
        System.out.println(res2);

        // Test Student
        Student[] students = {new Student("Alice"),
                new Student("Bobo"),
                new Student("Charles")};
        Student bobo = new Student("Bobo");

        int res3 = LinearSearch.search2(students, bobo);

        System.out.println(res3);

        int[] dataSize = {1000000, 10000000};
        for(int n: dataSize) {
            Integer[] data3 = ArrayGenerator.generateOrderedArray(n);

            long startTime = System.nanoTime();
            for (int k = 0; k < 100; k++)
                LinearSearch.search2(data3, n);
            long endTime = System.nanoTime();

            double time = (endTime - startTime) / 1000000000.0;
            System.out.println("n = " + n + ", 100 runs : " + time + "s");
        }
    }
}
