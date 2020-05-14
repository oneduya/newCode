package com.leetcode.Tree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: PathSum
 * @Description: 给定一个二叉树和一个目标和，找到所有从根节点到叶子节点路径总和等于给定目标和的路径。
 * @Author: WAHWJ
 * @Date: 2020/4/29 10:34
 * @Version: V0.1
 */
public class PathSum {
    List<List<Integer>> result = new ArrayList();
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<Integer> list = new ArrayList();
        helper(root,sum,list);
        return result;
    }

    public void helper(TreeNode root, int sum,List<Integer> list) {
        if(root==null){
            return;
        }
        list.add(root.val);
        if(root.val==sum && root.left==null && root.right==null){
            //注意这里不能把原本的list放进去不然后面传递的都是list的引用就会将result中的值改变
            result.add(new ArrayList(list));
            list.remove(list.size()-1);
            return;
        }
        helper(root.left,sum-root.val,list);
        helper(root.right,sum-root.val,list);
        list.remove(list.size()-1);
    }

    public static void main(String[] args) {
        PathSum pathSum = new PathSum();
        TreeNode a = new TreeNode(-2);
        TreeNode b = new TreeNode(-3);
        a.right = b;
        pathSum.pathSum(a,-5);
        new ArrayList<Integer>(){{add(1);}};
    }
}
