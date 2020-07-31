package com.bishi;

import netscape.security.UserTarget;

/**
 * @ClassName: Ali720Second
 * @Description:求区间[l, r]内的幸运数。幸运数定义为，将相邻数位差的绝对值拼成下一个数，重复该操作直到只剩1位。
 * 剩下7的是幸运数。例如，219->18->7或者118->7
 * 条件：1 ≤ l ≤ r ≤ 1e9
 * 思路：根据1,...,k-1位的幸运数，给定首位数字，可以搜索得到k位的幸运数。将所有幸运数排序后进行二分查找。
 * @Author: WAHWJ
 * @Date: 2020/7/20 22:41
 * @Version: V0.1
 */
public class Ali720Second {
	static byte[] bitmap = new byte[1000000000];
	

	public static void setBitmap(int num) {
		int index = num >>> 3;
		int bitIndex = num & 7;
		bitmap[index] |= 1<<(bitIndex-1);
	}

	public static int getBitmap(int num) {
		int index = num >>> 3;
		int bitIndex = num & 7;
		byte tmp = bitmap[index];
		return tmp>>(bitIndex-1) & 1;
	}
	public static void main(String[] args) {
		setBitmap(7);
		System.out.println(getBitmap(7));
	}
}
