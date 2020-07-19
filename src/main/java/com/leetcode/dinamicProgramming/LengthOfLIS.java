package com.leetcode.dinamicProgramming;

/**
 * @ClassName: lengthOfLIS
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/7/7 21:14
 * @Version: V0.1
 */
public class LengthOfLIS {
	public int lengthOfLIS(int[] nums) {
		//tails[i]表示i+1长度子序列的结尾数字是几，这样可以保证tails是递增数列
		//我们更新tails的方式是从前到后遍历数组nums，
		// 对于每个数字，找到tails中可以插入的位置并替换该位置上的数
		//这样可以保证找到到当前数字，它的最长长度是多少
		int[] tails = new int[nums.length];
		int ans = 0;
		for (int num : nums) {
			int l = 0;
			int r = ans;
			while (l<r) {
				int mid = (l+r)/2;
				//如果当前mid+1长度的子序列最后一个数大于等于num，则向前寻找，或者就放到当前位置（等于）
				if (tails[mid]>=num) {
					r = mid;
				}
				//如果小于则向后寻找，直到找到比前边的数都大且小于等于后面的数的位置
				else {
					l = mid+1;
				}
			}
			//替换当前位置的数字
			tails[l] = num;
			//如果可以放到ans位置，则更新ans
			if(r==ans) {
				ans++;
			}
		}
		return ans;
	}
}
