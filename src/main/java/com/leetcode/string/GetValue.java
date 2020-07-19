package com.leetcode.string;

import java.util.Stack;

/**
 * @ClassName: GetValue
 * @Description: 字符串完成加减乘除操作，不包含括号
 * @Author: WAHWJ
 * @Date: 2020/7/16 20:14
 * @Version: V0.1
 */
public class GetValue {
	public int getValue(String expession) {
		Stack<Integer> nums = new Stack<>();
		Stack<Character> operators = new Stack<>();
		int len = expession.length();
		for (int i = 0; i < len; i++) {
			char c = expession.charAt(i);
			if (Character.isDigit(c)) {
				if (i - 1 >= 0 && Character.isDigit(expession.charAt(i - 1))) {
					int num = nums.pop();
					nums.push(num * 10 + c - '0');
				} else {
					nums.push(c - '0');
				}
			} else {
				while (!operators.isEmpty()) {
					if (c == '*' || c == '/') {
						if (operators.peek() == '*') {
							int m = nums.pop();
							int n = nums.pop();
							nums.push(n * m);
							operators.pop();
						} else if (operators.peek() == '/') {
							int m = nums.pop();
							int n = nums.pop();
							nums.push(n / m);
							operators.pop();
						}
						break;
					}
					else {
						int m = nums.pop();
						int n = nums.pop();
						if (operators.peek() == '+') {
							nums.push(n + m);
						} else if (operators.peek() == '-') {
							nums.push(n - m);
						}else if (operators.peek() == '*') {
							nums.push(n * m);
						} else if (operators.peek() == '/') {
							nums.push(n / m);
						}
						operators.pop();
					}
				}
				operators.push(c);
			}
		}
		while (!operators.isEmpty()) {
			int m = nums.pop();
			int n = nums.pop();
			if (operators.peek() == '+') {
				nums.push(m + n);
			} else if (operators.peek() == '-') {
				nums.push(n - m);
			} else if (operators.peek() == '*') {
				nums.push(n * m);
			} else if (operators.peek() == '/') {
				nums.push(n / m);
			}
			operators.pop();
		}
		return nums.pop();
	}
}
