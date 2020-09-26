package com;


import java.util.*;

public class Main4 {
	static int res;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] boys = sc.nextLine().split(" ");
		String[] girls = sc.nextLine().split(" ");
		int[] arrived = new int[boys.length+girls.length];
		int n = sc.nextInt();
		int[][] couples = new int[n][2];
		for (int i = 0; i < n; i++) {
			couples[i][0] = sc.nextInt();
			couples[i][1] = sc.nextInt();
		}
		res = 0;
		int i=0;
		while (i < n-res) {
			dfs(couples,i,0,arrived);
			i++;
		}
		System.out.println(res);
	}

	public static void dfs(int[][] couples, int start, int count, int[] arrived) {
		if (start == couples.length) {
			res = Math.max(count,res);
			return;
		}
		for (int i = start; i < couples.length; i++) {
			if (arrived[couples[i][0]]==0 && arrived[couples[i][1]]==0) {
				arrived[couples[i][0]] = 1;
				arrived[couples[i][1]] = 1;
				dfs(couples,i+1,count+1,arrived);
				arrived[couples[i][0]] = 0;
				arrived[couples[i][1]] = 0;
			}else {
				dfs(couples,i+1,count,arrived);
			}
		}
	}
}

/*
1
10 2
3
1 2
4 5
8 8
2
1 4
6 8
4
1 2 4 8
*/

