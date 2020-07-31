package com;

import com.AOC.Person;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @ClassName: Main
 * @Description:
 * @Author: WAHWJ
 * @Date: 2020/7/22 9:15
 * @Version: V0.1
 */

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] array = new int[n];
		for (int i = 0; i < n; i++) {
			array[i] = sc.nextInt();
		}
		long res = 0;
		//o1[0]表示盘子里饼的个数，o1[1]表示盘子索引
		PriorityQueue<Integer[]> queue = new PriorityQueue<>(new Comparator<Integer[]>() {
			@Override
			public int compare(Integer[] o1, Integer[] o2) {
				if (o1[0]==o2[0]) {
					return o2[1]-o1[1];
				}
				return o1[0]-o2[0];
			}
		});
		int nowMin = array[0];
		for (int i=0;i<n;i++) {
			if (array[i]<=nowMin) {
				queue.add(new Integer[]{array[i],i});
				nowMin = array[i];
			}
		}
		int nowEat = n;
		while (!queue.isEmpty()) {
			Integer[] cur = queue.poll();
			while (!queue.isEmpty() && cur[0]==queue.peek()[0]) {
				cur = queue.poll();
			}
			res += (nowEat-cur[1])*cur[0];
			nowEat = cur[1];
		}
		System.out.println(res);
	}
}
