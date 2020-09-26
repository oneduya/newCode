package com.thread.lru;

import java.util.HashMap;
import java.util.Map;

class LCache {
	Map<Integer,Node> map;
	int capacity;
	Node head;
	Node tail;
	public LCache(int capacity) {
		this.capacity = capacity;
		map = new HashMap();
		head = new Node(0,0);
		tail = new Node(0,0);
		head.next = tail;
		tail.prev = head;
	}

	public int get(int key) {
		Node node = map.get(key);
		if (node!=null) {
			node.prev.next = node.next;
			node.next.prev = node.prev;
			node.next = head.next;
			head.next.prev = node;
			head.next = node;
			node.prev = head;
			return node.val;
		} else {
			return -1;
		}
	}

	public void put(int key, int value) {
		Node node = new Node(key, value);
		if (map.containsKey(key)) {
			map.get(key).val = value;
			get(key);
		}
		else if (map.keySet().size()==capacity) {
			Node last = tail.prev;
			map.remove(last.key);
			last.prev.next = last.next;
			last.next.prev = last.prev;
			last.prev = null;
			last.next = null;
		}
		node.next = head.next;
		head.next.prev = node;
		node.prev = head;
		head.next = node;
		map.put(key, node);
	}

	public static void main(String[] args) {
		LCache lCache = new LCache(2);
		lCache.put(1,1);
		lCache.put(2,2);
		lCache.get(1);
		lCache.put(3,3);
		lCache.get(2);
		lCache.put(4,4);
		lCache.get(1);
		lCache.get(3);
		lCache.get(4);
	}
}
