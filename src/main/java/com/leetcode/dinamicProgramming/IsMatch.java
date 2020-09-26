package com.leetcode.dinamicProgramming;

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
	public boolean isMatch(String s, String p) {
		int slen = s.length();
		int plen = p.length();
		boolean[][] dp = new boolean[slen+1][plen+1];
		dp[0][0] = true;
		for (int i = 0; i <= slen; i++) {
			for (int j = 1; j <= plen; j++) {
				char pc = p.charAt(j-1);

				if(!(pc=='*')) {
					if(matches(s,p,i,j)) {
						dp[i][j] = dp[i-1][j-1];
					}
				} else {
					//当p[j]等于"*"时，分为两种情况
					//一种是当p[j-1]==s[i]的时候，这时*可以用来做匹配也可以不用来做匹配
					if(matches(s,p,i,j-1)) {
						dp[i][j] = dp[i-1][j] || dp[i][j-2];
					} else {
						//一种是当p[j-1]！=s[i]的时候，这时*只能考虑不匹配的情况
						dp[i][j] = dp[i][j-2];
					}
				}
			}
		}
		return dp[slen][plen];
	}

	boolean matches(String s, String p, int i, int j) {
		if(i==0) {
			return false;
		}
		if (p.charAt(j - 1) == '.') {
			return true;
		}
		return s.charAt(i - 1) == p.charAt(j - 1);
	}

	public static void main(String[] args) {
		IsMatch isMatch = new IsMatch();

	}
}
