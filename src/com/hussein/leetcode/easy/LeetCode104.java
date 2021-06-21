package com.hussein.leetcode.easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明:叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 *   /  \
 *  15   7
 * 返回它的最大深度3
 * @author: 43138
 * @E-mail: 43138199@qq.com
 * @date: 2020/2/1
 * @time: 18:23
 * 2020/2/1 18:23 43138 create
 * @version: TODO
 */
public class LeetCode104 {

    /**
     * @Description: 递归——深度优先搜索, 用时0ms 超过100%， 内存38MB 超过90.28%
     * @author : 43138
     * @E-mail：43138199@qq.com
     * @Date: 2020/2/1 18:45
     */
    public static int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        } else {
            int leftMax = maxDepth(root.left);
            int rightMax = maxDepth(root.right);
            return Math.max(leftMax, rightMax) + 1;
        }
    }

    /**
     * @Description: 递归——广度优先搜索, 用时1~2ms，内存38mb
     * @author : 43138
     * @E-mail：43138199@qq.com
     * @Date: 2020/2/1 18:45
     */
    public static int maxDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int deep = 0;
        Queue<TreeNode> treeNodeQueue = new LinkedList<>();
        treeNodeQueue.offer(root);
        while (!treeNodeQueue.isEmpty()) {
            int num = treeNodeQueue.size();
            while (num > 0) {
                TreeNode poll = treeNodeQueue.poll();
                if (null != poll.left) {
                    treeNodeQueue.offer(poll.left);
                }
                if (null != poll.right) {
                    treeNodeQueue.offer(poll.right);
                }
                num--;
            }
            deep++;
        }
        return deep;
    }

    public static void main(String[] args) {
        TreeNode treeNode1 = new TreeNode();
        treeNode1.val = 7;

        TreeNode treeNode2 = new TreeNode();
        treeNode2.val = 15;

        TreeNode treeNode3 = new TreeNode();
        treeNode3.val = 20;
        treeNode3.left = treeNode2;
        treeNode3.right = treeNode1;

        TreeNode treeNode4 = new TreeNode();
        treeNode4.val = 9;

        TreeNode treeNode5 = new TreeNode();
        treeNode5.val = 3;
        treeNode5.left = treeNode4;
        treeNode5.right = treeNode3;

        int n = maxDepth(treeNode5);
        int i = maxDepth2(treeNode5);
        System.out.println(n);
        System.out.println(i);
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }
}
