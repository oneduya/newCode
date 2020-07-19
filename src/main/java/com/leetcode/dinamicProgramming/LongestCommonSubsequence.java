package com.leetcode.dinamicProgramming;

/**
 * @ClassName: LongestCommonSubsequence
 * @Description: 给定两个字符串 text1 和 text2，返回这两个字符串的最长公共子序列的长度。
 * @Author: WAHWJ
 * @Date: 2020/4/22 21:48
 * @Version: V0.1
 */
public class LongestCommonSubsequence {
    public static int longestCommonSubsequence(String text1, String text2) {
        int length1 = text1.length();
        int length2 = text2.length();
        int[][] dp = new int[length1+1][length2+1];
        for (int i = 1; i <=length1; i++) {
            for(int j=1;j<=length2;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = dp[i-1][j-1] + 1;
                }
                else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        return dp[length1][length2];
    }

    public static void main(String[] args) {
        System.out.println(longestCommonSubsequence("abcde","ace"));
    }
}
