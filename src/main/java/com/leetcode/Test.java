package com.leetcode;


import com.leetcode.list.ListNode;
import com.leetcode.tree.TreeNode;
import jdk.nashorn.internal.ir.CallNode;

import java.util.*;

public class Test {
	public ListNode reverseList (ListNode head) {
		ListNode cur = head;
		ListNode pre = null;
		ListNode next = null;
		while (cur != null) {
			next = cur.next;
			cur.next = pre;
			pre = cur;
			cur = next;
		}
		return pre;
	}
	public static void main(String[] args) {
		int[] array = new int[]{1, 5, 6, 3, 4, 9, 7, 8, 2};
		long a = 1000000000L;
		int b = 1000000000;
		long res = 1;
		System.out.println(myPow(2,1000000000));
		System.out.println(res);
	}

	public static double myPow(double x, int n) {
		if(x == 0.0f) {
			return 0.0d;
		}
		long b = n;
		double res = 1.0;
		if(b < 0) {
			x = 1 / x;
			b = -b;
		}
		while(b > 0) {
			if((b & 1) == 1) {
				res = (res*x)%1000000007;
			}
			x = (x*x)%1000000007;
			b >>= 1;
		}
		return res;
	}


}