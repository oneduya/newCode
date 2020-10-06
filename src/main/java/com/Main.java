package com;

import java.util.*;

public class Main {
	public static int res;
	public static List<int[]> list;
	public static int[] dx = {1, -1, 0, 0};
	public static int[] dy = {0, 0, 1, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		sc.nextLine();
		char[][] arr = new char[N][M];
		int[] start = new int[2];
		for (int i = 0; i < N; i++) {
			arr[i] = sc.nextLine().toCharArray();
			for (int j = 0; j < arr[i].length; j++) {
				if (arr[i][j] == 'T') {
					start[0] = i;
					start[1] = j;
				}
			}
		}
		res = Integer.MAX_VALUE;
		list = new ArrayList<>();
		dfs(arr, start[0], start[1], 0);
		if (res == Integer.MAX_VALUE) {
			System.out.println(0);
		}else {
			System.out.println(res);
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i)[0] + " " + list.get(i)[1] + " ");
			}
		}
	}

	public static void dfs(char[][] arr, int x, int y,int length) {
		if (arr[x][y] == 'X') {
			if (length < res) {
				res = length;
				list.clear();
				list.add(new int[]{x,y});
			}else if (length == res && !contains(list, x, y)) {
				list.add(new int[]{x,y});
			}
			return;
		}
		if (length == res) {
			return;
		}
		arr[x][y] = '1';
		for (int i = 0; i < 4; i++) {
			int nx = x + dx[i];
			int ny = y + dy[i];
			if (nx>=0 && nx<arr.length && ny>=0 && ny<arr[0].length && arr[nx][ny]!='1') {
				dfs(arr,nx,ny,length+1);
			}
		}
		arr[x][y] = '0';
	}

	public static boolean contains(List<int[]> list, int x, int y) {
		for (int[] ints : list) {
			if (ints[0]==x && ints[1]==y) {
				return true;
			}
		}
		return false;
	}
}

/*
5 6
X00100
00100X
01T100
0X1010
00000X
 */