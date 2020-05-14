package com.page2;

import java.util.ArrayList;

public class SSum {
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> result = new ArrayList();
        int highest = sum - sum / 2;
        int p1 = 1;
        int p2 = 2;
        int sumtmp = 3;
        while (p1 < p2 && p2 <= highest) {
            if (sumtmp == sum) {
                ArrayList<Integer> list = new ArrayList();
                for (int i = p1; i <= p2; i++) {
                    list.add(i);
                }
                result.add(list);
                sumtmp -= p1;
                p1++;
            } else if (sumtmp < sum) {
                p2++;
                sumtmp += p2;
            } else if (sumtmp > sum) {
                sumtmp -= p1;
                p1++;
            }
        }
        return result;
    }

    public String ReverseSentence(String str) {
        if (str == null) {
            return null;
        }
        if (str.equals(" ") || str.equals("")) {
            return str;
        }
        String[] strarray = str.split(" ");
        String result = "";
        for (int i = strarray.length - 1; i >= 0; i--) {
            result += strarray[i] + " ";
        }
        return result.substring(0, str.length());
    }

    public boolean isContinuous(int[] numbers) {
        int[] d = new int[14];
        d[0] = -5;
        int len = numbers.length;
        int max = -1;
        int min = 14;
        for (int i = 0; i < len; i++) {
            d[numbers[i]]++;
            if (numbers[i] == 0) {
                continue;
            }
            if (d[numbers[i]] > 1) {
                return false;
            }
            if (numbers[i] > max) {
                max = numbers[i];
            }
            if (numbers[i] < min) {
                min = numbers[i];
            }

        }
        if (max - min < 5) {
            return true;
        }
        return false;
    }

    public int LastRemaining_Solution(int n, int m) {
        if(n<1 || m<1){
            return -1;
        }
        int[] array = new int[n];
        int i=-1;
        int tmp = 0;
        int step = 0;
        while(tmp<n-1){
            i++;
            if(i>=n){
                i %= n;
            }
            step++;
            if(step==m){
                array[i]=1;
                step=0;
            }
        }
        return i;
    }

    public static void main(String[] args) {
        String a = " ";
        int ab = 123;
        int cd = 16;
        System.out.println(ab%cd);
        System.out.println(ab&(cd-1));

    }
}
