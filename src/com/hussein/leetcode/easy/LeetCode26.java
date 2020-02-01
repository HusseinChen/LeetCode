package com.hussein.leetcode.easy;

/**
 * @Description: 给定一个排序数组，你需要在原地删除重复出现的元素，使得每个元素只出现一次，返回移除后数组的新长度。
 *
 * 不要使用额外的数组空间，你必须在原地修改输入数组并在使用 O(1) 额外空间的条件下完成。
 * @Date 2019/11/5 10:56
 */
public class LeetCode26 {

    /**
     * @Description: 双指针法-一个前指针指向不重复的最大值，一个后指针不断向后飘
     *               有一点优化思路是只在就j-i>1时将后指针的元素覆盖到前指针，减少多余操作
     * @return:
     * @Date 2019/11/5-15:58
     */
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[i] != nums[j]) {
                i++;
                if (j - i > 0) {
                    nums[i] = nums[j];
                }
            }
        }
        return i + 1;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{1,1,2};
        System.out.println(new LeetCode26().removeDuplicates(nums));
    }
}
