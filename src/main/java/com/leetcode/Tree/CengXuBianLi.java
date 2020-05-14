package com.leetcode.Tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: CengXuBianLi
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/4/19 22:13
 * @Version: V0.1
 */
public class CengXuBianLi {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList();
        if(root==null){
            return result;
        }
        ArrayDeque<TreeNode> deque = new ArrayDeque();
        deque.addLast(root);
        int level = 0;
        while(!deque.isEmpty()) {
            ArrayList<Integer> list = new ArrayList();
            int level_num = deque.size();
            for(int i=0;i<level_num;i++) {
                TreeNode tmp = deque.remove();
                list.add(tmp.val);
                if(tmp.left != null) {
                    deque.addLast(tmp.left);
                }
                if(tmp.right != null) {
                    deque.addLast(tmp.right);
                }
            }
            result.add(list);
        }
        return result;
    }

    public static void main(String[] args) {
        /*TreeNode a = new TreeNode(3);
        TreeNode b = new TreeNode(9);
        TreeNode c = new TreeNode(20);
        TreeNode d = new TreeNode(15);
        TreeNode e = new TreeNode(7);
        a.left = b;
        a.right = c;
        c.left = d;
        c.right = e;
        System.out.println(levelOrder(a));*/
        String s = "abcds";
        System.out.println();

    }
}
