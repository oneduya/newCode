package com.leetcode.dinamicProgramming;

import java.util.HashMap;

/**
 * @ClassName: MinStickers
 * @Description: TODO
 * @Author: WAHWJ
 * @Date: 2020/6/8 21:28
 * @Version: V0.1
 */
public class MinStickers {
    public int minStickers(String[] stickers, String target) {
        HashMap<String,Integer> dp = new HashMap<>();
        int[][] mp = new int[stickers.length][26];
        for (int i = 0; i < stickers.length; i++) {
            int len = stickers[i].length();
            for (int j = 0; j < len; j++) {
                mp[i][stickers[i].charAt(j)-'a']++;
            }
        }
        dp.put("",0);
        return helper(dp,mp,target);
    }
    
    public int helper(HashMap<String,Integer> dp, int[][] mp, String target) {
        //如果map中包含解则直接返回
        if(dp.containsKey(target)) {
            return dp.get(target);
        }
        int ans = Integer.MAX_VALUE;
        int[] tar = new int[26];
        int len = target.length();
        //把目标字符串的字符个数都计算出来
        for (int i = 0; i < len; i++) {
            char c = target.charAt(i);
            tar[c-'a']++;
        }
        //遍历字典来找到可以粘贴的贴纸，挑出来后把目标字符串中可以站出来的去掉继续遍历
        for (int i = 0; i < mp.length; i++) {
            //剪枝
            if (mp[i][target.charAt(0) - 'a'] == 0) {
                continue;
            }
            StringBuffer sb = new StringBuffer();
            for(int j=0; j<26; j++) {
                if(tar[j]>0) {
                    for(int k=0; k<tar[j]-mp[i][j]; k++) {
                        sb.append((char)('a'+j));
                    }
                }
            }
            String s = sb.toString();
            int tmp = helper(dp,mp,s);
            if(tmp != -1) {
                ans = Math.min(tmp+1,ans);
            }
        }
        dp.put(target,ans==Integer.MAX_VALUE?-1:ans);
        return dp.get(target);
    }

    public static void main(String[] args) {
        MinStickers minStickers = new MinStickers();
        System.out.println(minStickers.minStickers(new String[]{"with", "example", "science"}, "thehat"));
    }
}
