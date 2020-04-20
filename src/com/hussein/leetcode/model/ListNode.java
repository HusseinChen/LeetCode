package com.hussein.leetcode.model;

/**
 * @Description: 单链表节点model
 * @author: hussein
 * @E-mail：43138199@qq.com
 * @Date 2020/4/20 16:33
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode(int x) {
        val = x;
    }

    public String print() {
        StringBuilder sb = new StringBuilder(String.valueOf(this.val));
        ListNode next = this;
        while (next.next != null) {
            sb.append(next.next.val);
            next = next.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        ListNode a = new ListNode(1);
        ListNode b = new ListNode(2);
        ListNode c = new ListNode(3);
        b.next=c;
        a.next=b;
        System.out.println(a.print());
    }
}
