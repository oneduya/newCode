package com.leetcode.huadongchuangkou;

/**
 * @ClassName: MinSubArrayLen
 * @Description: 给定一个含有 n 个正整数的数组和一个正整数 s ，
 * 找出该数组中满足其和 ≥ s 的长度最小的连续子数组，并返回其长度。如果不存在符合条件的连续子数组，返回 0。
 * @Author: WAHWJ
 * @Date: 2020/5/7 10:46
 * @Version: V0.1
 */
public class MinSubArrayLen {
    public int minSubArrayLen(int s, int[] nums) {
        int l = 0;
        int r = 0;
        int sum = 0;
        int result = nums.length;
        while(r<nums.length && sum<s) {
            sum += nums[r++];
        }
        if(sum<s) {
            return 0;
        }
        while(l<=r) {
            while(sum>=s) {
                if(r-l<result) {
                    result = r-l;
                }
                sum -= nums[l];
                l++;
            }
            if(r<nums.length) {
                sum += nums[r++];
            }else {
                break;
            }
        }
        return result;
    }

    public static void main(String[] args) {
        MinSubArrayLen minSubArrayLen = new MinSubArrayLen();
        minSubArrayLen.minSubArrayLen(7,new int[]{2,3,1,2,4,3});
    }
}
