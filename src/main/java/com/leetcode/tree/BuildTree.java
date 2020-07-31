package com.leetcode.tree;

import java.util.HashMap;

/**
 * @ClassName: BuildTree
 * @Description: 输入某二叉树的前序遍历和中序遍历的结果，请重建该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
 * @Author: WAHWJ
 * @Date: 2020/4/23 12:36
 * @Version: V0.1
 */
public class BuildTree {
    HashMap<Integer,Integer> map = new HashMap<>();
    int[] pre;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i=0;i<inorder.length;i++){
            map.put(inorder[i],i);
        }
        pre = preorder;
        return build(0,0,inorder.length-1);
    }

    /**
     * @Author WAHWJ
     * @Description 采用递归的方式，参数为根节点，最左边和最右边（构成一棵树或者子树），
     * 递归的终止条件就是中序的inLeft>inRight，说明中序遍历为空，超过了子节点
     * @Date 13:33 2020/4/23
     * @Param [preRoot, inLeft, inRight]
     * @return com.leetcode.Tree.TreeNode
     **/
    public TreeNode build(int preRoot, int inLeft, int inRight) {
        if(inLeft > inRight) {
            return null;
        };
        int i = map.get(pre[preRoot]);
        TreeNode root = new TreeNode(pre[preRoot]);
        //如果是子节点得话inLeft==i==inRight
        root.left = build(preRoot+1,inLeft,i-1);
        //i-inLeft + preRoot+1表示右子树的根节点在前序遍历中的位置，i-left表示左子树个数，
        // 前序遍历中要从上一个根节点的位置往后数左子树节点个数个元素，才是右子树的根节点，+1操作很重要
        root.right = build(i-inLeft + preRoot+1,i+1,inRight);
        return root;
    }
}
