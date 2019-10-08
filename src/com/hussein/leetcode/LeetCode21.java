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
     * @Description: 笨方法
     * @author : hsc13668
     * @E-mail：housongchen@noahgroup.com
     * @return:
     * @Date 2019/10/8-16:43
     */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode result = new ListNode(0);
        ListNode dumnHead = result.next;
        ListNode p1 = l1;
        ListNode p2 = l2;
        while (p1.next == null && p2.next == null) {
            int compare = Integer.compare(p1.val, p2.val);
            if (compare >= 0) {
                result.next = p1;
                dumnHead = result.next;
            } else {

            }
        }
        return result.next;
    }


    public boolean marge(ListNode l1, ListNode l2) {
        return false;
    }

    /**
     * @Description: 结构
     * @author: hsc13668
     * @E-mail：housongchen@noahgroup.com
     * @Date 2019/10/8 16:34
     */
    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }
}
