package com.leetcode.tree;

/**
 * @ClassName: Node
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/7/24 8:22
 * @Version: V0.1
 */
public class Node {
	public int val;
	public Node left;
	public Node right;
	public Node next;

	public Node() {
	}

	public Node(int _val) {
		val = _val;
	}

	public Node(int _val, Node _left, Node _right, Node _next) {
		val = _val;
		left = _left;
		right = _right;
		next = _next;
	}
}
