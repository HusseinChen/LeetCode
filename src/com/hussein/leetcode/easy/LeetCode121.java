package com.hussein.leetcode.easy;

/**
 * @Description:
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 *
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 *
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回0。
 *
 * 示例 1：
 * 输入：[7,1,5,3,6,4]
 * 输出：5
 * 解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
 *      注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
 *
 * 示例 2：
 * 输入：prices = [7,6,4,3,1]
 * 输出：0
 * 解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
 *
 * 提示：
 *     1 <= prices.length <= 105
 *     0 <= prices[i] <= 104
 *
 * @author: Hussein
 * @Date 2021/6/8 17:01
 */
public class LeetCode121 {

    /**
     * @Description: 类似双指针法，A指针找最小值，B指针找最大值
     * @author : Hussein
     * @return:
     * @Date 2021/6/8-17:05
     */
    public static int myselfMaxProfit(int[] prices) {
        int min = prices[0];
        int max = prices[0];

        if (prices.length < 2) {
            return 0;
        }

        int profit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > max) {
                max = prices[i];
                int temp = prices[i] - min;
                if (temp > profit) {
                    profit = temp;
                }
            }
            if (prices[i] < min) {
                min = prices[i];
                max = prices[i];
            }
        }
        return profit;
    }

    /**
     * @Description: 官方解法，与我的方法基本一致
     * @author : Hussein
     * @return:
     * @Date 2021/6/8-17:05
     */
    public static int maxProfit1(int[] prices) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice) {
                minprice = prices[i];
            } else if (prices[i] - minprice > maxprofit) {
                maxprofit = prices[i] - minprice;
            }
        }
        return maxprofit;
    }

    /**
     * @Description: 动态规划法1
     * @author : Hussein
     * @return:
     * @Date 2021/6/8-19:46
     */
    public static int maxProfitDynamic1(int[] prices) {
        if (2 > prices.length) {
            return 0;
        }

        int[][] profit = new int[prices.length][2];
        profit[0][0] = 0;
        profit[0][1] = -prices[0];

        for (int i = 1; i < prices.length; i++) {
            profit[i][0] = Math.max(profit[i - 1][0], profit[i - 1][1] + prices[i]);
            profit[i][1] = Math.max(-prices[i], profit[i-1][1]);
        }
        return profit[profit.length - 1][0];
    }

    public static void main(String[] args) {
        int[] prices = new int[]{7,1,5,3,6,4};
        int profit = maxProfitDynamic1(prices);
        System.out.println(profit);
    }
}
