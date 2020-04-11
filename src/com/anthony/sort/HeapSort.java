package com.anthony.sort;

import java.util.Arrays;

public class HeapSort {

    private static void sortArray(int[] arr) {
        if (arr.length <= 1) {
            return;
        }
        //创建堆
        //并没有真正的创建堆 而是一个逻辑堆   0为根节点  1、2 第一层   3、4、5、6第二层  以此类推
        //从倒数第二层开始调整 起始序号为(arr.length - 2) / 2
        for (int i = (arr.length - 2) / 2; i >= 0; i--) {
            //从第一个非叶子结点从下至上，从右至左调整结构
            adjustHeap(arr, i, arr.length);
        }

        //调整堆结构+交换堆顶元素与末尾元素
        for (int i = arr.length - 1; i > 0; i--) {
            //将堆顶元素与末尾元素进行交换
            int temp = arr[i];
            arr[i] = arr[0];
            arr[0] = temp;

            //重新对堆进行调整
            adjustHeap(arr, 0, i);
        }
    }

    /**
     * 调整堆
     *
     * @param arr    待排序列
     * @param parent 父节点
     * @param length 待排序列尾元素索引
     */
    private static void adjustHeap(int[] arr, int parent, int length) {
        //将temp作为父节点
        int temp = arr[parent];
        //左孩子
        int lChild = 2 * parent + 1;

        while (lChild < length) {
            //右孩子
            int rChild = lChild + 1;
            // 如果有右孩子结点，子并且右孩子结点的值大于左孩结点，则选取右孩子结点
            if (rChild < length && arr[lChild] < arr[rChild]) {
                lChild++;
            }

            // 如果父结点的值已经大于孩子结点的值，则直接结束
            if (temp >= arr[lChild]) {
                break;
            }

            // 把孩子结点的值赋给父结点
            arr[parent] = arr[lChild];

            //选取交换数据的子结点,继续向下调整
            parent = lChild;
            lChild = 2 * lChild + 1;
        }
        arr[parent] = temp;
    }


    public static void main(String[] args) {
        int[] array = NeedSortedArray.initArray();
        System.out.println("origin array: " + Arrays.toString(array));
        System.out.println();
        sortArray(array);
        System.out.println("sorted array: " + Arrays.toString(array));
    }
}
