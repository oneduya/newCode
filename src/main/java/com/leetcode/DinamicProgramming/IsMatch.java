package com.leetcode.DinamicProgramming;

/**
 * @ClassName: IsMatch
 * @Description: 给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。
 *
 * '.' 匹配任意单个字符
 * '*' 匹配零个或多个前面的那一个元素
 * 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。
 * @Author: WAHWJ
 * @Date: 2020/6/27 9:06
 * @Version: V0.1
 */
public class IsMatch {
	/**
	 * @Author WAHWJ
	 * @Description //动态规划
	 * @Date 9:42 2020/6/27
	 * @Param [s, p]
	 * @return boolean
	 **/
	public int maxArea(int[] height) {
		int left = 0;
		int right = height.length-1;
		int max = 0;
		while (left<right) {
			if(height[left] >= height[right]) {
				max = Math.max(max,height[right]*(right-left));
				right--;
			}
			else {
				max = Math.max(max,height[left]*(right-left));
				left++;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		IsMatch isMatch = new IsMatch();
		System.out.println(isMatch.maxArea(new int[] {1,8,6,2,5,4,8,3,7}));
	}
}
