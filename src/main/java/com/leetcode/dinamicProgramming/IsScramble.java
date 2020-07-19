package com.leetcode.dinamicProgramming;

import java.util.HashMap;

/**
 * @ClassName: IsScramble
 * @Description: 87.给出两个长度相等的字符串 s1 和 s2，判断 s2 是否是 s1 的扰乱字符串。
 * @Author: WAHWJ
 * @Date: 2020/7/5 8:27
 * @Version: V0.1
 */
public class IsScramble {
	/**
	 * 递归解法
	 *
	 * @param s1
	 * @param s2
	 * @return {@link boolean}
	 * @throws
	 * @author WAHWJ
	 * @date 2020/7/5 WAHWJ
	 */
	public boolean isScramble(String s1, String s2) {
		//用map记录已经计算过的组合
		HashMap<String, Integer> map = new HashMap<>();
		return isScrambleHelper(s1,s2,map);
	}

	public boolean isScrambleHelper(String s1, String s2, HashMap<String,Integer> map) {
		//如果记录中有该组合的结果，如果是1则返回true，0则返回false
		int flag = map.getOrDefault(s1+"*"+s2,-1);
		if (flag == 1) {
			return true;
		}
		else if (flag == 0) {
			return false;
		}
		//判断长度是否相等
		int len1 = s1.length();
		int len2 = s2.length();
		if (len1!=len2) {
			map.put(s1+"*"+s2,0);
			return false;
		}
		//如果字符串相等直接返回true
		if (s1.equals(s2)) {
			map.put(s1 + "#" + s2, 1);
			return true;
		}
		//如果字符串中的字符不相同则返回false
		int[] letters = new int[26];
		for (int i = 0; i < s1.length(); i++) {
			letters[s1.charAt(i) - 'a']++;
			letters[s2.charAt(i) - 'a']--;
		}
		for (int i = 0; i < 26; i++)
			if (letters[i] != 0) {
				map.put(s1 + "#" + s2, 0);
				return false;
			}

		//递归匹配，匹配原则是，遍历所有可能划分的位置，划分后按交换和不交换来分别分析，有一种可能就返回true
		for (int i=1; i<len1; i++) {
			boolean flag1 = isScrambleHelper(s1.substring(0,i), s2.substring(0,i), map)
					&& isScrambleHelper(s1.substring(i,len1), s2.substring(i,len1), map);
			boolean flag2 = isScrambleHelper(s1.substring(0,i), s2.substring(len1-i,len1), map)
					&& isScrambleHelper(s1.substring(i,len1), s2.substring(0,len1-i), map);
			if(flag1 || flag2) {
				map.put(s1+"*"+s2,1);
				return true;
			}
		}
		map.put(s1+"*"+s2,0);
		return false;
	}

	public static void main(String[] args) {
		IsScramble isScramble = new IsScramble();
		System.out.println(isScramble.isScramble("great", "rgeat"));
	}
}
