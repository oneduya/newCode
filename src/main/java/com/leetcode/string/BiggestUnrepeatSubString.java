package com.leetcode.string;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName: BiggestUnrepeatSubString
 * @Description: 寻找无重复字符的最长子串
 * @Author: WAHWJ
 * @Date: 2020/4/20 9:23
 * @Version: V0.1
 */
public class BiggestUnrepeatSubString {
    public static int lengthOfLongestSubstring(String s) {
        int n = s.length();
        Set<Character> set = new HashSet<>();
        int ans = 0, i = 0, j = 0;
        while (i < n && j < n) {
            // try to extend the range [i, j]
            if (!set.contains(s.charAt(j))){
                set.add(s.charAt(j++));
                ans = Math.max(ans, j - i);
            }
            else {
                set.remove(s.charAt(i++));
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        String s = "a";
        System.out.println(lengthOfLongestSubstring(s));
    }
}
