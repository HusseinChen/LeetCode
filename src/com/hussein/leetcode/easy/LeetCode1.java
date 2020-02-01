package com.hussein.leetcode.easy;

import java.util.HashMap;

/**
 * @Description: Two Sum 两数之和; difficult:easy
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
     * @Description: 解法二：耗时：5ms，超过95.95%的Java提交
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
