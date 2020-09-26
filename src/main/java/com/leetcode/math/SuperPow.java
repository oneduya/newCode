package com.leetcode.math;

/**
 * @ClassName: SuperPow
 * @Description: 快速取幂运算，
 * 的任务是计算 a的b次方对 1337 取模，a 是一个正整数，b 是一个非常大的正整数且会以数组形式给出。
 * @Author: WAHWJ
 * @Date: 2020/8/19 9:25
 * @Version: V0.1
 */
public class SuperPow {
	public static final int BASE = 1337;
	/**
	 * 求a的b次方，b比较小
	 *
	 * @param a
	 * @param b
	 * @return {@link int}
	 * @throws
	 * @author WAHWJ
	 * @date 2020/8/19 WAHWJ
	 */
	public int helpPow(int a, int b) {
		if (b==0) {
			return 1;
		}
		a = a % BASE;
		if (b%2==1) {
			//b为奇数时，把它变为偶数求幂并乘a
			return helpPow(a,b-1) * a % BASE;
		}else {
			//b为偶数时，幂减半，结果2次方
			int tmp = helpPow(a,b/2);
			return tmp * tmp % BASE;
		}
	}

	/**
	 * 求a的b次方，b是一个数组，因为可能很大用int类型可能表示不了，
	 * 可以用(a * b) % k = (a % k)(b % k) % k来求解
	 *
	 * @param a
	 * @param b
	 * @return {@link int}
	 * @throws
	 * @author WAHWJ
	 * @date 2020/8/19 WAHWJ
	 */
	public int superPow(int a, int[] b) {
		if (b.length==0) {
			return 1;
		}
		int res = 1;
		for (int i=0; i<b.length; i++) {
			int part1 = helpPow(a,b[i]);
			int part2 = helpPow(res,10);
			res = part1 * part2 % BASE;
		}
		return res;
	}

	public static void main(String[] args) {
		SuperPow superPow = new SuperPow();
		System.out.println(superPow.superPow(2147483647, new int[]{2, 0, 0}));
	}

}
