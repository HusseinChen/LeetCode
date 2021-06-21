package com.hussein.leetcode.easy;

import java.util.HashMap;

/**
 * @Description: Two Sum 两数之和; difficult:easy
 * 给定一个整数数组 nums 和一个整数目标值 target，请你在该数组中找出 和为目标值 target  的那 两个 整数，并返回它们的数组下标。
 *
 * 你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
 *
 * 你可以按任意顺序返回答案。
 *
 * 示例 1：
 *
 * 输入：nums = [2,7,11,15], target = 9
 * 输出：[0,1]
 * 解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
 *
 * @Date 2019/2/15 18:20
 */
public class LeetCode1 {
    public static void main(String[] args) {
        int target = 6;
        int[] nums = {3, 3};
        int[] result = twoSum2(nums, target);
        System.out.println(result[0] + "=====" + result[1]);
    }

    /**
     * @Description: 解法一：耗时：11ms，超过73%的JAVA提交
     * @return:
     * @Date 2019/2/15-18:58
     */
    private static int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> numsMap = new HashMap<>(4);
        for (int i = 0; i < nums.length; i++) {
            numsMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int num2 = target - nums[i];
            if (numsMap.containsKey(num2) && i != numsMap.get(num2)) {
                return new int[]{i, numsMap.get(num2)};
            }
        }
        throw new IllegalArgumentException("No Two Sum Solution");
    }

    /**
     * @Description: 解法二：耗时：5ms，超过95.95%的Java提交, 边转map边判断是否存在target - item
     * @return:
     * @Date 2019/9/4-15:33
     */
    private static int[] twoSum2(int[] nums, int target) {
        HashMap<Integer, Integer> numsMap = new HashMap<>();
        numsMap.put(nums[0], 0);
        for (int i = 1; i < nums.length; i++) {
            int num2 = target - nums[i];
            if (numsMap.containsKey(num2) && i != numsMap.get(num2)) {
                return new int[]{i, numsMap.get(num2)};
            } else {
                numsMap.put(nums[i], i);
            }
        }
        throw new IllegalArgumentException("No Two Sum Solution");
    }
}
