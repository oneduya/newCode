package com.leetcode.math;

import java.util.HashMap;

/**
 * @ClassName: MaxPoints
 * @Description: 给定一个二维平面，平面上有 n 个点，求最多有多少个点在同一条直线上。
 * @Author: WAHWJ
 * @Date: 2020/7/18 8:40
 * @Version: V0.1
 */
public class MaxPoints {
	public int maxPoints(int[][] points) {
		if (points.length < 3) {
			return points.length;
		}
		int result = 0;
		for (int i = 0; i < points.length; i++) {
			//存放穿过点的每条直线
			HashMap<String, Integer> map = new HashMap<>();
			int duplicated = 0;
			int max = 0;
			for (int j = i+1; j < points.length; j++) {
				//相当于求斜率
				int x = points[i][0] - points[j][0];
				int y = points[i][1] - points[j][1];

				if (x==0 && y==0) {
					duplicated ++;
					continue;
				}
				int zdgys = zdgys(x,y);
				x = x/zdgys;
				y = y/zdgys;
				int count = map.getOrDefault(x+"#"+y,0)+1;
				max = Math.max(count,max);
				map.put(x+"#"+y,count);
			}
			//1 代表当前考虑的点，duplicate 代表和当前的点重复的点
			result = Math.max(result, max + duplicated + 1);
		}
		return result;
	}

	/**
	 * 求最大公约数,可正可负，和b有关
	 *
	 * @param a
     * @param b
	 * @return {@link int}
	 * @throws
	 * @author WAHWJ
	 * @date 2020/7/18 WAHWJ
	 */
	public int zdgys(int a, int b) {
		while (b!=0) {
			int tmp = a%b;
			a = b;
			b = tmp;
		}
		return a;
	}
}
