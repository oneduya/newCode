package com.leetcode.DinamicProgramming;

/**
 * @ClassName: Trap
 * @Description: 42.给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * @Author: WAHWJ
 * @Date: 2020/6/29 10:49
 * @Version: V0.1
 */
public class Trap {
	public int trap(int[] height) {
		int sum = 0;
		int left_max = 0;
		int right_max = 0;
		int left = 1;
		int right = height.length-2;
		while(left<=right) {
            /*设一开始left-1大于right+1，则之后right会一直向左移动，
            直到right+1大于left-1。在这段时间内right所遍历的所有点都是
            左侧最高点maxleft大于右侧最高点maxright的，
            所以只需要根据原则判断maxright与当前高度的关系就行。反之left右移，
            所经过的点只要判断maxleft与当前高度的关系就行。*/
			if(height[left-1] < height[right+1]) {
				left_max = Math.max(height[left-1],left_max);
				if(left_max > height[left]) {
					sum += left_max-height[left];
				}
				left++;
			}else {
				right_max = Math.max(height[right+1],right_max);
				if(right_max > height[right]) {
					sum += right_max - height[right];
				}
				right--;
			}
		}
		return sum;
	}
}
