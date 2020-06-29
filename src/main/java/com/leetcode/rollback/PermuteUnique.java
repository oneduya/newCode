package com.leetcode.rollback;

import java.lang.reflect.Array;
import java.util.*;

/**
 * @ClassName: PermuteUnique
 * @Description: 给定一个可包含重复数字的序列，返回所有不重复的全排列。
 * @Author: WAHWJ
 * @Date: 2020/5/16 21:09
 * @Version: V0.1
 */
public class PermuteUnique {
    List<List<Integer>> result;
    public List<List<Integer>> permuteUnique(int[] nums) {
        result = new ArrayList<>();
        int size = nums.length;
        //先排序，让重复数字相邻
        Arrays.sort(nums);
        //利用list来遍历所有可能性
        List<Integer> list = new ArrayList();
        for(int num:nums) {
            list.add(num);
        }
        trackback(list,0,size);
        return result;
    }

    /**
     * @Author WAHWJ
     * @Description 回溯法，最重要的是去重，我们用简单的数字交换来遍历所有可能性，再用条件语句来判断是否重复
     * 如1122，如果start=0，i=3，在start到i之间已经有一个2，交换可以跳过，因为通过2112->2121也可以获得同样的结果
     * @Date 22:01 2020/5/16
     * @Param [list, start, size]
     * @return void
     **/
    public void trackback(List<Integer> list,int start, int size) {
        //满足条件则放入结果集
        if(start == size) {
            result.add(new ArrayList<Integer>(list));
        }
        for(int i=start;i<size;i++) {
            //查看从start到i的子集中有没有和list[i]相等的数字，如果有的话则不需要交换，因为和之前的交换已经重复
            if(!list.subList(start,i).contains(list.get(i))) {
                Collections.swap(list,start,i);
                trackback(list,start+1,size);
                Collections.swap(list,start,i);
            }
        }
    }

    public static void main(String[] args) {
        PermuteUnique permuteUnique = new PermuteUnique();
        System.out.println(permuteUnique.permuteUnique(new int[]{2,2,1,1}));
    }
}
