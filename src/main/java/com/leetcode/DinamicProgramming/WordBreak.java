package com.leetcode.DinamicProgramming;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @ClassName: WordBreak
 * @Description: 给定一个非空字符串 s 和一个包含非空单词列表的字典 wordDict，
 * 判定 s 是否可以被空格拆分为一个或多个在字典中出现的单词
 * @Author: WAHWJ
 * @Date: 2020/5/17 20:40
 * @Version: V0.1
 */
public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        /*动态规划*/
        int len = s.length();
        boolean[] dp = new boolean[len+1];
        dp[0] = true;
        //i从1开始，然后j从0到i如果有j-i匹配的字符串并且j为true说明连上了，那么i也为true，break
        for(int i=1;i<dp.length;i++) {
            for(int j=0;j<i;j++) {
                if(dp[j] && wordDict.contains(s.substring(j,i))){
                    dp[i] = true;
                    break;
                };
            }
        }
        return dp[len];
    }

    public static void main(String[] args) {
        WordBreak wordBreak = new WordBreak();
        List<String> list = new ArrayList(){{add("leet");add("code");}};
        System.out.println(wordBreak.wordBreak("leetcode", list));
    }
}
