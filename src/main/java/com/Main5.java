package com;

import java.util.Arrays;
import java.util.*;


public class Main5 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = sc.nextInt();
		}
		int res = 0;
		for (int i=0; i<n; i++) {
			if (arr[i]==0) {
				continue;
			}
			while (arr[i]>0) {
				int j=i;
				while (j<n && arr[j]>0) {
					j++;
				}
				if ((j-i) >= arr[i]) {
					for (int k = i; k < j; k++) {
						arr[k]--;
					}
				} else {
					arr[i] = 0;
				}
				res++;
			}
		}
		System.out.println(res);
	}
}
