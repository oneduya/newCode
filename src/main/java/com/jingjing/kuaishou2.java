package com.jingjing;

import java.util.ArrayList;
import java.util.Scanner;

public class kuaishou2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        String str = sc.nextLine();
        if(str.equals("")){
            System.out.println(-1);
            return;
        }
        String[] strarr = str.split(" ");
        int[] array = new int[strarr.length];
        for(int i=0;i<array.length;i++){
            array[i] = Integer.parseInt(strarr[i]);
        }
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for(int i=0;i<array.length;i++){
            if(array[i]>=max1){
                max2 = max1;
                max1 = array[i];
            }
            if(array[i]<max1 && array[i]>max2){
                max2 = array[i];
            }
            if(array[i]<max1 && array[i]>=max2){
                list.add(i);
            }
        }
        if(list.size() != 0){
            String result = "";
            for(int index : list){
                result+=index + " ";
            }
            System.out.println(result.substring(0,result.length()-1));
        }else{
            System.out.println(-1+"");
        }
        System.out.println(Integer.MIN_VALUE);
    }
}
