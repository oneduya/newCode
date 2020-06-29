package com.leetcode.Tree;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: GenerateTrees
 * @Description: 给定一个整数 n，生成所有由 1 ... n 为节点所组成的二叉搜索树。
 * @Author: WAHWJ
 * @Date: 2020/5/24 9:46
 * @Version: V0.1
 */
public class GenerateTrees {
    public List<TreeNode> generateTrees(int n) {
        //特殊情况
        if(n==0) {
            return new ArrayList<TreeNode>();
        }
        return generateTree(1,n);
    }

    //递归获取答案
    public List<TreeNode> generateTree(int left, int right) {
        List<TreeNode> list = new ArrayList();
        if(left>right) {
            //这一步加入null很重要，因为下面要遍历集合，如果集合为空则默认不遍历也就是不加入节点
            list.add(null);
            return list;
        }
        for(int i=left;i<=right;i++) {
            //分别获取左节点和右节点集合
            List<TreeNode> l = generateTree(left,i-1);
            List<TreeNode> r = generateTree(i+1,right);

            //遍历答案集合
            for(TreeNode lnode : l) {
                for(TreeNode rnode : r) {
                    TreeNode root = new TreeNode(i);
                    root.left = lnode;
                    root.right = rnode;
                    list.add(root);
                }
            }
        }
        return list;
    }

    public static void main(String[] args) {
        GenerateTrees generateTrees = new GenerateTrees();
        generateTrees.generateTrees(3);
    }
}
