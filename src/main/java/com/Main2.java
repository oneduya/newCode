package com;


import java.util.*;
public class Main2 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] hand = sc.nextLine().toCharArray();
		char[] need = sc.nextLine().toCharArray();
		int[] needNum = new int[26];
		for (int i = 0; i < need.length; i++) {
			needNum[need[i]-'A']++;
		}
		int res = 0;
		for (int i = 0; i < hand.length; i++) {
			if (needNum[hand[i]-'A'] >0) {
				res++;
				needNum[hand[i]-'A']--;
			}
		}
		System.out.println(res);
	}
}
