package com.chenjiehan.algorithm.sort;

import com.chenjiehan.algorithm.utils.ArrayGenerator;
import com.chenjiehan.algorithm.utils.SortingHelper;

/**
 *  相比选择算法，内层for循环有跳出机制（增加了不稳定性-》比选择排序更优秀）
 *
 *  近乎有序的数组 插入排序的时间复杂度是 O(n)
 *
 *  完全倒序的数组 插入排序的时间复杂度是 O(n^2)
 */
public class InsertSort {

    private InsertSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        //循环不变量 ---   a[0...i)有序,a[i...n) 无序
        for (int i = 1; i < arr.length; i++) {
            //将arr[i]插入到合适的位置
            for (int j = i; j - 1 >= 0; j--) {
                if (arr[j].compareTo(arr[j - 1]) < 0) {
                    swap(arr, j, j - 1);
                } else {
                    break;
                }
            }
//            for (int j = i; j - 1 >= 0 && arr[j].compareTo(arr[j - 1]) < 0; j--) {
//                swap(arr, j, j - 1);
//            }
        }
    }

    public static <E extends Comparable<E>> void sort2(E[] arr) {
        //循环不变量 ---   a[0...i)有序,a[i...n) 无序
        for (int i = 0; i < arr.length; i++) {
            //将arr[i]插入到合适的位置
            //记录当前位置的数据
            E tmp = arr[i];
            int j;
            for (j = i; j - 1 >= 0 && tmp.compareTo(arr[j - 1]) < 0; j--) {
                   //比当前选的大，就把当前位置的数据改成 这个大的，减少了不必要的数据交换
                   arr[j]=arr[j-1];
            }
            arr[j] = tmp;
        }
    }


    private static <E> void swap(E[] arr, int i, int j) {
        E t = arr[i];
        arr[i] = arr[j];
        arr[j] = t;
    }

    public static void main(String[] args) {
        int[] dataSize = {10000,100000};
        for (int n : dataSize) {
            Integer[] arr = ArrayGenerator.generateRandomArray(n, n);
            SortingHelper.sortTest("InsertSort2", arr);
            Integer[] arr2 = ArrayGenerator.generateOrderedArray(n);
            SortingHelper.sortTest("InsertSort2", arr2);
        }

    }
}
