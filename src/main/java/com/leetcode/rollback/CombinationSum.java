package com.leetcode.rollback;

import java.util.*;

/**
 * @ClassName: CombinationSum
 * @Description: 给定一个无重复元素的数组 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * candidates 中的数字可以无限制重复被选取。
 * 说明：
 * 所有数字（包括 target）都是正整数。
 * 解集不能包含重复的组合。
 * @Author: WAHWJ
 * @Date: 2020/5/15 13:12
 * @Version: V0.1
 */
public class CombinationSum {
    List<List<Integer>> result;
    List<Integer> list;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        result = new ArrayList<>();
        Arrays.sort(candidates);
        list = new ArrayList<>();
        trackback(candidates,0,target,0);
        return result;
    }

    public void trackback(int[]candidates, int sum, int target,int start) {
        if(sum==target) {
            ArrayList<Integer> tmp = new ArrayList(list);
            result.add(tmp);
        }
        for(int i=start;i<candidates.length;i++) {
            if(sum+candidates[i]>target) {
                break;
            }
            list.add(candidates[i]);
            trackback(candidates,sum+candidates[i],target,i);
            list.remove((Integer) candidates[i]);
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        combinationSum.combinationSum(new int[]{2,3,6,7},7);
        System.out.println(combinationSum.result);
        Arrays.asList(new int[]{2,3,6,7});
    }
}
