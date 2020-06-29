package com.erfenSeach;

import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

/**
 * @ClassName: Search
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/5/20 11:49
 * @Version: V0.1
 */
public class Search {
    public int search(int[] nums, int target) {
        //首先定义low和high
        int low=0;
        int high=nums.length-1;
        while(low<=high) {
            int mid = (high-low)/2 + low;
            //如果mid位置满足条件直接返回
            if(nums[mid]==target){
                return mid;
            }
            //如果target！=nums[mid]并且左半部分为有序数组
            if (nums[low] <= nums[mid]) {
                //如果target在左半部分
                if (target >= nums[low] && target < nums[mid]) {
                    high = mid - 1;
                } else {//在右半部分
                    low = mid + 1;
                }
            }
            //如果右半部分有序
            else {
                //如果target在右半部分
                if(target>nums[mid] && target<=nums[high]) {
                    low = mid + 1;
                }else{
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Search search = new Search();
        System.out.println(search.search(new int[]{3,1}, 1));

    }
}
