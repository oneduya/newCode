package com.leetcode.dinamicProgramming;

/**
 * @ClassName: MaxProduct
 * @Description: 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），
 * 并返回该子数组所对应的乘积。
 * @Author: WAHWJ
 * @Date: 2020/7/20 8:56
 * @Version: V0.1
 */
public class MaxProduct {
	public int maxProduct(int[] nums) {
		if (nums.length==0) {
			return 0;
		}
		//用两个dp数组来维护当前状态，因为考虑到有负数的存在，
		// 所以要保存最小值，因为最小值有可能乘一个负数就变成最大值
		int[] max = new int[nums.length];
		int[] min = new int[nums.length];
		int res = nums[0];
		max[0] = nums[0];
		min[0] = nums[0];
		for (int i=1; i<nums.length; i++) {
			if (nums[i]==0) {
				max[i] = 0;
				min[i] = 0;
			}
			else if (nums[i]<0) {
				//当前值小于0，则最大值和最小值都互相相关
				max[i] = Math.max(nums[i],min[i-1]*nums[i]);
				min[i] = Math.min(nums[i],max[i-1]*nums[i]);
			}
			else {
				//如果当前值大于零，最大值和最小值只和自己相关
				max[i] = Math.max(nums[i],max[i-1]*nums[i]);
				min[i] = Math.min(nums[i],min[i-1]*nums[i]);
			}
			res = Math.max(res,max[i]);
		}
		return res;
	}

	public static void main(String[] args) {
		MaxProduct maxProduct = new MaxProduct();
		System.out.println(maxProduct.maxProduct(new int[]{-2}));
	}
}
