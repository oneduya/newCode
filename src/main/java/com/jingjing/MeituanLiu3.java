package com.jingjing;

import java.util.Scanner;

public class MeituanLiu3 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] array = new int[n+1];
        for (int i = 1; i <= n; i++) {
            array[i] = sc.nextInt();
        }
        int[] dp = new int[n+1];
        dp[0] = 1;
        for(int i=1;i<=n;i++){
            if(array[i]%i==0){
                dp[i]=dp[i-1];
            }
            for(int j=i-1;j>0;j--){
                if(array[i]%j==0){
                    dp[j]+=1;
                }
            }
        }
        int sum = 0;
        for(int i=1;i<=n;i++){
            sum += dp[i];
        }
        System.out.println(sum);
    }
}
