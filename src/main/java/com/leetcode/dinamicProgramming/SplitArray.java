package com.leetcode.dinamicProgramming;

import java.util.Arrays;

/**
 * @ClassName: SplitArray
 * @Description: 给定一个非负整数数组和一个整数 m，你需要将这个数组分成 m 个非空的连续子数组。
 *              设计一个算法使得这 m 个子数组各自和的最大值最小。
 *
 * 注意:
 * 数组长度 n 满足以下条件:
 *
 * 1 ≤ n ≤ 1000
 * 1 ≤ m ≤ min(50, n)
 *
 * @Author: WAHWJ
 * @Date: 2020/7/25 7:55
 * @Version: V0.1
 */
public class SplitArray {
	public int splitArray(int[] nums, int m) {
		int n = nums.length;
		if (m>n) {
			return 0;
		}
		//dp[i][j]代表前i个数分成m组的最大和
		int[][] dp = new int[n+1][m+1];
		for (int i = 0; i <= n; i++) {
			Arrays.fill(dp[i], Integer.MAX_VALUE);
		}
		int[] sub = new int[n + 1];
		for (int i = 0; i < n; i++) {
			sub[i + 1] = sub[i] + nums[i];
		}
		dp[0][0] = 0;
		for (int i=1; i<=m; i++) {
			//这里用到了剪枝，因为要分i个组，必须要有i个数
			for (int j=i; j<=n; j++) {
				//这里也用到了剪枝，最后面一个组至少要从i-1开始，这样才能保证至少有i个租
				for (int k=i-1; k<j; k++) {
					dp[j][i] = Math.min(dp[j][i],Math.max(dp[k][i-1],sub[j]-sub[k]));
				}
			}
		}
		return dp[n][m];
	}

	/**
	 * 二分+贪心
	 *
	 * @param nums
	 * @param m
	 * @return {@link int}
	 * @throws
	 * @author WAHWJ
	 * @date 2020/7/25 WAHWJ
	 */
	public int splitArray2(int[] nums, int m) {
		int right = 0;
		int left = 0;
		for (int i=0; i<nums.length; i++) {
			right +=nums[i];
			if (nums[i]>left) {
				left = nums[i];
			}
		}
		while (left < right) {
			int mid = left + (right-left)/2;
			if (check(nums,mid,m)) {
				right = mid;
			} else {
				left = mid+1;
			}
		}
		return left;
	}

	public boolean check(int[] nums, int target, int m) {
		int sum = 0;
		//这里为什么取1呢？因为如果为0的话就是统计的比target大的数组和个数，要加上当前数等于m才可以
		int cnt = 1;
		for (int i=0; i<nums.length; i++) {
			if (sum+nums[i]>target) {
				cnt++;
				sum = nums[i];
			} else {
				sum += nums[i];
			}
		}
		return cnt <= m;
	}

	public static void main(String[] args) {
		SplitArray splitArray = new SplitArray();
		System.out.println(splitArray.splitArray2(new int[]{7, 2, 5, 10, 8}, 2));
	}
}
