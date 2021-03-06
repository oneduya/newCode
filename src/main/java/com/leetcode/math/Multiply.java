package com.leetcode.math;

/**
 * @ClassName: Multiply
 * @Description: 两数相乘
 * @Author: WAHWJ
 * @Date: 2020/7/18 7:39
 * @Version: V0.1
 */
public class Multiply {
	public String multiply(String num1, String num2) {
		if (num1.equals("0") || num2.equals("0")) {
			return "0";
		}
		char[] chars1 = num1.toCharArray();
		char[] chars2 = num2.toCharArray();
		//num1*num2最多num1.length + num2.length位
		int[] result = new int[chars1.length + chars2.length];
		//对于num1的第i位和num2的第j位，他们的乘积最多两位，个位在i+j+1,十位在i+j
		for (int i = chars1.length - 1; i >= 0; i--) {
			for (int j = chars2.length - 1; j >= 0; j--) {
				int num = (chars1[i] - '0') * (chars2[j] - '0') + result[i + j + 1];
				result[i + j + 1] = num % 10;
				result[i + j] += num / 10;
			}
		}
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		for (int i = 0; i < result.length; i++) {
			if (i == 0 && result[i] == 0) {//首位为0
				continue;
			}
			sb.append(result[i]);
		}
		return sb.toString();
	}
}
