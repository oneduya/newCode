package com.thread.lru;

import java.util.HashMap;

/**
 * @ClassName: LruCache
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/8/4 8:48
 * @Version: V0.1
 */
public class LRUCache {
	// key -> Node(key, val)
	private HashMap<Integer, Node> map;
	// Node(k1, v1) <-> Node(k2, v2)...
	private DoubleList cache;
	// 最大容量
	private int cap;

	public LRUCache(int capacity) {
		this.cap = capacity;
		map = new HashMap<>();
		cache = new DoubleList();
	}
	/* 将某个 key 提升为最近使用的 */
	private void makeRecently(int key) {
		Node node = map.get(key);
		// 先从链表中删除这个节点
		cache.remove(node);
		// 重新插到队尾
		cache.addLast(node);
	}

	/* 添加最近使用的元素 */
	private void addRecently(int key, int val) {
		Node node = new Node(key, val);
		// 别忘了在 map 中添加 key 的映射
		map.put(key,node);
		// 链表尾部就是最近使用的元素
		cache.addLast(node);
	}

	/* 删除某一个 key */
	private void deleteKey(int key) {
		Node node = map.get(key);
		// 从 map 中删除
		map.remove(key);
		// 从链表中删除
		cache.remove(node);
	}

	/* 删除最久未使用的元素 */
	private void removeLeastRecently() {
		// 链表头部的第一个元素就是最久未使用的
		Node node = cache.removeFirst();
		// 同时别忘了从 map 中删除它的 key
		map.remove(node.key);
	}

	public int get(int key) {
		makeRecently(key);
		return map.get(key).val;
	}

	public void put(int key, int val) {
		if (map.containsKey(key)) {
			// 删除旧的数据
			deleteKey(key);
			// 新插入的数据为最近使用的数据
			addRecently(key, val);
			return;
		}
		if (cache.size()==cap) {
			// 删除最久未使用的元素
			removeLeastRecently();
		}
		addRecently(key, val);
	}

}
