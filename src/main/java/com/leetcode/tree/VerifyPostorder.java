package com.leetcode.tree;

/**
 * @ClassName: VerifyPostorder
 * @Description: 输入一个整数数组，判断该数组是不是某二叉搜索树的后序遍历结果。如果是则返回 true，否则返回 false。假设输入的数组的任意两个数字都互不相同。
 * @Author: WAHWJ
 * @Date: 2020/4/25 14:38
 * @Version: V0.1
 */
public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length==0){
            return false;
        }
        return verifyPostorderHelper(postorder,0,postorder.length-1);
    }

    public boolean verifyPostorderHelper(int[] postorder, int start, int end) {
        if(start>=end){
            return true;
        }
        //i用于记录第一个比postorder[end]大的位置，作为划分左子树和右子树的边界
        int i = start;
        while(postorder[i]<postorder[end]){
            i++;
        }
        //j用来判断以postorder[end]为根的右子树是否都比根大
        int j = i;
        while(postorder[j]>postorder[end]){
            j++;
        }
        //判断左子树和右子树是否都满足
        return (j==end) && verifyPostorderHelper(postorder,start,i-1) && verifyPostorderHelper(postorder,i,end-1);
    }

    public static void main(String[] args) {
        VerifyPostorder verifyPostorder = new VerifyPostorder();
        boolean flag = verifyPostorder.verifyPostorder(new int[]{1,3,2,6,5});
        System.out.println(flag);
    }
}
