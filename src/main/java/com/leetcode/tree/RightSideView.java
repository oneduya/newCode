package com.leetcode.tree;

import java.util.*;

/**
 * @ClassName: RightSideView
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/4/27 10:31
 * @Version: V0.1
 */
public class RightSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList();
        Queue<TreeNode> queue = new LinkedList();
        if(root==null){
            return result;
        }
        queue.add(root);
        while(!queue.isEmpty()) {
            int size = queue.size();
            TreeNode node = new TreeNode(0);
            for(int i=0;i<size;i++){
                node = queue.remove();
                if(node.left!=null){
                    queue.add(node.left);
                }
                if(node.right!=null){
                    queue.add(node.right);
                }
            }
            result.add(node.val);
        }
        return result;
    }

    public static void main(String[] args) {
        TreeNode a = new TreeNode(1);
        TreeNode b = new TreeNode(2);
        TreeNode c = new TreeNode(3);
        TreeNode d = new TreeNode(4);
        TreeNode e = new TreeNode(5);
        a.left = b;
        a.right = c;
        b.right = e;
        c.right = d;
        System.out.println(rightSideView(a));
        HashMap<Integer,String> map = new HashMap();
        map.remove(1);
    }
}
