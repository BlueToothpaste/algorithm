package com.chenjiehan.algorithm.sort;

import com.chenjiehan.algorithm.utils.ArrayGenerator;
import com.chenjiehan.algorithm.utils.SortingHelper;

import java.util.Arrays;

/**
 * 归并排序法 复杂度O(NlogN)
 * <p>
 * 归并的过程无法原地完成
 */
public class MergeSort {

    private MergeSort() {
    }

    public static <E extends Comparable<E>> void sort(E[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static <E extends Comparable<E>> void sort(E[] arr, int l, int r) {
        if (l >= r) return;
        //避免整形越界
        int mid = l + (r - l) / 2;
        sort(arr, l, mid);
        sort(arr, mid + 1, r);
        merge(arr, l, mid, r);
    }

    //合并两个有序的区间arr[l,mid]和arr[mid+1,r]
    private static <E extends Comparable<E>> void merge(E[] arr, int l, int mid, int r) {
        //复制一个arr,用来获取原始数组的数据
        // 这里注意新的数组索引是从0开始，而原本的是从l开始，两个索引偏移量是l
        E[] tmp = Arrays.copyOfRange(arr, l, r + 1);

        int i = l, j = mid + 1;

        //每次循环为 arr[k]赋值
        for (int k = l; k <= r; k++) {
            //i超过中间，说明小的一定是j
            if (i > mid) {
                arr[k] = tmp[j - l];
                j++;
            } else if (j > r) {
                //j超过右边边界，说明小的一定是i
                arr[k] = tmp[i - l];
                i++;
            } else if (tmp[i - l].compareTo(tmp[j - l]) <= 0) {
                //i索引的数据比j索引的数据小
                arr[k] = tmp[i - l];
                i++;
            } else {
                //j索引的数据比i索引的数据小
                arr[k] = tmp[j - l];
                j++;
            }
        }
    }

    public static void main(String[] args) {
        int n = 10000000;
        final Integer[] integers = ArrayGenerator.generateRandomArray(n, n);
        SortingHelper.sortTest("MergeSort", integers);
    }
}
