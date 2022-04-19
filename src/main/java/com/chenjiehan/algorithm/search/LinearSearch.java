package com.chenjiehan.algorithm.search;

import com.chenjiehan.algorithm.utils.ArrayGenerator;

/**
 * 线性搜索
 */
public class LinearSearch {

    public static <E> int search(E[] data, E target) {
        for (int i = 0; i < data.length; i++) {
            if (data[i].equals(target)) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int n = 10000000;
        Integer[] data = ArrayGenerator.generateOrderedArray(n);

        long startTime = System.nanoTime();
        for (int i = 0; i < 100; i++) {
            LinearSearch.search(data, n);
        }
        long endTIme = System.nanoTime();

        double time = (endTIme - startTime) / 1000000000.0;
        System.out.println(time + "s");
    }
}
