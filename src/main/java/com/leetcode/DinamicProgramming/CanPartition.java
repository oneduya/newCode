package com.leetcode.DinamicProgramming;

import com.leetcode.Tree.TreeNode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @ClassName: CanPartition
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/5/18 14:51
 * @Version: V0.1
 */
public class CanPartition {
    public boolean canPartition(int[] nums) {
        int target = 0;
        for(int i=0;i<nums.length;i++) {
            target += nums[i];
        }
        if((target&1) != 0) {
            return false;
        }
        target = target>>1;
        //dp[i][j]用于存放索引从0到i之间有没有加和为j的组合
        boolean dp[][] = new boolean[nums.length][target+1];
        //第0个数字只有当j等于nums[0]的时候才为true
        if(nums[0]<=target) {
            dp[0][nums[0]] = true;
        }

        for(int i=1;i<dp.length;i++) {
            for(int j=0;j<=target;j++) {
                //当前数字比加和j小的时候要考虑加进去和不加进去两种情况
                if(nums[i]<=j) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j-nums[i]];
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
            if(dp[i][target]==true) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CanPartition canPartition = new CanPartition();
        System.out.println(canPartition.canPartition(new int[]{1, 2, 3, 5}));
        
    }
}
