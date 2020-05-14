package com.leetcode.Tree;

import java.util.ArrayList;

/**
 * @ClassName: MaxProduct
 * @Description: 给你一棵二叉树，它的根为 root 。请你删除 1 条边，使二叉树分裂成两棵子树，且它们子树和的乘积尽可能大。
 * 由于答案可能会很大，请你将结果对 10^9 + 7 取模后再返回。
 * @Author: WAHWJ
 * @Date: 2020/4/22 14:58
 * @Version: V0.1
 */
public class MaxProduct {
    double ans;
    //list中存放所有子树的节点之和

    ArrayList<Double> list = new ArrayList();
    public int maxProduct(TreeNode root) {
        double sum = dfs(root);
        int size = list.size()-1;
        for(int i=0;i<size;i++) {
            double dec = list.get(i);
            if (Math.abs(sum/2-dec)<Math.abs(sum/2-ans)) {
                ans = dec;
            }
        }
        return (int) ((int)(sum-ans)*ans%(1e9+7));
    }

    /**
     * @Author WAHWJ
     * @Description 递归法深度优先遍历
     * @Date 16:52 2020/4/22
     * @Param [node]
     * @return double
     **/
    public double dfs(TreeNode node) {
        if(node == null){
            return 0;
        }
        double temp = node.val + dfs(node.left) + dfs(node.right);
        list.add(temp);
        return temp;
    }

    public static void main(String[] args) {
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        TreeNode node6 = new TreeNode(6);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        node3.left = node6;
        MaxProduct maxProduct = new MaxProduct();
        System.out.println(maxProduct.maxProduct(node1));
    }
}
