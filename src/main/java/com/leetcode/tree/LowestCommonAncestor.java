package com.leetcode.tree;

/**
 * @ClassName: LowestCommonAncestor
 * @Description: 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * @Author: WAHWJ
 * @Date: 2020/4/25 9:55
 * @Version: V0.1
 */
public class LowestCommonAncestor {
    /**
     * @Author WAHWJ
     * @Description //若 root.val < p.val ，则 p 在 root 右子树 中；
     *                若 root.val > p.val ，则 p 在 root 左子树 中；
     *                若 root.val = p.val ，则 p 和 root 指向 同一节点 。
     * @Date 10:15 2020/4/25
     * @Param [root, p, q]
     * @return com.leetcode.Tree.TreeNode
     **/
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode result;
        if(root==null) {
            return null;
        }
        if(root.val>p.val && root.val>q.val) {
            //两个点都比root小说明是在root的左子树中
            result = lowestCommonAncestor(root.left,p,q);
        }else if(root.val<p.val && root.val<q.val){
            //两个点都比root大说明是在root的右子树中
            result = lowestCommonAncestor(root.right,p,q);
        }else{
            //一大一小说明root就是他们的公共父节点并且是最近的
            return root;
        }
        return result;
    }


    /**
     * 如果不是二叉排序树，但是val不相等
     *
     * @param root
     * @param p
     * @param q
     * @return {@link TreeNode}
     * @throws
     * @author WAHWJ
     * @date 2020/7/21 WAHWJ
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        //向上传递
        if (root==null || root.val==p.val || root.val==q.val) {
            return root;
        }
        //找左右节点是否是pq的父节点
        TreeNode left = lowestCommonAncestor2(root.left,p,q);
        TreeNode right = lowestCommonAncestor2(root.right,p,q);
        //如果左右都不为空，则说明该节点是两个数的公共父节点
        if (left!=null && right!=null) {
            return root;
        }
        //返回左右非空
        if (left!=null) {
            return left;
        }
        if (right!=null) {
            return right;
        }
        return null;
    }
}
