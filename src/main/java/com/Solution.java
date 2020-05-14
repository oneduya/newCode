package com;

import java.util.*;

/**
 * @ClassName: Solution
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/4/13 23:29
 * @Version: V0.1
 */
public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        HashMap<Integer,Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++){
            if(map.get(target-nums[i])!=null){
                result[0] = map.get(target-nums[i]);
                result[1] = i;
                return result;
            }else{
                map.put(nums[i],i);
            }
        }
        return result;
    }

    public static String addBinary(String a, String b) {
        StringBuffer result = new StringBuffer();

        int flag = 0;
        int alength = a.length();
        int blength = b.length();
        int i = alength-1;
        int j = blength-1;
        while(i>=0 || j>=0) {
            char p = i>=0 ? a.charAt(i) : '0';
            char q = j>=0 ? b.charAt(j) : '0';
            int num = p-'0' + q-'0'+flag;
            flag = num/2;
            result.insert(0,num%2+"");
            i--;
            j--;
        }
        if(flag>0){
            result.insert(0,flag);
        }
        return result.toString();
    }

    public static void main(String[] args) {
        int[] b = {-3,4,3,90};
        //int[] a = twoSum(b,0);
        String result = addBinary("11","1");
        System.out.println(result);
        System.out.println(2/2);
    }
}
