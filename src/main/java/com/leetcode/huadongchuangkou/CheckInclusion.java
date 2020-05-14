package com.leetcode.huadongchuangkou;

import java.util.HashMap;

/**
 * @ClassName: CheckInclusion
 * @Description: 给定两个字符串 s1 和 s2，写一个函数来判断 s2 是否包含 s1 的排列。
 *
 * 换句话说，第一个字符串的排列之一是第二个字符串的子串。
 * @Author: WAHWJ
 * @Date: 2020/5/8 23:20
 * @Version: V0.1
 */
public class CheckInclusion {
    public boolean checkInclusion(String s1, String s2) {
        int len1 = s1.length();
        int len2 = s2.length();
        if(len1>len2) {
            return false;
        }
        int[] s1map = new int[26];
        int[] s2map = new int[26];
        for(int i=0;i<len1;i++) {
            s1map[s1.charAt(i)-'a']++;
            s2map[s2.charAt(i)-'a']++;
        }

        for(int i=0;i<len2-len1;i++) {
            if(match(s1map,s2map)) {
                return true;
            }
            s2map[s2.charAt(i)-'a']--;
            s2map[s2.charAt(len1+i)-'a']++;
        }
        return match(s1map,s2map);
    }

    public boolean match(int[] map1, int[] map2) {
        for(int i=0;i<map1.length;i++) {
            if(map1[i]!=map2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckInclusion checkInclusion = new CheckInclusion();
        System.out.println(checkInclusion.checkInclusion("ab","cccab"));
    }
}
