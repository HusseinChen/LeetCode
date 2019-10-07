package com.hussein.leetcode;

/**
 * @Description: 判断一个整数是否是回文数。回文数是指正序（从左向右）和倒序（从右向左）读都是一样的整数。
 * example:
 * 示例 1:
        输入: 121
        输出: true
   示例 2:

        输入: -121
        输出: false
        解释: 从左向右读, 为 -121 。 从右向左读, 为 121- 。因此它不是一个回文数。
 * @author: hsc13668
 * @E-mail：housongchen@noahgroup.com
 * @Date 2019/9/23 15:09
 */
public class LeetCode9 {

    /**
     * @Description: 整数反转后比较大小
     * @author : hsc13668
     * @E-mail：housongchen@noahgroup.com
     * @return:
     * @Date 2019/9/23-15:17
     */
    public static boolean isPalindrome(int x) {
        if (x < 0) {
            return false;
        }
        if (0 == x % 10 && 0 != x) {
            return false;
        }
        int target = 0;
        int origin = x;
        while (x != 0) {
            int pop = x % 10;
            target = target * 10 + pop;
            x /= 10;
        }
        return target == origin;
    }

    /**
     * @Description: 官方解：只反转一半数字，比较反转一半后的数字
     * @author : hsc13668
     * @E-mail：housongchen@noahgroup.com
     * @return:
     * @Date 2019/9/23-15:32
     */
    public static boolean isPalindrome2(int x) {
        if (x < 0 || (0 == x % 10 && 0 != x)) {
            return false;
        }
        int reversedNum = 0;
        while (x > reversedNum) {
            reversedNum = reversedNum * 10 + x % 10;
            x /= 10;
        }
        return x == reversedNum || x == reversedNum / 10;
    }

    public static void main(String[] args) {
//        System.out.println(isPalindrome(111));
        System.out.println(isPalindrome2(123321));
    }
}
