package com.thread.lru;

/**
 * @ClassName: Node
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/8/4 8:29
 * @Version: V0.1
 */
public class Node {
	public int key, val;
	public Node next, prev;

	public Node(int key, int val) {
		this.key = key;
		this.val = val;
	}
}
