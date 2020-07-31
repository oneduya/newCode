package com.thread;

import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @ClassName: LRU
 * @Description: lru内存淘汰策略
 * @Author: WAHWJ
 * @Date: 2020/7/27 19:54
 * @Version: V0.1
 */
public class LRU<K,V> extends LinkedHashMap<K,V> {
	private int capacity;
	private static final long serialVersionId=1l;
	LRU(int capacity) {
		super(16,0.75f,true);
		this.capacity = capacity;
	}

	@Override
	protected boolean removeEldestEntry(Map.Entry<K, V> eldest) {
		System.out.println(eldest.getKey() + "=" + eldest.getValue());
		//如果返回true就删除最老节点
		return size()>capacity;
	}

	public static void main(String[] args) {
		Map<Integer,Integer> map = new LRU<>(4);
		map.put(9,1);
		map.put(7,1);
		map.put(5,1);
		map.put(3,1);
		map.put(6,1);
		map.get(5);

		for (Iterator<Map.Entry<Integer,Integer>> it=map.entrySet().iterator();it.hasNext();) {
			System.out.println(it.next().getKey());
		}
	}
}
