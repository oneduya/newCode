package com.jingjing;

import java.util.Arrays;
import java.util.Scanner;

public class ti_1 {
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n = sc.nextInt();//第一行的 持有牌的个数
        int[] num1=new int[n];
        int[] num2=new int[n];
        for(int i=0; i<n; i++){//放入数组中
            int num = sc.nextInt();
            num1[i]=num;
        }
        //排序
        Arrays.sort(num1);
        //找到最后三个数字
        int sum1=0;
        for(int i=num1.length-1;i>num1.length-4;i--){
            sum1=sum1+num1[i];
        }

        for(int j=0; j<n; j++){//放入数组中
            int num = sc.nextInt();
            num2[j]=num;
        }
        Arrays.sort(num2);

        int sum2=0;
        for(int i=num2.length-1;i>num2.length-4;i--){
            sum2=sum2+num2[i];
        }

        if(sum1>=sum2){
            System.out.println(sum1);
        }else{
            System.out.println(sum2);
        }
    }
}

