package com.hussein.leetcode.easy;

/**
 * @Description: 给定一个二叉树，找出其最大深度。
 * <p>
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * <p>
 * 说明: 叶子节点是指没有子节点的节点。
 * <p>
 * 示例：
 * 给定二叉树 [3,9,20,null,null,15,7]，
 * <p>
 * 3
 * / \
 * 9  20
 * /  \
 * 15   7
 * 返回它的最大深度 3
 * @author: 43138
 * @E-mail: 43138199@qq.com
 * @date: 2020/2/1
 * @time: 18:23
 * 2020/2/1 18:23 43138 create
 * @version: TODO
 */
public class LeetCode104 {

    /**
     * @Description: 递归——深度优先搜索
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

    public static void main(String[] args) {

    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x) {
            val = x;
        }
    }
}
