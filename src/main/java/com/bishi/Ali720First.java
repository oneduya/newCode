package com.bishi;

import java.util.Arrays;
import java.util.Scanner;

/**
 * @ClassName: Ali720First
 * @Description:给定N和K，求互不相同的正整数x,y,z使得x+y+z=N，且gcd(x,y)=gcd(x,z)=gcd(y,z)=K。
 * 条件：1 ≤N, K≤ 1e18
 * 思路：等式两边除K，得到x'+y'+z'=N'=N/K，且x',y',z'两两互素。
 * 当N'为偶数，直接构造x'=1, y'=N'/2, z' = y'-1满足条件。
 * 当N'为奇数，另x'=1,则y'+z'=N'-1。由于N'-1为偶数且y'和z'互素，必然有y',z'都为奇数。令y'=3,5,..., N' / 2逐个搜索即可。
 * 3
 *
 * 6 1
 * 12 4
 * 38 2
 *
 * 1 2 3
 * -1
 * 6 10 22
 *
 * @Author: WAHWJ
 * @Date: 2020/7/20 21:00
 * @Version: V0.1
 */
public class Ali720First {
	/**
	 * 求a、b的最大公约数
	 *
	 * @param a
     * @param b
	 * @return {@link int}
	 * @throws
	 * @author WAHWJ
	 * @date 2020/7/20 WAHWJ
	 */
	public int gdc(int a, int b) {
		if (b==0) {
			return a;
		}
		return gdc(b,a%b);
	}

	public static void findThree(long n, long k) {
		if (n % k !=0) {
			System.out.println(-1);
			return;
		}
		long num = n/k;
		if(num<6) {
			System.out.println(-1);
			return;
		}
		if (num%2 == 0) {
			System.out.println(1*k + " " + num/2*k + " " + (num/2-1)*k);
		}
		else {
			if ((num-1)%4==0) {
				System.out.println(1*k + " " + ((num-1)/2+1)*k + " " + ((num-1)/2-1)*k);
			}
			else {
				System.out.println(1*k + " " + ((num-1)/2+2)*k + " " + ((num-1)/2-2)*k);
			}
		}
	}

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int[][] result = new int[T][3];
		for (int i=0; i<T; i++) {
			long n = sc.nextLong();
			long k = sc.nextLong();
			findThree(n, k);
		}
	}
}
