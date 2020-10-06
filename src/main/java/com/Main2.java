package com;


import java.util.*;
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[][] one = new int[N+1][M+1];
		int[][] two = new int[N+1][M+1];
		for (int i = 0; i <= N; i++) {
			one[i][0] = 1;
			two[i][0] = 1;
		}
		for (int i = 0; i <= M; i++) {
			one[0][i] = 1;
			two[0][i] = 1;
		}
		for (int i = 1; i <= N; i++) {
			for (int j = 1; j <= M; j++) {
				if (i>1 && j>1) {
					one[i][j] = (one[i-1][j-1] + two[i-2][j-2])%1000000007;
					two[i][j] = (one[i-1][j-1] + two[i-2][j-2])%1000000007;
				}
				else {
					one[i][j] = one[i-1][j-1];
					two[i][j] = 0;
				}
			}
		}
		System.out.println((one[N][M] + two[N][M])%1000000007);
	}
}
