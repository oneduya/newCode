package com.leetcode.Tree;

/**
 * @ClassName: LongestZigZag
 * @Description: 1372. 二叉树中的最长交错路径
 * @Author: WAHWJ
 * @Date: 2020/4/23 11:16
 * @Version: V0.1
 */
public class LongestZigZag {
    public int longestZigZag(TreeNode root) {
        if(root==null){
            return 0;
        }
        int left = longestHelper(root,true,1);
        int right = longestHelper(root,false,1);
        return Math.max(left,right)-1;
    }

    public int longestHelper(TreeNode node, boolean flag, int len) {
        if(node==null){
            return len;
        }
        if(flag==true){
            len = Math.max(longestHelper(node.left,true,1),longestHelper(node.right,false,len+1));
        } else{
            len = Math.max(longestHelper(node.left,true,len+1),longestHelper(node.right,false,1));
        }
        return len;
    }
}
