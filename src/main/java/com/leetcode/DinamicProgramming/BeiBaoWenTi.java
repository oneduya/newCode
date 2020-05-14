package com.leetcode.DinamicProgramming;

import java.util.Scanner;

public class BeiBaoWenTi {
    public static void main(String[] args) {
        // TODO 自动生成的方法存根
        Scanner sc = new Scanner(System.in);
        while (sc.hasNextInt()) {
            // 0/1背包问题
            int n = sc.nextInt();
            int v = sc.nextInt();// 背包容量
            int[] t = new int[n + 1];
            int[] p = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                t[i] = sc.nextInt();
                p[i] = sc.nextInt();
            }
            int sum = 0;
            boolean flag = false;
            for (int i = 1; i <= n; i++) {
                if (t[i] <= v) {
                    flag = true;
                }
                sum += t[i];
            }
            if (sum <= v) {
                int valueSum = 0;
                for (int value : p) {
                    valueSum += value;
                }
                System.out.println(valueSum);
                for (int i = 1; i <= n; i++) {
                    System.out.print(i + " ");
                }
                System.out.println();
                continue;
            }
            if (!flag) {
                System.out.println(0);
                System.out.println("No");
                continue;
            }
            int[] res = new int[n + 1];// 物品选择结果
            int[][] dp = new int[n + 1][v + 1];// dp[i][j]表示前i个物品放入容量为j的背包时的最大值
            for (int j = 0; j <= v; j++) {
                dp[0][j] = 0;
            }
            for (int i = 1; i <= n; i++) {
                for (int j = 0; j <= v; j++) {
                    if (j >= t[i]) {// 背包能方向第i件物品
                        dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - t[i]] + p[i]);
                    } else {// 放不下第i件物品
                        dp[i][j] = dp[i - 1][j];
                    }
                }
            }
            System.out.println(dp[n][v]);//此时dp[n][v]表示前n个物品放入容量为v的背包能产生的最大价值
            for (int i = n; i > 0; i--) {
                if (dp[i][v] == dp[i - 1][v]) {
                    res[i] = 0;// 第i件物品没有添加进入背包
                } else {
                    res[i] = 1;
                    v -= t[i];
                }
            }
            for (int i = 0; i < n + 1; i++) {
                if (res[i] == 1) {
                    System.out.print(i + " ");
                }
            }
        }
    }
}
