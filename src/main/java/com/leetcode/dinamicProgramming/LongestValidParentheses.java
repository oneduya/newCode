package com.leetcode.dinamicProgramming;

/**
 * @ClassName: LongestValidParentheses
 * @Description: 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
 * @Author: WAHWJ
 * @Date: 2020/6/30 7:48
 * @Version: V0.1
 */
public class LongestValidParentheses {
	public int longestValidParentheses(String s) {
		//dp[i] = 下标为i字符结尾组成的字符串中最长包含有效括号的子串长度

		int[] dp = new int[s.length()];
		int maxans = 0;
		for (int i=1; i<dp.length; i++) {
			//只需要考虑当前节点是‘）’的情况，分为前一个是（和前一个是）两种情况
			if (s.charAt(i)==')') {
				//如果是（）
				if (s.charAt(i-1)=='(') {
					dp[i] = (i>=2 ? dp[i-2]:0) + 2;
				}
				//如果是））并且第一个）构成了有效字符串，并且在有效字符串前有个（，
				// 那么后面这个）也可以和前面的有效字符串和（拼接成有效字符串；
				// dp[i-dp[i-1]-2]代表这个有效字符串前一个有效字符串的长度
				else if (i - dp[i - 1] > 0 && s.charAt(i - dp[i - 1] - 1) == '(') {
					dp[i] = dp[i-1] + (i-dp[i-1]>=2 ? dp[i-dp[i-1]-2]:0) + 2;
				}
			}
			maxans = Math.max(maxans,dp[i]);
		}
		return maxans;
	}

	public static void main(String[] args) {
		LongestValidParentheses longestValidParentheses = new LongestValidParentheses();
		System.out.println(longestValidParentheses.longestValidParentheses("()(()"));
	}
}
