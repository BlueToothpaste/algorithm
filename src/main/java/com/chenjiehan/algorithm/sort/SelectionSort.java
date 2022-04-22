package com.chenjiehan.algorithm.sort;

import com.chenjiehan.algorithm.entity.Student;
import com.chenjiehan.algorithm.utils.ArrayGenerator;
import com.chenjiehan.algorithm.utils.SortingHelper;

/**
 * 选择排序 复杂度永远是 O(n^2)
 * <p>
 * 总的来说，记住循环不变量 -------> 保证 arr[0...i) 是有序的，arr[i....n)是无序的
 * 一直找出arr[i....n)内最小的数，放在i的位置 （跟无序的数组比较）
 */
public class SelectionSort {

    private SelectionSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        // arr[0...i) 是有序的，arr[i....n)是无序的 -->循环不变量
        for (int i = 0; i < arr.length; i++) {
            // 选择 arr[i...n)中的最小值所对应的索引
            int minIndex = i;
            for (int j = i; j < arr.length; j++) {
                //arr[i....n)是无序的
                if (arr[j].compareTo(arr[minIndex]) < 0)
                    minIndex = j;
            }
            swap(arr, i, minIndex);
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        //arr[i....n)已排序的, arr[0...i) 未排序的 -->循环不变量
        for (int i = arr.length - 1; i >= 0; i--) {
            // 选中的最大值所对应的索引
            int maxIndex = i;
            for (int j = i; j >= 0; j--) {
                if (arr[j].compareTo(arr[maxIndex]) > 0)
                    maxIndex = j;
            }
            swap(arr, i, maxIndex);
        }
    }


    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
//        Integer[] arr = {1, 4, 2, 3, 6, 5};
        int[] dataSize = {10000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
//            SortingHelper.sortTest("SelectionSort", arr);
            SortingHelper.sortTest("SelectionSort2", arr);
        }
//        Student[] students = {new Student("Alice", 98),
//                new Student("Bobo", 100),
//                new Student("Charles", 99)};
//        SelectionSort.sort(students);
//        for (Student student : students) {
//            System.out.println(student);
//        }
    }


}
