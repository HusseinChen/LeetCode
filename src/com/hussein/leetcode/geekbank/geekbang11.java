package com.hussein.leetcode.geekbank;

public class geekbang11 {

    /**
     * @Description: 冒泡排序
     * @author : hsc13668
     * @return:
     * @Date 2020/4/23-15:20
     */
    public static int[] bubbleSort(int[] array) {
        int length = array.length;
        if (length < 2) {
            return array;
        }
        for (int i = 0; i < length; i++) {
            String a = "";
            for (int num : array) {
                a = a + num;
            }
            System.out.println(a);
            boolean hasChange = false;
            for (int j = 0; j < length - i -1; j++) {
                if (array[j] > array[j+1]) {
                    int tmp = array[j+1];
                    array[j+1] = array[j];
                    array[j] = tmp;
                    hasChange = true;
                }
            }
            if (!hasChange) {
                break;
            }
        }
        return array;
    }

    /**
     * @author : hsc13668
     * @return:
     * @Date 2020/4/29-15:02
     */
    public static int[] insertSort(int[] array) {
        if (array.length <= 1) {
            return array;
        }
        for (int i = 1; i < array.length; ++i) {
            int value = array[i];

        }
        return null;
    }

    public static void main(String[] args) {
        int[] array = new int[]{4,5,3,6,1,1};
        int[] bubbleSort = bubbleSort(array);
        System.out.println(bubbleSort.toString());
    }
}
