package com.hussein.leetcode;

/**
 * @Description: 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的
 *      输入：1->2->4, 1->3->4
        输出：1->1->2->3->4->4
 * @author: hsc13668
 * @E-mail：housongchen@noahgroup.com
 * @Date 2019/10/8 16:34
 */
public class LeetCode21 {

    /**
     * @Description: 笨方法（迭代法）-设立一个目标链，通过一个哑节点来漂移，比较目标链最后一个节点的大小后入链
     * @author : hsc13668
     * @E-mail：housongchen@noahgroup.com
     * @return:
     * @Date 2019/10/8-16:43
     */
    public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode dumnHead = result;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1 != null || p2 != null) {
            if (null == p1) {
                dumnHead.next = p2;
                break;
            }
            if (null == p2) {
                dumnHead.next = p1;
                break;
            }
            int compare = Integer.compare(p1.val, p2.val);
            if (compare < 0) {
                dumnHead.next = p1;
                dumnHead = dumnHead.next;
                p1 = p1.next;
            } else {
                dumnHead.next = p2;
                dumnHead = dumnHead.next;
                p2 = p2.next;
            }
        }
        return result.next;
    }

    /**
     * @Description: 迭代法（优化）-其实不需要创建临时链来防止链表顺序打乱
     * @author : hsc13668
     * @E-mail：housongchen@noahgroup.com
     * @return:
     * @Date 2019/11/4-14:13
     */
    public static ListNode mergeTwoLists3(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode dumnHead = result;
        while (l1 != null && l2 != null) {
            int compare = Integer.compare(l1.val, l2.val);
            if (compare < 0) {
                dumnHead.next = l1;
                l1 = l1.next;
            } else {
                dumnHead.next = l2;
                l2 = l2.next;
            }
            dumnHead = dumnHead.next;
        }
        dumnHead.next = l1 == null ? l2 : l1;
        return result.next;
    }

    /**
     * @Description: 递归法
     * @author : hsc13668
     * @E-mail：housongchen@noahgroup.com
     * @return:
     * @Date 2019/11/1-13:50
     */
    public static ListNode mergeTwoLists2(ListNode l1, ListNode l2) {
        if (null == l1) {
            return l2;
        }
        if (null == l2) {
            return l1;
        }
        if (l1.val < l2.val) {
            l1.next = mergeTwoLists2(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists2(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        ListNode num13 = new ListNode(4);
        ListNode num12 = new ListNode(7);
        ListNode num11 = new ListNode(4);
        num12.next = num13;
        num11.next = num12;

        ListNode num23 = new ListNode(6);
        ListNode num22 = new ListNode(5);
        ListNode num21 = new ListNode(4);
        num22.next = num23;
        num21.next = num22;

        mergeTwoLists2(num11, num21);
    }

    /**
     * @Description: 结构
     * @author: hsc13668
     * @E-mail：housongchen@noahgroup.com
     * @Date 2019/10/8 16:34
     */
    public static class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
