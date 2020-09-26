package com;


import java.util.*;

public class Main3 {
	public static int res;
	Map<int[], Integer> map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int k = sc.nextInt();
		int[][] roads = new int[n][n];
		for (int i = 0; i < n-1; i++) {
			int to = sc.nextInt();
			roads[i+1][to] = 1;
			roads[to][i+1] = 1;
		}
		res = 1;
		int[] arrived = new int[n];
		arrived[0] = 1;
		bfs(roads, k, 0, 1,arrived);
		System.out.println(res);
	}


	public static void bfs(int[][] roads, int k, int start, int count,int[] arrived) {
		if (k==0) {
			res = Math.max(count,res);
			return;
		}
		for (int i = 0; i < roads.length; i++) {
			if (roads[start][i]==1) {
				if (arrived[i]==0) {
					count++;
					arrived[i] = 1;
					bfs(roads,k-1,i,count,arrived);
					count--;
					arrived[i] = 0;
				}else {
					bfs(roads,k-1,i,count,arrived);
				}
			}
		}
	}
}
