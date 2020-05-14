package com.page2;

import java.util.Arrays;

public class OnlyOnetimeNumber {
    public void FindNumsAppearOnce(int [] array,int num1[] , int num2[]) {
        Arrays.sort(array);
        for(int i=0; i<array.length; i++){
            if(i==0){
                if(array[i]==array[i+1]){
                    continue;
                }
                num1[0] = array[i];
                continue;
            }else if(i==array.length-1){
                if(array[i]==array[i-1]){
                    continue;
                }
                num2[0] = array[i];
                continue;
            }
            else if(array[i]==array[i-1] || array[i]==array[i+1]){
                continue;
            }
            else{
                if(num2[0]!=num1[0]){
                    num2[0] = array[i];
                }else{
                    num1[0] = array[i];
                }
            }
        }
    }

    public static void main(String[] args) {
        OnlyOnetimeNumber oon = new OnlyOnetimeNumber();
        int[] num1 = new int[1];
        int[] num2 = new int[1];
        int[] array = {4,6,2,2,3,3,8,8,9,9,1000000,1000000};
        oon.FindNumsAppearOnce(array,num1,num2);
        System.out.println(111);
    }
}
