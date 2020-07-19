package com.leetcode.dinamicProgramming;

import java.util.Map;

/**
 * @ClassName: PackageMulti
 * @Description: 多重背包问题，每件物品有特定的个数
 * @Author: WAHWJ
 * @Date: 2020/7/18 14:00
 * @Version: V0.1
 */
public class PackageMulti {
	//物品个数
	int n = 3;
	//总容量
	int V = 15;
	//费用
	int[] cost = new int[]{3, 4, 5};
	//价值
	int[] value = new int[]{2, 3, 4};
	//每件物品的数量
	int[] multi = new int[]{4, 3, 2};


	public int maxValue() {
		int[] dp = new int[V+1];
		for (int i=0; i<n; i++) {
			if (multi[i]*cost[i] >= V) {
				for (int j=cost[i]; j<=V; j++) {
					dp[j] = Math.max(dp[j],dp[j-cost[i]]+value[i]);
				}
			}
			else {
				int k = 1;
				int m = multi[i];
				while (k < m) {
					for (int j=V; j>=k*cost[i]; j--) {
						dp[j] = Math.max(dp[j],dp[j-k*cost[i]]+k*value[i]);
					}
					k *= 2;
					m -= k;
				}
				for (int j=V; j>=m*cost[i]; j--) {
					dp[j] = Math.max(dp[j],dp[j-m*cost[i]]+m*value[i]);
				}
			}
		}
		return dp[V];
	}

	/**
	 * 可行性算法，判断是否可以填满背包，二维数组，dp[i][j]表示 "用了前i 种物品填满容量为 j 的背包后，最多还剩
	 * 下几个第i 种物品可用"，如果F[i; j] = -1 则说明这种状态不可行，若可行应满足
	 * 0 <= F[i; j] <= Mi。
	 *
	 * @param
	 * @return {@link boolean}
	 * @throws
	 * @author WAHWJ
	 * @date 2020/7/18 WAHWJ
	 */
	public boolean canFill() {
		int[][] F = new int[n+1][V+1];
		for (int i=1; i<=V; i++) {
			F[0][i] = -1;
		}

		for (int i=1; i<=n; i++) {
			for (int j=0; j<=V; j++) {
				if (F[i-1][j]>=0) {
					F[i][j] = multi[i-1];
				}
				else {
					F[i][j] = -1;
				}
			}
			for (int j=0; j<=V-cost[i-1]; j++) {
				if(F[i][j]>0) {
					F[i][j+cost[i-1]] = Math.max(F[i][j+cost[i-1]],F[i][j]-1);
				}
			}
		}
		return F[n][V]>=0;
	}

	public static void main(String[] args) {
		PackageMulti packageMulti = new PackageMulti();
		System.out.println(packageMulti.maxValue());
		System.out.println(packageMulti.canFill());
	}
}
