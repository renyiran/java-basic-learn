package com.anthony.sort;

import java.util.Arrays;

/**
 * 快排
 */
public class QuickSort {

    /**
     * 一次排序，返回最终分割的
     *
     */
    private static int partition(int[] array, int start, int end) {
        int i = start;
        int j = end;
        int baseNum = array[start];
        while (i < j) {
            while (array[j] >= baseNum && i < j) {
                j--;
            }
            array[i] = array[j];
            while (array[i] <= baseNum && i < j) {
                i++;
            }
            array[j] = array[i];
        }
        array[j] = baseNum;
        return i;
    }

    private static void sortArray(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int index = partition(array, start, end);
        sortArray(array, start, index - 1);
        sortArray(array, index + 1, end);
    }

    private static void sortArray2(int[] array, int start, int end) {
        if (start >= end) {
            return;
        }
        int i = start;
        int j = end;
        int baseNum = array[start];
        while (i < j) {
            while (array[j] >= baseNum && i < j) {
                j--;
            }
            array[i] = array[j];
            while (array[i] <= baseNum && i < j) {
                i++;
            }
            array[j] = array[i];
        }
        array[j] = baseNum;
        sortArray2(array, start, i - 1);
        sortArray2(array, i + 1, end);

    }

    public static void main(String[] args) {
        int[] array = NeedSortedArray.initArray();
        System.out.println("origin array: " + Arrays.toString(array));
        System.out.println();
        sortArray2(array, 0, array.length - 1);
        System.out.println("sorted array: " + Arrays.toString(array));
    }

}
