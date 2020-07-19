package com.leetcode.array;

import java.util.*;

/**
 * @ClassName: CountSmaller
 * @Description: 给定一个整数数组 nums，按要求返回一个新数组 counts。
 * 数组 counts 有该性质： counts[i] 的值是  nums[i] 右侧小于 nums[i] 的元素的数量。
 *
 * @Author: WAHWJ
 * @Date: 2020/7/11 7:56
 * @Version: V0.1
 */
public class CountSmaller {
	/**
	 * 首先将每个数字去重排序后映射到一个数组，这个数组每一个位置对应一个数字出现的次数，并且按大小排序，
	 * 这样我们求一个数后面比它小的数个数的时候，就到这个数组里找到这个数对应的索引index，然后将
	 * 前面比他小的数出现的次数加和就可以
	 * 
	 * @param nums
	 * @return {@link List< Integer>}
	 * @throws
	 * @author WAHWJ 
	 * @date 2020/7/11 WAHWJ
	 */
	public List<Integer> countSmaller(int[] nums) {
		int[] indexes = discretization(nums);
		int[] counts = new int[indexes.length];
		Integer[] result = new Integer[nums.length];
		for (int i=nums.length-1; i>=0; i--) {
			int index = binSearch(indexes,nums[i]);
			int count = 0;
			for (int j=0; j<index;j++) {
				count += counts[j];
			}
			counts[index]++;
			result[i] = count;
		}
		return Arrays.asList(result);
	}

	/**
	 * 二分查找
	 *
	 * @param indexes
     * @param num
	 * @return {@link int}
	 * @throws
	 * @author WAHWJ
	 * @date 2020/7/11 WAHWJ
	 */
	public int binSearch(int[] indexes, int num) {
		int l=0; int r = indexes.length-1;
		while (l<r) {
			int m = (l+r)/2;
			if(indexes[m]<num) {
				l = m+1;
			}
			else {
				r = m;
			}
		}
		return l;
	}

	/**
	 * 对数组进行去重排序
	 *
	 * @param nums
	 * @return {@link int[]}
	 * @throws
	 * @author WAHWJ
	 * @date 2020/7/11 WAHWJ
	 */
	public int[] discretization(int[] nums) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		int[] result = new int[set.size()];
		int i=0;
		for(Integer num : set) {
			result[i++] = num;
		}
		Arrays.sort(result);
		return result;
	}

	int[] temp;
	int[] counter;
	int[] indexer;
	public List<Integer> countSmaller2(int[] nums) {
		List<Integer> res = new ArrayList<>();
		int len = nums.length;
		if (len == 0) {
			return res;
		}
		temp = new int[len];
		counter = new int[len];
		indexer = new int[len];
		for (int i = 0; i < len; i++) {
			indexer[i] = i;
		}
		mergeAndCountSmaller(nums, 0, len - 1);
		for (int i = 0; i < len; i++) {
			res.add(counter[i]);
		}
		return res;
	}

	/**
	 * 针对数组 nums 指定的区间 [l, r] 进行归并排序，在排序的过程中完成统计任务
	 *
	 * @param nums
	 * @param l
	 * @param r
	 * @throws
	 * @author WAHWJ
	 * @date 2020/7/11 WAHWJ
	 */
	public void mergeAndCountSmaller(int[] nums, int l, int r) {
		if (l==r) {
			// 数组只有一个元素的时候，没有比较，不统计
			return;
		}
		int mid = (l+r)/2;
		mergeAndCountSmaller(nums,l,mid);
		mergeAndCountSmaller(nums,mid+1,r);
		// 归并排序的优化，同样适用于该问题
		// 如果索引数组有序，就没有必要再继续计算了
		if (nums[indexer[mid]] > nums[indexer[mid+1]]) {
			mergeOfTwoSortedArrAndCountSmaller(nums,l,r,mid);
		}
	}

	/**
	 * [l, mid] 是排好序的
	 * [mid + 1, r] 是排好序的
	 * 
	 * @param nums
	 * @param l
	 * @param r
	 * @param mid
	 * @throws
	 * @author WAHWJ 
	 * @date 2020/7/11 WAHWJ
	 */
	public void mergeOfTwoSortedArrAndCountSmaller(int[] nums, int l, int r, int mid) {
		for (int i = l; i <= r; i++) {
			temp[i] = indexer[i];
		}
		int i=l; int j=mid+1;
		int k = l;
		while(i<=mid && j<=r) {
			//左边出列的时候，计数
			// 此时 [4,5, 6   | 1,2,3 10 12 13]
			//           mid          j
			if(nums[temp[i]] <= nums[temp[j]]) {
				indexer[k] = temp[i++];
				counter[indexer[k]] += j-mid-1;
				k++;
			}
			else {
				indexer[k++] = temp[j++];
			}
		}
		while(i<=mid) {
			// 此时 j 用完了，[7,8,9 | 1,2,3]
			// 之前的数就和后面的区间长度构成逆序
			indexer[k] = temp[i++];
			counter[indexer[k]] += r-mid;
			k++;
		}
		while(j<=r) {
			// nums[indexes[i]] > nums[indexes[j]] 构成逆序
			indexer[k++] = temp[j++];
		}
	}

	public static void main(String[] args) {
		CountSmaller countSmaller = new CountSmaller();
		System.out.println(countSmaller.countSmaller2(new int[]{5, 2, 6, 1}));
	}
}
