package com.hussein.leetcode.geekbank;

import com.hussein.leetcode.model.ListNode;

/**
 * @Description: 一个用链表保存的字符串，判断其是否为回文字符串
 * @author: hussein
 * @E-mail：
 * @Date 2020/4/20 16:35
 */
public class geekbank06 {

    public static boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        ListNode next = null;

        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            next = slow.next;
            slow.next = prev;
            prev = slow;
            slow = next;
        }
        if (fast != null) {
            // @Description: fast!=null代表奇数 hsc13668
            slow = slow.next;
        }
        while (slow.next != null) {
            if (slow.val != prev.val) {
                return false;
            }
            slow = slow.next;
            prev = prev.next;
        }

        return true;
    }

    /**
     * @Description: 链表反转
     * @author : hsc13668
     * @return:
     * @Date 2020/4/20-20:13
     */
    public static String linkedReverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        ListNode nextp = null;
        while (curr != null) {
            nextp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextp;
        }
        return prev.print();
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        ListNode d = new ListNode(4);
        c.next = d;
        b.next = c;
        a.next = b;
//        isPalindrome(a);
        linkedReverse(a);
    }
}
