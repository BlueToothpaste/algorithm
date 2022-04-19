package com.chenjiehan.algorithm.utils;

import lombok.Data;

import java.util.Random;

@Data
public class ArrayGenerator {

    public static Integer[] generateOrderedArray(int n) {
        Integer[] integers = new Integer[n];
        for (int i = 0; i < n; i++) {
            integers[i] = i;
        }
        return integers;
    }

    public static Integer[] generateRandomArray(int n, int bound) {
        Integer[] integers = new Integer[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            integers[i] = random.nextInt(bound);
        }
        return integers;
    }
}
