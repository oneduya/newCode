package com.leetcode.dinamicProgramming;

import java.util.Arrays;

/**
 * @ClassName: MaxCoins
 * @Description: 有 n 个气球，编号为0 到 n-1，每个气球上都标有一个数字，这些数字存在数组 nums 中。
 *
 * 现在要求你戳破所有的气球。如果你戳破气球 i ，就可以获得 nums[left] * nums[i] * nums[right] 个硬币。 
 * 这里的 left 和 right 代表和 i 相邻的两个气球的序号。
 * 注意当你戳破了气球 i 后，气球 left 和气球 right 就变成了相邻的气球。
 *
 * @Author: WAHWJ
 * @Date: 2020/7/19 8:46
 * @Version: V0.1
 */
public class MaxCoins {
	public int maxcoins(int[] nums) {
		//避免空指针异常
		if (nums==null) {
			return 0;
		}
		//创建虚拟边界
		int[] temp = new int[nums.length+2];
		System.arraycopy(nums,0,temp,1,nums.length);
		temp[0] = 1; temp[nums.length+1] = 1;
		//创建dp表
		int length = temp.length;
		int[][] dp = new int[length][length];
		//开始dp：i为begin，j为end，k为在i、j区间划分子问题时的边界
		for (int i=length-2; i>=0; i--) {
			for (int j=i+2; j<length;j++) {
				//维护一个最大值；如果i、j相邻，值为0
				int max = 0;
				for (int k=i+1; k<j; k++) {
					max = Math.max(max,dp[k][j]+dp[i][k] + temp[i]*temp[k]*temp[j]);
				}
				dp[i][j] = max;
			}
		}
		return dp[0][length-1];
	}


	public static void main(String[] args) {
		MaxCoins maxCoins = new MaxCoins();
		System.out.println(maxCoins.maxcoins(new int[]{3, 1, 5, 8}));
	}
}
