package com.hussein.leetcode;

import java.util.Arrays;

/**
 * @Description: 给定两个有序整数数组 nums1 和 nums2，将 nums2 合并到 nums1 中，使得 num1 成为一个有序数组。
 *
 * 说明:
 *
 * 初始化 nums1 和 nums2 的元素数量分别为 m 和 n。
 * 你可以假设 nums1 有足够的空间（空间大小大于或等于 m + n）来保存 nums2 中的元素。
 * 示例:
 *
 * 输入:
 * nums1 = [1,2,3,0,0,0], m = 3
 * nums2 = [2,5,6],       n = 3
 *
 * 输出: [1,2,2,3,5,6]
 * @author: 43138
 * @E-mail: 43138199@qq.com
 * @date: 2020/2/1
 * @time: 16:56
 * 2020/2/1 16:56 43138 create
 */
public class LeetCode88 {

    /**
     * @Description: 暴力合并排序法——双数组合并后，采用JDK的默认排序方法（JDK7之前为经典快排，JDK7之后为双基准快排）
     * @author : 43138
     * @E-mail：43138199@qq.com
     * @Date: 2020/2/1 17:00
    */
    public static void merge1(int[] nums1, int m, int[] nums2, int n) {
        System.arraycopy(nums2, 0, nums1, m, n);
        Arrays.sort(nums1);
        Arrays.stream(nums1).peek(System.out::println);
    }

    /**
     * @Description: 双指针——从前往后，从小到大
     * @author : 43138
     * @E-mail：43138199@qq.com
     * @Date: 2020/2/1 17:36
     */
    public static void merge2(int[] nums1, int m, int[] nums2, int n) {
        int[] nums1_copy = new int[m];
        System.arraycopy(nums1, 0, nums1_copy, 0, m);
        int p1 = 0;
        int p2 = 0;
        int p = 0;

        while ((p1 < m) && (p2 < n)) {
            if (nums1_copy[p1] < nums2[p2]) {
                nums1[p] = nums1_copy[p1];
                p++;
                p1++;
            } else {
                nums1[p] = nums2[p2];
                p++;
                p2++;
            }
        }
        if (p2 < n) {
            System.arraycopy(nums2, p2, nums1, p, n - p2);
        }
        if (p1 < m) {
            System.arraycopy(nums1_copy, p1, nums1, p, m - p1);
        }
    }

    /**
     * @Description: 双指针——从后往前，节省空间
     * @author : 43138
     * @E-mail：43138199@qq.com
     * @Date: 2020/2/1 17:54
     */
    public static void merge3(int[] nums1, int m, int[] nums2, int n) {
        int p1 = m - 1;
        int p2 = n - 1;
        int p = m + n-1;

        while ((p1 >= 0) && (p2 >= 0)) {
            nums1[p--] = nums1[p1] > nums2[p2] ? nums1[p1--] : nums2[p2--];
        }
        if (p2 >= 0) {
            System.arraycopy(nums2, 0, nums1, 0, p2 + 1);
        }
    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{0};
        int[] nums2 = new int[]{1};
        merge3(nums1, 0, nums2, nums2.length);
    }

}
