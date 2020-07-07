package com.leetcode;

import com.Solution;
import com.leetcode.Tree.TreeNode;
import com.leetcode.list.ListNode;
import com.oracle.jrockit.jfr.Producer;
import com.sun.deploy.uitoolkit.impl.fx.FXPluginToolkit;
import com.sun.org.apache.xerces.internal.xs.XSTerm;
import javafx.util.Pair;

import javax.swing.text.StyledEditorKit;
import javax.xml.stream.events.Characters;
import java.awt.font.TextAttribute;
import java.lang.ref.PhantomReference;
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
	public int findLongestSon(int[] nums) {
		//tails[i]表示i+1长度子序列的结尾数字是几，这样可以保证tails是递增数列
		//我们更新tails的方式是从前到后遍历数组nums，
		// 对于每个数字，找到tails中可以插入的位置并替换该位置上的数
		//这样可以保证找到到当前数字，它的最长长度是多少
		int[] tails = new int[nums.length];
		int ans = 0;
		for (int num : nums) {
			int l = 0;
			int r = ans;
			while (l<r) {
				int mid = (l+r)/2;
				//如果当前mid+1长度的子序列最后一个数大于等于num，则向前寻找，或者就放到当前位置（等于）
				if (tails[mid]>=num) {
					r = mid;
				}
				//如果小于则向后寻找，直到找到比前边的数都大且小于等于后面的数的位置
				else {
					l = mid+1;
				}
			}
			//替换当前位置的数字
			tails[l] = num;
			//如果可以放到ans位置，则更新ans
			if(r==ans) {
				ans++;
			}
		}
		return ans;
	}



	public static void main(String[] args) throws Exception {
		Test test = new Test();
		System.out.println(test.findLongestSon(new int[]{1,2,3,4,5,6,7,8}));
	}
}

