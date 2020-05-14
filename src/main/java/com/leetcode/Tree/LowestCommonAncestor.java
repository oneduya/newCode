package com.leetcode.Tree;

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
     * @Description //若 root.val < p.valroot.val<p.val ，则 pp 在 rootroot 右子树 中；
     *                若 root.val > p.valroot.val>p.val ，则 pp 在 rootroot 左子树 中；
     *                若 root.val = p.valroot.val=p.val ，则 pp 和 rootroot 指向 同一节点 。
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
            result = lowestCommonAncestor(root.left,p,q);
        }else if(root.val<p.val && root.val<q.val){
            result = lowestCommonAncestor(root.right,p,q);
        }else{
            return root;
        }
        return result;
    }
}
