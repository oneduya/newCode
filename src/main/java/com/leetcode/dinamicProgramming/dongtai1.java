package com.leetcode.dinamicProgramming;

import java.util.Scanner;

public class dongtai1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNextInt()) {
            int n = sc.nextInt();
            int x = sc.nextInt();
            int[] array = new int[x+1];
            for (int i = 0; i < x+1; i++) {
                array[i] = 100007;
            }
            int[] price = new int[n];
            for (int i = 0; i < n; i++) {
                price[i] = sc.nextInt();
            }
            //动态规划，最外层循环是价格表，只循环一次，array存储凑单j需要的最少金额
            for (int k = 0; k < n; k++) {
                //money从大到小保证每个价格都只存放一次，如果本次加入6，从上往下存储有6的最小值，下次进来5，在大的价格规划的时候就不会考虑这个值对小价格的影响
                for (int money = x; money >=0; money--) {
                    if (money > price[k]) {
                        array[money] = Math.min(array[money], array[money - price[k]] + price[k]);
                    } else {
                        array[money] = Math.min(array[money], price[k]);
                    }
                }
            }
            System.out.println(array[x]);
        }
    }
}
