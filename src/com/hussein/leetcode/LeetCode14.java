package com.hussein.leetcode;

/**
 * @Description: 编写一个函数来查找字符串数组中的最长公共前缀。
                如果不存在公共前缀，返回空字符串 ""。
 * @author: hsc13668
 * @E-mail：housongchen@noahgroup.com
 * @Date 2019/9/23 15:52
 */
public class LeetCode14 {

    /**
     * @Description: 算法一：水平扫描，按顺序查找公共前缀，用查找到的公共前缀查找与下一个元素的公共前缀
     * @author : hsc13668
     * @E-mail：housongchen@noahgroup.com
     * @return:
     * @Date 2019/9/24-10:22
     */
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length ==0) {
            return "";
        }
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) {
                    return "";
                }
            }
        }
        return prefix;
    }

    /**
     * @Description: 算法二：双循环，第一层循环字符串长度，第二层循环strs长度，单个字符去比较
     * @author : hsc13668
     * @E-mail：housongchen@noahgroup.com
     * @return: 
     * @Date 2019/9/24-10:29
     */
    private static String longestCommonPrefix2(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        for (int i = 0; i < strs[0].length(); i++) {
            char index = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (i == strs[j].length() || index != strs[j].charAt(i)) {
                    return strs[0].substring(0, i);
                }
            }
        }
        return strs[0];
    }

    /**
     * @Description: 算法三：分治算法，基本思想，把一个大问题拆为多个子问题，通过子问题的解再来求解
     *                      基本原则：子问题需相互独立且与原问题性质相同
     * @author : hsc13668
     * @E-mail：housongchen@noahgroup.com
     * @return:
     * @Date 2019/9/26-13:56
     */
    public static String longestCommonPrefix3(String[] strs) {
        if (0 != strs.length) {
            return longestCommonPrefix3(strs, 0, strs.length - 1);
        }
        return "";
    }

    private static String longestCommonPrefix3(String[] strs, int left, int right) {
        if (left == right) {
            return strs[left];
        } else {
            int mid = (left + right) / 2;
            String leftLcp = longestCommonPrefix3(strs, left, mid);
            String rightLcp = longestCommonPrefix3(strs, mid + 1, right);
            return  longestCommonPrefix3(leftLcp, rightLcp);
        }
    }
    
    private static String longestCommonPrefix3(String leftLcp, String rightLcp) {
        int min = leftLcp.length() < rightLcp.length() ? leftLcp.length() : rightLcp.length();
        for (int i = 0; i < min; i++) {
            if (leftLcp.charAt(i) != rightLcp.charAt(i)) {
                return leftLcp.substring(0, i);
            }
        }
        return leftLcp.substring(0, min);
    }

    /**
     * @Description: 算法四：二分查找
     * @author : hsc13668
     * @E-mail：housongchen@noahgroup.com
     * @return:
     * @Date 2019/9/26-15:13
     */
    private static String longestCommonPrefix4(String[] strs) {
        if (null == strs || 0 == strs.length) {
            return "";
        }
        // @Description: 最小长度 hsc13668
        // @Description: 这里其实可以不用查最小长度直接用第一个元素的长度来遍历，但只有当长度maxLen - minLen < 个数n时，效率会提升
        //               也就是说，n足够大的时候才应该选择直接使用第一个元素来遍历 hsc13668
        int minLen = Integer.MAX_VALUE;
        for (String str : strs) {
            minLen = Math.min(minLen, str.length());
        }
        int low = 1;
        int high = minLen;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (longestCommonPrefix4(strs, mid)) {
                low = mid + 1;
            } else {
                high = mid -1;
            }
        }
        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean longestCommonPrefix4(String[] strs, int mid) {
        String prefix = strs[0].substring(0, mid);
        for (String str : strs) {
            if (str.indexOf(prefix) != 0) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] strs = new String[]{""};
        System.out.println(longestCommonPrefix4(strs));
    }
}
