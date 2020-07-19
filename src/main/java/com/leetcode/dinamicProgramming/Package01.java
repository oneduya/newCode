package com.leetcode.dinamicProgramming;

import java.util.Arrays;

/**
 * @ClassName: package01
 * @Description: 有 N件物品和一个容量为V 的背包。放入第i 件物品耗费的费用是Ci，只能放一次
 * 得到的价值是Wi。求解将哪些物品装入背包可使价值总和最大。
 * @Author: WAHWJ
 * @Date: 2020/7/18 10:22
 * @Version: V0.1
 */
public class Package01 {
	//物品个数
	int n = 5;
	//总容量
	int V = 10;
	//费用
	int[] cost = new int[]{2, 2, 6, 5, 4};
	//价值
	int[] value = new int[]{6, 3, 5, 4, 6};

	//一维dp,每次保存上一次放的物品的的状态
	public int maxValue() {
		int[] dp = new int[V+1];
		Arrays.fill(dp,0);
		for (int i=0; i<n; i++) {
			//保证V比cost[i]大，而且要从后往前，这样得到的才是上一次的状态
			for (int j=V; j>=cost[i]; j--) {
				dp[j] = Math.max(dp[j],dp[j-cost[i]] + value[i]);
			}
		}
		return dp[V];
	}

	public static void main(String[] args) {
		Package01 package01 = new Package01();
		System.out.println(package01.maxValue());
	}
}
