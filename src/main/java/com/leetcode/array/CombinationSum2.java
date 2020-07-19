package com.leetcode.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;

/**
 * @ClassName: CombinationSum2
 * @Description: 给定一个数组 candidates 和一个目标数 target ，找出 candidates 
 * 中所有可以使数字和为 target 的组合。
 * candidates 中的每个数字在每个组合中只能使用一次。
 * @Author: WAHWJ
 * @Date: 2020/7/14 19:29
 * @Version: V0.1
 */
public class CombinationSum2 {
	List<List<Integer>> result;

	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		result = new ArrayList<>();
		trackback(candidates, target, 0, new ArrayList<>());
		System.out.println(result);
		return result;
	}

	public void trackback(int[] candidate, int target, int start, List<Integer> list) {
		if (target == 0) {
			result.add(new ArrayList<>(list));
			return;
		}
		if (start == candidate.length) {
			return;
		}

		for (int i = start; i < candidate.length; i++) {
			//剪枝，如果当前值大于目标值直接打断循环
			if (candidate[i] > target) {
				break;
			}
			//如果当前遍历节点在开始遍历点之后并且和前一个遍历点相同，说明这个点已经遍历过
			if (i > start && candidate[i] == candidate[i - 1]) {
				continue;
			}
			//回溯
			list.add(candidate[i]);
			trackback(candidate, target - candidate[i], i + 1, list);
			list.remove(list.size() - 1);
		}

	}

	public static void main(String[] args) {
		CombinationSum2 combinationSum2 = new CombinationSum2();
		combinationSum2.combinationSum2(new int[]{2, 5, 2, 1, 2}, 5);
	}
}
