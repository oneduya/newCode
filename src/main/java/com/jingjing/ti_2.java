package com.jingjing;

import java.util.Scanner;

public class ti_2 {
    static int[] array=new int[100001];
    static int[] dp=new int[100001];
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//第一行的 长度
        if(n==0){
            System.out.println(0);
        }
        //int[] array=new int[n];
        for(int i=0;i<n;i++){
            int num=sc.nextInt();
            array[i]=num;
        }
        //结果
        long res=-1;
        //动态规划
        //int[] dp=new int[n];

        for(int i=0;i<n;i++){
            dp[i]=1;
            for(int j=0;j<i;j++){
                if(i-j<=2 && array[i]>array[j] && dp[j]+1>dp[i]){
                    dp[i]=dp[j]+1;
                }
            }
            res=Math.max(res,dp[i]);
        }
        System.out.println(res);
    }
}
