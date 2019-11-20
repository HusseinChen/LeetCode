package com.hussein.leetcode;

/**
 * @Description: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *               输入: [-2,1,-3,4,-1,2,1,-5,4],
                 输出: 6
                 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * @author: hsc13668
 * @E-mail：housongchen@noahgroup.com
 * @Date 2019/11/5 16:45
 */
public class LeetCode53 {

    /**
     * @Description: 动态规划-即上一状态会影响到下一状态，最终得到一个最优解
     * 这里dp数组每个元素存储的是上一状态产生的元素和，上一状态的元素和会影响到下一步，标准动态规划
     *
     * @author : hsc13668
     * @E-mail：housongchen@noahgroup.com
     * @return:
     * @Date 2019/11/5-16:47
     */
    public static int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i- 1] + nums[i], nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        maxSubArray1(nums);
    }
}
