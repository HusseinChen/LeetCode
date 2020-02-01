package com.hussein.leetcode.easy;

/**
 * @Description: 给定一个整数数组 nums ，找到一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 *               输入: [-2,1,-3,4,-1,2,1,-5,4],
                 输出: 6
                 解释: 连续子数组 [4,-1,2,1] 的和最大，为 6。
 * @Date 2019/11/5 16:45
 */
public class LeetCode53 {

    /**
     * @Description: 动态规划-即上一状态会影响到下一状态，最终得到一个最优解
     * 这里dp数组每个元素存储的是上一状态产生的元素和，上一状态的元素和会影响到下一步，标准动态规划
     *
     * @return:
     * @Date 2019/11/5-16:47
     */
    public static int maxSubArray1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            // @Description: 说白了就是加上第i个元素的和还没i元素本身大，所以应该从i元素开始继续计算
            // 如果和比元素本身要大，那么证明之前有元素对和起到了增益效果，我们还应该以之前的元素开始的那个和计算 12:07 43138
            dp[i] = Math.max(dp[i- 1] + nums[i], nums[i]);
            if (max < dp[i]) {
                max = dp[i];
            }
        }
        return max;
    }

    /**
     * @param a
     * @Description: 动态规划2，空间复杂度会小很多，因为这个方法是直接在原数组上修改的，没有占用额外空间
     *              只有一个额外的maxSum对象
     * @author : 43138
     * @E-mail：43138199@qq.com
     * @Date: 2020/1/30 11:51
     * @Return: a
    */
    public static int maxSubArray2(int[] nums) {
        int maxSum = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (nums[i - 1] > 0) {
                nums[i] += nums[i - 1];
            }
            maxSum = Math.max(nums[i], maxSum);
        }
        return maxSum;
    }

    /**
     * @param a
     * @Description: 只写了动态规划算法，但其实还有贪心算法和分治法
     *              贪心算法其实和动态规划很像，我每一步都算，但只取最优解
     *              分治法有点难理解，在此省略
     * @author : 43138
     * @E-mail：43138199@qq.com
     * @Date: 2020/1/30 11:37
     * @Return: a
    */
    public static void main(String[] args) {
        int[] nums = new int[]{-2,1,-3,4,-1,2,1,-5,4};
        System.out.println(maxSubArray1(nums));
    }
}
