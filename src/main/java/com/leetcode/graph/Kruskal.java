package com.leetcode.graph;

import java.util.Comparator;
import java.util.PriorityQueue;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * @ClassName: Kruskal
 * @Description: 克鲁斯卡尔法实现最小生成树，采用的是搜索边
 * @Author: WAHWJ
 * @Date: 2020/8/16 22:36
 * @Version: V0.1
 */
public class Kruskal {
	/**
	 * 找到集合的父节点
	 *
	 * @param parents
	 * @param num
	 * @return {@link int}
	 * @throws
	 * @author WAHWJ
	 * @date 2020/8/16 WAHWJ
	 */
	public static int find(int[] parents, int num) {
		if (parents[num] == num) {
			return num;
		} else {
			return find(parents, parents[num]);
		}
	}

	public static void main(String[] args) {
		int n = 9;
		int m = 15;
		/*int[][] arr = new int[][]{
				{-1, 4, 0, 0, 0, 0, 0, 8, 0},
				{0, -1, 8, 0, 0, 0, 0, 11, 0},
				{0, 0, -1, 7, 0, 4, 0, 0, 2},
				{0, 0, 0, -1, 9, 14, 0, 0, 0},
				{0, 0, 0, 0, -1, 10, 0, 0, 0},
				{0, 0, 0, 0, 0, -1, 2, 0, 0},
				{0, 0, 0, 0, 0, 0, -1, 1, 6},
				{0, 0, 0, 0, 0, 0, 0, -1, 7},
				{0, 0, 0, 0, 0, 0, 0, 0, -1}
		};
		for (int i = 0; i < arr.length; i++) {
			for (int j = 0; j < arr[0].length; j++) {
				if (arr[i][j] > 0) {
					m++;
				}
			}
		}*/

		//int[i]代表一个三元组i,j,l表示i和j之间由长度为l的路径连接
		int[][] roads = new int[m][3];
		roads[0] = new int[]{4, 7, 7};
		roads[1] = new int[]{2, 8, 8};
		roads[2] = new int[]{0, 1, 10};
		roads[3] = new int[]{0, 5, 11};
		roads[4] = new int[]{1, 8, 12};
		roads[5] = new int[]{3, 7, 16};
		roads[6] = new int[]{1, 6, 16};
		roads[7] = new int[]{5, 6, 17};
		roads[8] = new int[]{1, 2, 18};
		roads[9] = new int[]{6, 7, 19};
		roads[10] = new int[]{3, 4, 20};
		roads[11] = new int[]{3, 8, 21};
		roads[12] = new int[]{2, 3, 22};
		roads[13] = new int[]{3, 6, 24};
		roads[14] = new int[]{4, 5, 26};
		kruskal(n, m, roads);
	}

	public static void kruskal(int n, int m, int[][] roads) {
		PriorityQueue<int[]> queue = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2] - o2[2];
			}
		});
		for (int i = 0; i < m; i++) {
			queue.add(roads[i]);
		}
		int[] parent = new int[n];
		for (int i = 0; i < n; i++) {
			parent[i] = i;
		}
		int count = 0;
		int res = 0;
		while (!queue.isEmpty()) {
			int[] road = queue.poll();
			int start = find(parent, road[0]) ;
			int end = find(parent, road[1]);
			if (start != end) {
				System.out.println("访问到了节点：{" + road[0] + "," + road[1] + "}，权值：" + road[2]);
				parent[start] = end;
				count += 1;
				res += road[2];
				if (count == n - 1) {
					break;
				}
			}
		}
		System.out.println(count == n - 1 ? res : -1);
	}
}

