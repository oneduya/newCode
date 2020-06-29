package com.leetcode.hash;

import java.util.HashMap;

/**
 * @ClassName: SubarraySum
 * @Description: 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * @Author: WAHWJ
 * @Date: 2020/5/18 20:56
 * @Version: V0.1
 */
public class SubarraySum {
    public int subarraySum(int[] nums, int k) {
        if(k==0) {
            return 0;
        }
        int count = 0;
        //哈希表用于保存前面的加和中为key的个数
        HashMap<Integer,Integer> map = new HashMap<>();
        //用于计算加和
        int pre = 0;
        //加和为0的初始为1
        map.put(0,1);
        for(int i=0;i<nums.length;i++) {
            pre += nums[i];
            map.put(pre,map.getOrDefault(pre,0)+1);
            //如果加和中存在pre-k说明到当前位置有加和为k的子数组
            if (map.containsKey(pre - k)) {
                count += map.get(pre-k);
            }
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySum subarraySum = new SubarraySum();
        System.out.println(subarraySum.subarraySum(new int[]{1}, 0));
    }
}
