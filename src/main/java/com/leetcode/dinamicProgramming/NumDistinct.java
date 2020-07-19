package com.leetcode.dinamicProgramming;

/**
 * @ClassName: NumDistinct
 * @Description: 115. 不同的子序列
 * 给定一个字符串 S 和一个字符串 T，计算在 S 的子序列中 T 出现的个数。
 *
 * 一个字符串的一个子序列是指，通过删除一些（也可以不删除）字符且不干扰剩余字符相对位置所组成的新字符串。
 * （例如，"ACE" 是 "ABCDE" 的一个子序列，而 "AEC" 不是）
 *
 * 题目数据保证答案符合 32 位带符号整数范围。
 * @Author: WAHWJ
 * @Date: 2020/7/13 10:38
 * @Version: V0.1
 */
public class NumDistinct {
	public int numDistinct(String s, String t) {
		int slen = s.length();
		int tlen = t.length();
		//dp[i][j]表示s前i个字符包含t前j个字符的子序列的个数
		int[][] dp = new int[slen+1][tlen+1];
		//初始化，当j=0，时dp[i][0]都为1
		for (int i = 0; i <= slen; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i <= slen; i++) {
			for (int j = 1; j <= tlen; j++) {
				//当字符相等时，s中这个字符要么在子序列中，要么不在
				if(s.charAt(i-1)==t.charAt(j-1)) {
					dp[i][j] = dp[i-1][j] + dp[i-1][j-1];
				}
				else {
					dp[i][j] = dp[i-1][j];
				}
			}
		}
		return dp[slen][tlen];
	}

	public static void main(String[] args) {
		NumDistinct numDistinct = new NumDistinct();

	}
}
