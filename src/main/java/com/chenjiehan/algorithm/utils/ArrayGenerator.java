package com.chenjiehan.algorithm.utils;

import lombok.Data;

@Data
public class ArrayGenerator {

    public static Integer[] generatorOrderedArray(int n) {
        Integer[] integers = new Integer[n];
        for (int i = 0; i < n; i++) {
            integers[i] = i;
        }
        return integers;
    }
}
