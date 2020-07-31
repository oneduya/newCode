package com.leetcode.dinamicProgramming;

/**
 * @ClassName: MaxProfit
 * @Description: 买卖股票的最佳时机
 * @Author: WAHWJ
 * @Date: 2020/7/22 8:36
 * @Version: V0.1
 */
public class MaxProfit {
	/**
	 * 如果你最多只允许完成一笔交易（即买入和卖出一支股票一次），设计一个算法来计算你所能获取的最大利润。
	 * dp[i][k][j]来表示第i天买入了k次的状态，j只有0（未买入）和1（买入）两种状态
	 * 
	 * @param prices
	 * @return {@link int}
	 * @throws
	 * @author WAHWJ 
	 * @date 2020/7/22 WAHWJ
	 */
	public int maxProfit1(int[] prices) {
		//dp0代表当天未买入，1表示买入，本来是二维矩阵因为只和上一个状态相关所以压缩成两个变量
		int dp0 = 0;
		int dp1 = Integer.MIN_VALUE;
		for (int i = 0; i < prices.length; i++) {
			int temp = dp0;
			dp0 = Math.max(dp0,dp1 + prices[i]);
			dp1 = Math.max(dp1,-prices[i]);
		}
		return dp0;
	}

	public int maxProfit2(int[] prices) {
		int dp0 = 0;
		int dp1 = Integer.MIN_VALUE;
		for (int i=0; i< prices.length; i++) {
			int temp = dp0;
			dp0 = Math.max(dp0, dp1 + prices[i]);
			dp1 = Math.max(dp1, dp0 - prices[i]);
		}
		return dp0;
	}

	/**
	 *
	 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。

	 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。

	 注意: 你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
	 *
	 * @param k
	 * @param prices
	 * @return {@link int}
	 * @throws
	 * @author WAHWJ
	 * @date 2020/7/28 WAHWJ
	 */
	public int maxProfit4(int k, int[] prices) {
		int n = prices.length;
		if (k > n/2) {
			return maxProfit2(prices);
		}

		int dp[][][] = new int[n][k+1][2];
		for (int i = 0; i < n; i++) {
			for (int j = k; j >= 1; j--) {
				//base case
				if (i==0) {
					dp[i][j][0] = 0;
					dp[i][j][1] = -prices[0];
					continue;
				}

				//当天未持有可由昨天未持有和昨天持有今天卖掉推出
				dp[i][j][0] = Math.max(dp[i-1][j][0], dp[i-1][j][1] + prices[i]);
				dp[i][j][1] = Math.max(dp[i-1][j][1], dp[i-1][j-1][0] - prices[i]);
			}
		}
		return dp[n-1][k][0];
	}

	public static void main(String[] args) {
		MaxProfit maxProfit = new MaxProfit();
		System.out.println(maxProfit.maxProfit4(1, new int[]{1, 2}));
	}
}
