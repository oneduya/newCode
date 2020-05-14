package com.jingjing;

import java.util.ArrayList;
import java.util.Scanner;

public class Zhaohang2 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        while (T > 0) {
            int n = sc.nextInt();
            int[] length = new int[n];
            int[] weight = new int[n];
            for(int i=0; i<n; i++){
                length[i] = sc.nextInt();
            }
            for(int i=0; i<n; i++){
                weight[i] = sc.nextInt();
            }

            for(int i=1;i<length.length;i++){
                for(int j=i;j>0;j--){
                    if(length[j]<length[j-1]){
                        int temp = length[j];
                        length[j] = length[j-1];
                        length[j-1]=temp;
                        temp = weight[j];
                        weight[j] = weight[j-1];
                        weight[j-1]=temp;
                    }
                }
            }
            int result = 0;
            ArrayList<Integer> list = new ArrayList();
            for(int i=0;i<n;i++){
                list.add(i);
            }
            while(list.size()>1){
                ArrayList<Integer> templist = new ArrayList<>();
                int tmp = weight[list.get(0)];
                int size = list.size();
                for(int i=1;i<size;i++){
                    if(weight[list.get(i)]>=tmp){
                        tmp=weight[list.get(i)];
                    }else{
                        templist.add(list.get(i));
                    }
                }
                list = templist;
                result++;
            }
            result+=list.size();
            System.out.println(result);
            T--;
        }
    }


}
