package com.leetcode.dinamicProgramming;

/**
 * @ClassName: MinCut
 * @Description: 给定一个字符串 s，将 s 分割成一些子串，使每个子串都是回文串。
 * 返回符合要求的最少分割次数。
 * @Author: WAHWJ
 * @Date: 2020/5/21 21:26
 * @Version: V0.1
 */
public class MinCut {
    public int minCut(String s) {
        int len = s.length();
        if(len<2) {
            return 0;
        }
        //dp[i]表示从0到i共需要分割几次
        //状态转移方程为dp[i] = min(dp[j]+1 if s[j+1,i]是回文串) for j in range（0，i）
        int[] dp = new int[len];
        for(int i=0;i<dp.length;i++) {
            dp[i] = i;
        }

        //checkPalindrome[i][j] 表示从i到j有没有回文串
        boolean[][] checkPalindrome = new boolean[len][len];
        for(int right=0;right<len;right++) {
            for(int left=0;left<=right;left++) {
                //判断，首先两个字符相同，其次看间隔是否小于2或者前面一部分是不是回文串
                if(s.charAt(left)==s.charAt(right) &&
                        (right-left <= 2 || checkPalindrome[left+1][right-1])) {
                    checkPalindrome[left][right] = true;
                }
            }
        }

        for(int i=1;i<len;i++) {
            //如果从开始到i就是回文串直接是0且继续
            if(checkPalindrome[0][i]) {
                dp[i] = 0;
                continue;
            }
            //状态转移方程，j<i的原因是要至少有一个字符
            for(int j=0;j<i;j++) {
                if(checkPalindrome[j+1][i]) {
                    dp[i] = Math.min(dp[j]+1,dp[i]);
                }
            }
        }
        return dp[len-1];
    }

    public static void main(String[] args) {
        MinCut minCut = new MinCut();
        minCut.minCut("aab");
    }
}
