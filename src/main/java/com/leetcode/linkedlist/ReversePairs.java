package com.leetcode.linkedlist;

/**
 * @ClassName: ReversePairs
 * @Description: 给定一个数组 nums ，如果 i < j 且 nums[i] > 2*nums[j] 我们就将 (i, j) 称作一个重要翻转对。
 * @Author: WAHWJ
 * @Date: 2020/4/24 14:25
 * @Version: V0.1
 */
public class ReversePairs {
    /*public int reversePairs(int[] nums) {
        int count = mergeCore(nums, 0, nums.length-1);
        //System.out.println(count);
        return count;
    }

    public int mergeCore(int[] nums, int start, int end) {
        int count = 0;
        if(start>=end){
            return 0;
        }
        int mid = (start+end)/2;
        count = mergeCore(nums, start, mid) + mergeCore(nums, mid+1, end);

        int i = start,j = mid + 1;
        int reveseCountj = mid + 1;
        int[] temp = new int[end-start+1];
        int temploc = 0;

        while(i<=mid && j<=end) {
            if(reveseCountj<=end && ((nums[i] >> 1) + (nums[i] & 1)) > nums[reveseCountj]){
                count += mid-i+1;
                reveseCountj++;
                continue;
            }
            if(nums[i]<=nums[j]) {
                temp[temploc++] = nums[i++];
            }else{
                temp[temploc++] = nums[j++];
            }
        }
        while(i<=mid && reveseCountj<=end) {
            if(((nums[i] >> 1) + (nums[i] & 1)) > nums[reveseCountj]){
                count += mid-i+1;
                reveseCountj++;
            }else {
                temp[temploc++] = nums[i++];
            }
        }
        while(i<=mid) {
            temp[temploc++] = nums[i++];
        }
        while(j<=end) {
            temp[temploc++] = nums[j++];;
        }
        for(int k=0;k<temp.length;k++) {
            nums[start+k] = temp[k];
        }
        return count;
    }*/

    public static int reversePairs(int[] nums) {
        int len = nums.length;
        if (len < 2) {
            return 0;
        }
        int[] temp = new int[len];//辅助数组
        return merge(nums, 0, len - 1, temp);
    }

    public static int merge(int[] nums, int left, int right, int[] temp) {
        if (left >= right) {
            return 0;//只有一个元素
        }

        int mid = left + (right - left) / 2;
        //左右的逆序对
        int leftPairs = merge(nums, left, mid, temp);
        int rightPairs = merge(nums, mid + 1, right, temp);

        //跨域左右的
        int cross = mergeAndCount(nums, left, mid, right, temp);
        return leftPairs + rightPairs + cross;
    }

    public static int mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];//把序列放入数组
        }

        int i = left;
        int j = mid + 1;//右边的起始点

        int count = 0;

        while (i <= mid && j <= right) {
            if (((nums[i] >> 1) + (nums[i] & 1)) > nums[j]) {
                count += mid - i + 1;
                j++;
            } else {
                i++;
            }
        }
        i = left;
        j = mid + 1;
        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;

            } else {//左边数组的元素比右边的大
                nums[k] = temp[j];
                j++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        ReversePairs reversePairs = new ReversePairs();
        int count = reversePairs.reversePairs(new int[]{2147483647, 2147483647, -2147483647, -2147483647, -2147483647, 2147483647});
        System.out.println(count);
    }
}
