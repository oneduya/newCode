package com.leetcode.math;

import org.aspectj.bridge.context.ContextFormatter;

import java.util.Arrays;

/**
 * @ClassName: CountPrime
 * @Description: 返回区间 [2, n) 中有几个素数
 * @Author: WAHWJ
 * @Date: 2020/8/12 23:10
 * @Version: V0.1
 */
public class CountPrime {
	public int countPrime(int n) {
		if (n==1) {
			return 1;
		}
		//用一个数组，一个素数的整数倍肯定不是素数
		boolean[] isPrime = new boolean[n];
		Arrays.fill(isPrime, true);
		//遍历到sqrt(n)就可以结束了
		for (int i = 2; i*i < n; i++) {
			if (isPrime[i]) {
				//为了避免和前面已经判断过的重复，这里可以直接从i^2开始
				for (int j = i*i; j < n; j+=i) {
					isPrime[j] = false;
				}
			}
		}
		int count = 0;
		for (int i = 2; i < n; i++) {
			if (isPrime[i]) {
				count++;
			}
		}
		return count;
	}
}
