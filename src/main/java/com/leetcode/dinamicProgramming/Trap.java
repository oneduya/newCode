package com.leetcode.dinamicProgramming;

/**
 * @ClassName: Trap
 * @Description: 42.给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。
 * @Author: WAHWJ
 * @Date: 2020/6/29 10:49
 * @Version: V0.1
 */
public class Trap {

	/**
	 * 备忘录解法
	 *
	 * @param height
	 * @return {@link int}
	 * @throws
	 * @author WAHWJ
	 * @date 2020/8/16 WAHWJ
	 */
	public int trap1(int[] height) {
		int len = height.length;
		int[] left = new int[len];
		int[] right = new int[len];
		left[0] = height[0];
		right[len-1] = height[len-1];
		for (int i = 1; i < len; i++) {
			left[i] = Math.max(height[i],left[i-1]);
		}
		for (int i = len-2; i >= 0; i--) {
			right[i] = Math.max(height[i],right[i+1]);
		}
		int count = 0;
		for (int i=1; i<len; i++) {
			count += Math.min(left[i],right[i])-height[i];
		}
		return count;
	}

	/**
	 * 其实这个问题要这么思考，我们只在乎 min(l_max, r_max)。对于上图的情况，
	 * 我们已经知道 l_max < r_max 了，至于这个 r_max 是不是右边最大的，不重要，
	 * 重要的是 height[i] 能够装的水只和 l_max 有关。
	 *
	 * @param height
	 * @return {@link int}
	 * @throws
	 * @author WAHWJ
	 * @date 2020/8/16 WAHWJ
	 */
	public int trap2(int[] height) {
		int len = height.length;
		if (len==0) {
			return 0;
		}
		int left = 0;
		int right = len-1;
		int lmax = height[0];
		int rmax = height[len-1];
		int count=0;
		while (left <= right) {
			lmax = Math.max(height[left],lmax);
			rmax = Math.max(height[right],rmax);
			if (lmax < rmax) {
				count += lmax - height[left];
				left++;
			}
			else {
				count +=rmax - height[right];
				right--;
			}
		}
		return count;
	}
}
