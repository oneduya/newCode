package com.leetcode.dinamicProgramming;

/**
 * @ClassName: LongestSongArray
 * @Description: 给定一个无序的整数数组，找到其中最长上升子序列的长度。
 * @Author: WAHWJ
 * @Date: 2020/4/22 19:14
 * @Version: V0.1
 */
public class LongestSongArray {
    public static int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 1;
        int maxans = 1;
        for(int i=1;i<nums.length;i++){
            dp[i] = 1;
            for(int j=0;j<i;j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[i],dp[j]+1);
                }
            }
            maxans = Math.max(maxans, dp[i]);
        }
        return maxans;
    }

    public static void main(String[] args) {
        int[] array = {1,3,6,7,9,4,10,5,6};
        System.out.println(lengthOfLIS(array));
    }
}
