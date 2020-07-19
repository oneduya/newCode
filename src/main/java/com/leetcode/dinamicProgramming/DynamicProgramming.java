package com.leetcode.dinamicProgramming;

import java.util.Scanner;

public class DynamicProgramming {
    public static int program(int value, int num, int[] type, int[] magic){
        int factor = 0;
        if(value == 0){
            return factor;
        }
        if(num < type.length-1){
            if(value>=type[num]){
                factor += Math.max(program(value-type[num],num+1,type,magic)+magic[num],program(value,num+1,type,magic));
            }else{
                factor += program(value,num+1,type,magic);
            }
        }
        if(num == type.length-1){
            if(value>=type[num]){
                factor += magic[num];
            }
        }
        return factor;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext()) {
            int n = sc.nextInt();
            int value = sc.nextInt();
            int[] type = new int[n];
            int[] magic = new int[n];
            for(int i=0;i<n;i++){
                type[i] = sc.nextInt();
                magic[i] = sc.nextInt();
            }
            int result = program(value,0,type,magic);
            System.out.println(111);
        }
    }
}
