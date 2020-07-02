package com.leetcode;

import com.Solution;
import com.leetcode.Tree.TreeNode;
import com.leetcode.list.ListNode;
import com.oracle.jrockit.jfr.Producer;
import com.sun.org.apache.xerces.internal.xs.XSTerm;
import javafx.util.Pair;

import javax.swing.text.StyledEditorKit;
import javax.xml.stream.events.Characters;
import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.locks.*;
import java.util.function.Consumer;

/**
 * @ClassName: Test
 * @Description: 你有一套活字字模 tiles，其中每个字模上都刻有一个字母 tiles[i]。返回你可以印出的非空字母序列的数目。
 * <p>
 * 注意：本题中，每个活字字模只能使用一次。
 * @Author: WAHWJ
 * @Date: 2020/4/25 10:54
 * @Version: V0.1
 */
public class Test {
	public int maxSubArray(int[] nums) {
		int[] res = fenzhi(nums,0,nums.length-1);
		return res[2];
	}

	//定义int[0]表示 [l, r][l,r] 内以 l 为左端点的最大子段和,
	// int[1]表示 [l, r][l,r] 内以 r 为右端点的最大子段和,
	// int[2]表示 [l, r][l,r] 内的最大子段和,
	// int[3]表示 [l, r][l,r] 的区间和
	public int[] fenzhi(int[] nums, int left, int right) {
		if(left==right) {
			return new int[]{nums[left], nums[left], nums[left], nums[left]};
		}
		int mid = (left+right)>>1;
		int[] leftArray = fenzhi(nums,left,mid);
		int[] rightArray = fenzhi(nums,mid+1,right);
		int[] ans = new int[4];
		ans[0] = Math.max(leftArray[0],leftArray[3]+rightArray[0]);
		ans[1] = Math.max(rightArray[1],rightArray[3]+leftArray[1]);
		ans[3] = leftArray[3] + rightArray[3];
		ans[2] = Math.max(Math.max(leftArray[2],rightArray[2]),leftArray[1]+rightArray[0]);
		return ans;
	}

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		Test test = new Test();
//		System.out.println(test.maxSubArray(new int[]{-2,1,-3,4,-1,2,1,-5,4}));
		final CountDownLatch countDownLatch = new CountDownLatch(21);
		for (int i = 0; i < 20; i++) {
			new Thread(() -> {// Lambda 表达式的运用
				try {
					Thread.sleep(1000);
					countDownLatch.countDown();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} finally {
					System.out.println(Thread.currentThread() + " has down!");
				}

			}).start();
		}
		countDownLatch.await();
		System.out.println("finish");
		CyclicBarrier
	}


}
