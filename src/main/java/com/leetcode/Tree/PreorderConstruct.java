package com.leetcode.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Stack;

/**
 * @ClassName: PreorderConstruct
 * @Description: 先序遍历构造二叉树，根据先序遍历结果构造二叉树并返回根节点
 * @Author: WAHWJ
 * @Date: 2020/4/19 9:24
 * @Version: V0.1
 */
public class PreorderConstruct {
    public static TreeNode bstFromPreorder(int[] preorder) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode head = new TreeNode(preorder[0]);
        TreeNode cur = head;
        for(int i=1;i<preorder.length;i++) {
            if(preorder[i]<cur.val) {
                TreeNode left = new TreeNode(preorder[i]);
                cur.left = left;
                stack.push(cur);
                cur = left;
            }
            else {
                while(!stack.isEmpty() && preorder[i]>stack.peek().val){
                    cur = stack.pop();
                }
                TreeNode right = new TreeNode(preorder[i]);
                cur.right = right;
                cur = right;
                //cur = stack.pop();
            }
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println(null==null);
        //bstFromPreorder(new int[]{8,5,1,7,10,12});
        ArrayDeque<TreeNode> deque = new ArrayDeque();

    }
}
