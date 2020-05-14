package com.leetcode.huadongchuangkou;

import java.util.ArrayDeque;

/**
 * @ClassName: MaxSlidingWindow
 * @Description: 给定一个数组 nums，有一个大小为 k 的滑动窗口从数组的最左侧移动到数组的最右侧。你只可以看到在滑动窗口内的 k 个数字。滑动窗口每次只向右移动一位。
 *
 * 返回滑动窗口中的最大值。
 * @Author: WAHWJ
 * @Date: 2020/5/7 13:36
 * @Version: V0.1
 */
public class MaxSlidingWindow {

    ArrayDeque<Integer> deque = new ArrayDeque<>();
    int[] nums;
    /**
     * @Author WAHWJ
     * @Description
     * 清理双向队列 :
     *      *   - 只保留当前滑动窗口中有的元素的索引。
     *      *   - 移除比当前元素小的所有元素，它们不可能是最大的。
     * @Date 13:41 2020/5/7
     * @Param [i, k]
     * @return void
     **/
    public void cleanDeque(int i,int k) {
        if(!deque.isEmpty() && deque.getFirst()==i-k) {
            deque.removeFirst();
        }
        while(!deque.isEmpty() && nums[deque.getLast()]<nums[i]) {
            deque.removeLast();
        }
    }

    /**
     * @Author WAHWJ
     * @Description //法1：双端队列法
     * 算法非常直截了当：
     * 1.处理前 k 个元素，初始化双向队列。
     * 2.遍历整个数组。在每一步 :
     * 3.清理双向队列 :
     *   - 只保留当前滑动窗口中有的元素的索引。
     *   - 移除比当前元素小的所有元素，它们不可能是最大的。
     * 4.将当前元素添加到双向队列中。
     * 5.将 deque[0] 添加到输出中。
     * 6.返回输出数组。
     * @Date 13:37 2020/5/7
     * @Param [nums, k]
     * @return int[]
     **/
    public int[] maxSlidingWindow1(int[] nums, int k) {
        this.nums = nums;
        int[] result = new int[nums.length-k+1];
        for(int i=0;i<k;i++) {
            cleanDeque(i,k);
            deque.addLast(i);
            if(result[0]<nums[i]){
                result[0] = nums[i];
            }
        }

        for(int i=k;i<nums.length;i++) {
            cleanDeque(i, k);
            deque.addLast(i);
            result[i - k + 1] = nums[deque.getFirst()];
        }
        return result;
    }
    
    /**
     * @Author WAHWJ
     * @Description 动态规划算法十分直截了当：
     *
     * 从左到右遍历数组，建立数组 left。
     *
     * 从右到左遍历数组，建立数组 right。
     *
     * 建立输出数组 max(right[i], left[i + k - 1])，其中 i 取值范围为 (0, n - k + 1)。
     * @Date 14:01 2020/5/7
     * @Param [nums, k]
     * @return int[]
     **/
    public int[] maxSlidingWindow2(int[] nums, int k) {
        int[] left = new int[nums.length];
        left[0] = nums[0];
        int[] right = new int[nums.length];
        right[nums.length-1] = nums[nums.length-1];
        for(int i=1;i<nums.length;i++) {
            if(i/k==0) {
                left[i] = nums[i];
                continue;
            }
            left[i] = left[i-1]>nums[i] ? left[i-1]:nums[i];

            int j = nums.length - i - 1;
            if ((j + 1) % k == 0) right[j] = nums[j];  // block_end
            else right[j] = Math.max(right[j + 1], nums[j]);
        }
        int[] result = new int[nums.length-k+1];
        for(int i=0;i<nums.length-k+1;i++) {
            result[i] = Math.max(right[i],left[i+k-1]);
        }
        return result;
    }

    public static void main(String[] args) {
        MaxSlidingWindow maxSlidingWindow = new MaxSlidingWindow();
        maxSlidingWindow.maxSlidingWindow2(new int[]{1,3,-1,-3,5,3,6,7},3);
    }
}
