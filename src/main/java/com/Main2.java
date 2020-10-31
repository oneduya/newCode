package com;


import java.util.*;
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		sc.nextLine();
		String one = sc.nextLine();
		String two = sc.nextLine();
		int[] need = new int[n-1];
		for (int i = 0; i < n; i++) {
			if (one.charAt(i) == '1') {
				if (i==0) {
					need[i]++;
				}else if (i==n-1) {
					need[i-1]++;
				}else {
					need[i]++;
					need[i-1]++;
				}
			}
			if (two.charAt(i) == '1') {
				if (i==0) {
					need[i]++;
				}else if (i==n-1) {
					need[i-1]++;
				}else {
					need[i]++;
					need[i-1]++;
				}
			}
		}
		need[0] = Math.abs(2-need[0]);
		int res = 0;
		for (int i = 0; i < need.length-1; i++) {
			need[i+1] = Math.abs(2-need[i+1]);
			if (need[i+1]>0 && need[i]>0) {
				need[i+1] = need[i]>=need[i+1] ? 0:1;
			}
			res += need[i];
		}
		res += need[need.length-1];
		System.out.println(res);
	}
}
