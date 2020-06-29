package com.leetcode.DinamicProgramming;

/**
 * @ClassName: CoinChange
 * @Description: 给定不同面额的硬币 coins 和一个总金额 amount。
 * 编写一个函数来计算可以凑成总金额所需的最少的硬币个数。如果没有任何一种硬币组合能组成总金额，返回 -1。
 * @Author: WAHWJ
 * @Date: 2020/5/16 10:36
 * @Version: V0.1
 */
public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for(int i=1;i<dp.length;i++) {
            dp[i] = amount+1;
        }
        //dp[j]表示凑够j元需要的最少硬币数
        for(int i=1;i<dp.length;i++) {
            for(int coin : coins) {
                //每个dp[j]只和dp[j-coin]
                if(i-coin>=0) {
                    dp[i] = Math.min(dp[i-coin],dp[i]);
                }
            }
            dp[i]+=1;
        }
        return dp[amount]>amount ? -1:dp[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        System.out.println(coinChange.coinChange(new int[]{1,2,5}, 11));
    }
}
