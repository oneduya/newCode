package com.leetcode.jianzhi;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @ClassName: ThreeSum
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/5/21 9:36
 * @Version: V0.1
 */
public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        //用来存答案
        List<List<Integer>> result = new ArrayList<>();
        if(nums == null || nums.length < 3) return result;
        //先排序
        Arrays.sort(nums);
        for(int i=0;i<nums.length;i++) {
            //如果当前数字>0，说明后面的都大于0则不满足条件直接break
            //不需要判断=0，因为可能有0，0，0
            if(nums[i]>0){
                break;
            }
            //前后两个数相等说明已经判断过，跳过
            if(i > 0 && nums[i] == nums[i-1]) continue;
            //双指针分别指向i后面的首尾
            int left = i+1;
            int right = nums.length-1;
            while(left<right) {
                int sum = nums[i]+nums[left]+nums[right];
                if(sum == 0) {
                    //如果相等则放入结果集
                    result.add(Arrays.asList(nums[i],nums[left],nums[right]));
                    //排除重复项
                    while (left<right && nums[right]==nums[right-1]) right--;
                    while (left<right && nums[left]==nums[left+1]) left++;
                    left++;
                    right--;
                }
                //如果比0大则应该移动右指针，反之则移动左指针
                else if(sum>0) {
                    right--;
                }
                else if (sum<0) {
                    left++;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ThreeSum threeSum = new ThreeSum();
        System.out.println(threeSum.threeSum(new int[]{-1, 0, 1, 2, -1, -4}));
    }
}
