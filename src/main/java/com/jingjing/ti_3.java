package com.jingjing;

import java.util.Scanner;

public class ti_3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();//长度
        int m = sc.nextInt();//询问的次数

        String ss=sc.next();
        int[] array=new int[n];
        for(int i=0;i<n;i++){
            int num=ss.charAt(i);
            array[i]=num;
        }

        int[] num=new int[m];
        int p=0;
        while(sc.hasNextLine()){
            String s=sc.next();//具体操作
            if(s.equals("q")){
                 //查询
                //System.out.println(max(array));
                num[p]=max(array);
                p++;
            }else{
                int x=Integer.valueOf(sc.next());
                int y=Integer.valueOf(sc.next());
                //交换
                change(array,x,y);
            }
        }

        for(int i=0;i<num.length;i++){
            if(num[i]!=0){
                System.out.println(num[i]);
            }
        }


    }

    //交换
    public static void change(int[] array,int x,int y){
        for(int i=x;i<=y;i++){
            if(array[i]==1){
                array[i]=0;
            }
            if(array[i]==0){
                array[i]=1;
            }
        }
    }

    //查找最长子序列
    public static int max(int[] array){
        int max=1;
        int temp=1;
        int i=1;
        while(i<array.length){
            if(array[i]>=array[i-1]){
                temp++;
            }else{
                max=max<temp? temp:max;
                temp=1;
            }
            i++;
        }
        return max;
    }

}
