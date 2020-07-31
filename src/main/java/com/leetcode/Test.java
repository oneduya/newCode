package com.leetcode;


import com.leetcode.tree.TreeNode;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Semaphore;
import java.util.concurrent.atomic.LongAccumulator;
import java.util.concurrent.locks.ReentrantLock;

public class Test {
	int res = Integer.MAX_VALUE;
	public int findMagicIndex(int[] nums) {
		find(nums,0,nums.length-1);
		return res==Integer.MAX_VALUE? -1:res;
	}


	public void find (int[] nums, int left, int right) {
		if (left>right || res<=left) {
			return;
		}
		int mid = left + (right-left)/2;
		//更新res和right，以找到最小的
		if (nums[mid]==mid) {
			res = Math.min(res,mid);
		}
		else {
			find(nums,left, mid-1);
			find(nums,mid+1,right);
		}
	}

	public static void main(String[] args) {
		Test test = new Test();
		System.out.println(test.findMagicIndex(new int[]{0, 2, 3, 4, 3}));
	}

}


