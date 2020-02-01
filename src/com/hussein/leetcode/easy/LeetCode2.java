package com.hussein.leetcode.easy;

/**
 * @Description: Add Two Numbers 两数相加；diffcult：mid
 * @Date 2019/9/4 16:03
 */
public class LeetCode2 {

    static int total= 10;

    public LeetCode2() {
    }

    public static void main() {
        System.out.println("1");
    }
    public static void main(String[] args) {
        System.out.println("2");
//        int total = 10;



//        ListNode num13 = new ListNode(3);
//        ListNode num12 = new ListNode(4);
//        num12.next = num13;
//        ListNode num11 = new ListNode(2);
//        num11.next = num12;
//
//        ListNode num23 = new ListNode(5);
//        ListNode num22 = new ListNode(6);
//        num12.next = num23;
//        ListNode num21 = new ListNode(4);
//        num11.next = num22;
//
//        System.out.println("heihei");
    }

    public static void addTwoNum1(ListNode num1, ListNode num2) {
        int sum = num1.val + num2.val;
        if (sum > 10 || sum == 10) {

        }
    }

    /**
     * @Description: 数据结构定义
     * @Date 2019/9/4 16:21
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
