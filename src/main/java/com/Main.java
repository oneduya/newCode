package com;

import java.util.*;

public class Main {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		PriorityQueue<int[]> que = new PriorityQueue<>(new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[2]-o2[2];
			}
		});
		int[] val = new int[3];
		for (int i = 0; i < m; i++) {
			val = new int[3];
			val[0] = sc.nextInt();
			val[1] = sc.nextInt();
			val[2] = sc.nextInt();
			que.add(val);
		}
		int[] num = new int[n+1];
		int[][] find = new int[m][3];
		int res = Integer.MAX_VALUE;
		boolean flag = true;
		int start = 0;
		for (int i=0; i<m; i++) {
			find[i] = que.poll();
			num[find[i][0]]++;
			num[find[i][1]]++;
			flag = true;
			for (int j = 1; j < n + 1; j++) {
				if (num[j]<1) {
					flag = false;
				}
				if (!flag)break;
			}
			if (flag) {
				while (flag&&start<i) {
					res = Math.min(res,find[i][2]-find[start][2]);
					num[find[start][0]]--;
					num[find[start][1]]--;
					start++;
					for (int j = 1; j < n + 1; j++) {
						if (num[j]<1) flag=false;
						if (!flag) break;
					}
				}
			}else {
				continue;
			}
		}
		System.out.println(res);

	}


}

