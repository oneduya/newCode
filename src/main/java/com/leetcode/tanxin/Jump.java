package com.leetcode.tanxin;

/**
 * @ClassName: Jump
 * @Description: 给定一个非负整数数组，你最初位于数组的第一个位置。
 *
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 *
 * 你的目标是使用最少的跳跃次数到达数组的最后一个位置。
 * @Author: WAHWJ
 * @Date: 2020/7/4 23:17
 * @Version: V0.1
 */
public class Jump {
	/**
	 * 核心思想是，我在当先步，查看我能到的范围内，下一步走的更远的一个位置，走过去
	 *
	 * @param nums
	 * @return {@link int}
	 * @throws
	 * @author WAHWJ
	 * @date 2020/7/4 WAHWJ
	 */
	public int jump(int[] nums) {
		//定义起始位置
		int start = 0;
		//步数
		int step = 0;
		while(start<nums.length-1) {
			step++;
			//如果当前可达到最远位置超过最后位置
			if(start+nums[start] >= nums.length-1) {
				return step;
			}
			//记录下一步最大可达位置，和可以达到该位置的这一步走到的位置
			int maxIndex = start;int max = start;
			for (int i = start; i <= start+nums[start]; i++) {
				//如果大于则更新
				if(i<nums.length && i+nums[i] > max) {
					max = i+nums[i];
					maxIndex = i;
				}
			}
			//更新当前位置
			start = maxIndex;
		}
		return step;
	}

	/**
	 * 维护当前能够到达的最大下标位置，记为边界。我们从左到右遍历数组，到达边界时，更新边界并将跳跃次数增加 1
	 *
	 * @param nums
	 * @return {@link int}
	 * @throws
	 * @author WAHWJ
	 * @date 2020/7/4 WAHWJ
	 */
	public int jump2(int[] nums) {
		int length = nums.length;
		int end = 0;
		int maxPosition = 0;
		int steps = 0;
		for (int i = 0; i < length - 1; i++) {
			maxPosition = Math.max(maxPosition, i + nums[i]);
			if (i == end) {
				end = maxPosition;
				steps++;
			}
		}
		return steps;
	}
}
