package com.hussein.leetcode.easy;

/**
 * @Description: Add Two Numbers 两数相加；diffcult：mid
 *
 * 给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。
 *
 * 请你将两个数相加，并以相同形式返回一个表示和的链表。
 *
 * 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。
 *
 * 输入：l1 = [2,4,3], l2 = [5,6,4]
 * 输出：[7,0,8]
 * 解释：342 + 465 = 807
 *
 * @Date 2019/9/4 16:03
 */
public class LeetCode2 {

    public LeetCode2() {
    }

    public static void main(String[] args) {
        ListNode num13 = new ListNode(3);
        ListNode num12 = new ListNode(4);
        num12.next = num13;
        ListNode num11 = new ListNode(2);
        num11.next = num12;

        ListNode num24 = new ListNode(7);
        ListNode num23 = new ListNode(4);
        num23.next = num24;
        ListNode num22 = new ListNode(6);
        num22.next = num23;
        ListNode num21 = new ListNode(5);
        num21.next = num22;

        ListNode listNode = addTwoNum1(num11, num21);
        ListNode next = listNode;
        while (null != next) {
            System.out.println(next.val);
            next = next.next;
        }
    }

    /**
     * 递归调用，难点在处理好边界，执行用时：2ms 超过100%，内存消耗38.4mb 超过89.05%
     *
     * @param
     * @return
     */
    public static ListNode addTwoNum1(ListNode node1, ListNode node2) {
        ListNode target = new ListNode();
        addTwoNum11(node1, node2, target, false);
        return target.next;
    }

    private static void addTwoNum11(ListNode node1, ListNode node2, ListNode target, boolean add) {
        int num1 = 0;
        int num2 = 0;
        ListNode next1 = null;
        ListNode next2 = null;
        if (null != node1) {
            num1 = node1.val;
            next1 = node1.next;
        }
        if (null != node2) {
            num2 = node2.val;
            next2 = node2.next;
        }
        if (null == node1 && null == node2) {
            if (add) {
                target.next = new ListNode(1);
            }
            return;
        }

        int sum = num1 + num2;
        if (add) {
            sum++;
        }

        ListNode node = new ListNode();

        if (sum > 10 || sum == 10) {
            node.val = sum % 10;
            add = true;
        } else {
            node.val = sum;
            add = false;
        }
        target.next = node;

        addTwoNum11(next1, next2, target.next, add);
    }

    /**
     * @Description: 数据结构定义
     * @Date 2019/9/4 16:21
     */
    public static class ListNode {
        int val;
        ListNode next;

        public ListNode() {
        }

        public ListNode(int val) {
            this.val = val;
        }
    }
}
