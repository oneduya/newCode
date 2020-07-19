package com.leetcode.dinamicProgramming;

/**
 * @ClassName: IisInterleave
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/7/11 10:32
 * @Version: V0.1
 */
public class IsInterleave {
	public boolean isInterleave(String s1, String s2, String s3) {
		int len1 = s1.length();
		int len2 = s2.length();
		//判断长度是否符合要求
		if (len1+len2 != s3.length()) {
			return false;
		}
		//dp[i][j]表示s1的前i个字符和s2的前j个字符能够构成s3的前缀
		boolean[][] dp = new boolean[len1+1][len2+1];
		dp[0][0] = true;

		for (int i=0; i<=len1; i++) {
			for (int j=0; j<=len2; j++) {
				//dp[0][0]=true;
				if (i == 0 && j == 0) {
					dp[i][j] = true;
				} else if (i == 0) {
					//边界
					dp[i][j] = dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(j - 1);
				} else if (j == 0) {
					dp[i][j] = dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i - 1);
				} else {
					//判断在有s1的第i个字符或者s2的第j个字符和s3匹配的情况
					dp[i][j] = (dp[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) || (dp[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
				}
			}
		}
		return dp[len1][len2];
	}


	public static void main(String[] args) {
		IsInterleave isInterleave = new IsInterleave();
		System.out.println(isInterleave.isInterleave("aabcc", "dbbca", "aadbbcbcac"));
	}
}
