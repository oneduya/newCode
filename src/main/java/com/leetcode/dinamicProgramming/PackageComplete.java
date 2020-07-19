package com.leetcode.dinamicProgramming;

import java.util.Arrays;

/**
 * @ClassName: CompletePack
 * @Description: 有 N件物品和一个容量为V 的背包。放入第i 件物品耗费的费用是Ci，能放无数次
 *  * 得到的价值是Wi。求解将哪些物品装入背包可使价值总和最大。
 * @Author: WAHWJ
 * @Date: 2020/7/18 11:01
 * @Version: V0.1
 */
public class PackageComplete {
	//物品个数
	int n = 5;
	//总容量
	int V = 10;
	//费用
	int[] cost = new int[]{3, 4, 5, 3, 6};
	//价值
	int[] value = new int[]{4, 5, 6, 3, 5};

	public int maxValue() {
		int[] dp = new int[V+1];
		Arrays.fill(dp,0);
		for (int i=0; i<n; i++) {
			//注意这里和01相比从前往后，因为不用考虑不重复的因素，可以更新前面的状态
			for (int j=cost[i]; j<=V; j++) {
				dp[j] = Math.max(dp[j],dp[j-cost[i]] + value[i]);
			}
		}
		return dp[V];
	}

	public int maxValue2() {
		//循环反过来
		int[] dp = new int[V+1];
		Arrays.fill(dp,0);
		for (int i=1; i<=V; i++) {
			for (int j=0; j<n; j++) {
				if (i >= cost[j]) {
					dp[i] = Math.max(dp[i],dp[i-cost[j]] + value[j]);
				}
			}
		}
		return dp[V];
	}

	public static void main(String[] args) {
		PackageComplete packageComplete = new PackageComplete();
		System.out.println(packageComplete.maxValue());
		System.out.println(packageComplete.maxValue2());
	}
}
