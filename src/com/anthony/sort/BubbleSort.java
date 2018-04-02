package com.anthony.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {
    private static void sortArray(int[] array) {
        int temp;
        for (int i = 1; i < array.length; i++) {
            for (int j = 0; j < array.length - i; j++) {
                if (array[j] > array[j+1]) {
                    temp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = temp;
                }
            }
        }

    }

    public static void main(String[] args) {
        int[] array = NeedSortedArray.initArray();
        System.out.println("origin array: " + Arrays.toString(array));
        System.out.println();
        sortArray(array);
        System.out.println("sorted array: " + Arrays.toString(array));
    }
}
