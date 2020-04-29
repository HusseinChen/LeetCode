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

        // @Description: 处理边界值 Hussein
        if (array[low] > value || array[high] < value) {
            return 99999;
        }

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

    /**
     * @param a 目标数组
     * @param n 数组长度
     * @param value 给定值
     * @Description: 查找第一个大于等于给定值的元素
     * @author : Hussein
     * @return: 给定值下标
     * @Date 2020/4/29-15:21
     */
    private static int bsearch2(int[] a, int n, int value) {
        int low = 0, high = n - 1;
        int mid = 0;
        while (low <= high) {
            mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                if (mid == 0 || a[mid -1] < value) {
                    return mid;
                } else {
                 high = mid - 1;
                }
            } else {
                low = mid + 1;
            }
        }
        return low;
    }


    public int bsearch3(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        // @Description: 处理边界值 Hussein
        if (a[low] > value || a[high] < value) {
            return 99999;
        }

        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (a[mid] >= value) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        if (low < n && a[low]==value) {
            return low;
        } else {
            return -1;
        }
    }

    public static void main(String[] args) {
        int[] array = new int[]{0,1,2,3,4,4,5,8,9};
        int index1 = bsearch(array, array.length, 10);
//        int index2 = bsearch2(array, array.length, 5);
        System.out.println(index1);
    }
}
