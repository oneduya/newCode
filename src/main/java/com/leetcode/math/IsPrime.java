package com.leetcode.math;

import java.util.BitSet;

/**
 * @ClassName: IsPrime
 * @Description: 判断一个数是否是质数
 * @Author: WAHWJ
 * @Date: 2020/7/21 8:14
 * @Version: V0.1
 */
public class IsPrime {
	public static boolean isPrime(int num) {
		double sq = Math.sqrt(num);
		for (int i=2; i<=sq; i++) {
			if (num%i==0) {
				return false;
			}
		}
		return true;
	}

	public static boolean isPrime2(int num) {
		int m = 2;
		int n = num-1;
		while(m<=n) {
			int tmp = m * n;
			if (tmp == num) {
				return false;
			}
			else if (tmp > num) {
				n--;
			}
			else {
				m++;
			}
		}
		return true;
	}
}
