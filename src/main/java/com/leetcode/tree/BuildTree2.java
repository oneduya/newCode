package com.leetcode.tree;

import java.util.HashMap;

/**
 * @ClassName: BuildTree2
 * @Description: 根据一棵树的中序遍历与后序遍历构造二叉树。
 *
 * 注意:
 * 你可以假设树中没有重复的元素。
 * @Author: WAHWJ
 * @Date: 2020/7/23 15:25
 * @Version: V0.1
 */
public class BuildTree2 {
	HashMap<Integer,Integer> map;
	int[] post;
	public TreeNode buildTree(int[] inorder, int[] postorder) {
		map = new HashMap<>();
		post = postorder;
		for (int i=0;i<inorder.length;i++) {
			map.put(inorder[i],i);
		}
		return helper(postorder.length-1,0,inorder.length-1);
	}

	/**
	 * 恢复树
	 *
	 * @param postRoot 后序遍历根所在位置
	 * @param inLeft 中序遍历最左边节点
	 * @param inRight 中序遍历最右边节点
	 * @return {@link TreeNode}
	 * @throws
	 * @author WAHWJ
	 * @date 2020/7/23 WAHWJ
	 */
	public TreeNode helper(int postRoot, int inLeft, int inRight) {
		if (inLeft>inRight) {
			return null;
		}
		int i = map.get(post[postRoot]);
		TreeNode node = new TreeNode(post[postRoot]);
		node.left = helper(postRoot-inRight+i-1,inLeft,i-1);
		node.right = helper(postRoot-1,i+1,inRight);
		return node;
	}

	public static void main(String[] args) {
		BuildTree2 build = new BuildTree2();
		TreeNode node = build.buildTree(new int[]{9,3,15,20,7}, new int[]{9,15,7,20,3});
		System.out.println(build.map);
	}
}
