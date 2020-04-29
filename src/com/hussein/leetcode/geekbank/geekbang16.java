package com.hussein.leetcode.geekbank;

/**
 * @Description: 二分查找变形
 * @author: hsc13668
 * @Date 2020/4/29 15:03
 */
public class geekbang16 {

    /**
     * @param array 目标数组
     * @param n 目标数组长度
     * @param value 目标值
     * @Description: 查找最后一个等于目标值的元素
     * @author : hsc13668
     * @return: 目标值下标
     * @Date 2020/4/29-15:05
     */
    private static int bsearch(int[] array, int n, int value) {
        int low = 0, high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (array[mid] > value) {
               high = mid -1;
            } else if (array[mid] < value) {
                low = mid + 1;
            } else {
                if (mid == n - 1 || array[mid + 1] > value) {
                    return mid;
                } else {
                    low = mid +1;
                }
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] array = new int[]{0,1,2,3,4,4,4,8,9};
        int index = bsearch(array, array.length, 4);
        System.out.println(index);
    }
}
