package com.max.algorithm.generateMath;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        generate(20, 1000);
    }

    public static void generate(int maxValue, int total) {
        Random random = new Random();

        int i = 0;
        while (i <= total) {
            int num1 = random.nextInt(maxValue) + 1;
            int num2 = random.nextInt(maxValue) + 1;
            int num3 = random.nextInt(maxValue) + 1;

            // a + b + c
            if (isValidResult(num1 + num2 + num3, 20)) {
                System.out.println(String.format("%d + %d + %d = (   )", num1, num2, num3));
                i++;
            } else if (isValidResult(num1 + num2, 20) && isValidResult(num1 + num2 - num3, 20)) {
                // a + b - c
                System.out.println(String.format("%d + %d - %d = (   )", num1, num2, num3));
                i++;
            } else if (isValidResult(num1 - num2, 20) && isValidResult(num1 - num2 + num3, 20)) {
                // a - b + c
                System.out.println(String.format("%d - %d + %d = (   )", num1, num2, num3));
                i++;
            } else if (isValidResult(num1 - num2, 20) && isValidResult(num1 - num2 - num3, 20)) {
                // a - b - c
                System.out.println(String.format("%d - %d - %d = (   )", num1, num2, num3));
                i++;
            }
        }
    }

    private static boolean isValidResult(int result, int maxValue) {
        return result >= 0 && result <= maxValue;
    }
}
