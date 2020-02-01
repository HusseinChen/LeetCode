package com.hussein.leetcode.easy;

/**
 * @Description: 假设你正在爬楼梯，需要 n 阶你才能到达楼顶。
 *              每次你可以爬 1 或 2 个台阶，你有多少种不同的方法可以爬到楼顶呢？
 *              这道题还有Binets算法（使用到矩阵），和斐波那契数列的公式法两种解法
 * @author: 43138
 * @E-mail: 43138199@qq.com
 * @date: 2020/1/30
 * @time: 12:00
 * 2020/1/30 12:00 43138 create
 */
public class LeetCode70 {

    /**
     * @param a
     * @Description: 暴力递归法
     * @author : 43138
     * @E-mail：43138199@qq.com
     * @Date: 2020/1/30 19:58
     * @Return: 该方法理论可行，但执行太慢，在力扣上执行会超出时间限制
    */
    public static int climbStairs1(int n) {
        return climb_stairs1(0, n);
    }

    public static int climb_stairs1(int i, int n) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        return climb_stairs1(i + 1, n) + climb_stairs1(i + 2, n);
    }

//======================================================================================

    /**
     * @Description: 暴力递归法2，该方法只是暂存了一些重复调用，节省了cpu性能，以n=5为例你会发现
     *              climb_stairs1(4, 5)在这个递归中，你会执行5次，所以我们可以直接将climb_stairs(i, n)方法的结果暂存下来，后面遇到直接返回值即可
     * @author : 43138
     * @E-mail：43138199@qq.com
     * @Date: 2020/1/30 20:19
     * @Return: a
     */
    public static int climbStairs2(int n) {
        int[] memo = new int[n + 1];
        return climb_stairs2(0, n, memo);
    }

    public static int climb_stairs2(int i, int n, int[] memo) {
        if (i > n) {
            return 0;
        }
        if (i == n) {
            return 1;
        }
        if (memo[i] > 0) {
            return memo[i];
        }
        memo[i] = climb_stairs2(i + 1, n, memo) + climb_stairs2(i + 2, n, memo);
        return memo[i];
    }

//======================================================================================

    /**
     * @Description: 动态规划，即上一步的结果会影响到下一步的运算
     *              举例：走到第一阶的方法有1种，第二阶的方法有2种，走到第三阶的方法就是走上第一阶的方法数加上第二阶的方法数
     * @author: 43138
     * @E-mail：43138199@qq.com
     * @Date 2020/1/30 20:53
     */
    public static int climbStairs3(int n) {
        if (n < 3) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

//======================================================================================

    /**
     * @Description: 斐波那契数列
     * @author: 43138
     * @E-mail：43138199@qq.com
     * @Date 2020/1/30 20:57
     */
    public static int climbStairs4(int n) {
        if (n < 3) {
            return n;
        }
        int first = 1;
        int second = 2;
        for (int i = 3; i <= n; i++) {
            int third = first + second;
            first = second;
            second = third;
        }
        return second;
    }


    public static void main(String[] args) {
        System.out.println(climbStairs4(5));
    }
}
