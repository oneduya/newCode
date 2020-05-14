package com.leetcode.huadongchuangkou;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName: MinWindow
 * @Description: 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字母的最小子串。
 * @Author: WAHWJ
 * @Date: 2020/5/6 22:15
 * @Version: V0.1
 */
public class MinWindow {
    /**
     * @Author WAHWJ
     * @Description 滑动窗口法，l和r先移动r找到合适的窗口，然后再移动l保证每一步都是最优的
     * @Date 22:57 2020/5/6
     * @Param [s, t]
     * @return java.lang.String
     **/
    public String minWindow(String s, String t) {

        if (s.length() == 0 || t.length() == 0) {
            return "";
        }

        //统计t中出现的字符以及次数
        Map<Character, Integer> dictT = new HashMap<Character, Integer>();
        for (int i = 0; i < t.length(); i++) {
            int count = dictT.getOrDefault(t.charAt(i), 0);
            dictT.put(t.charAt(i), count + 1);
        }

        int required = dictT.size();
        int l = 0, r = 0;
        int formed = 0;
        //先找到满足条件的r
        Map<Character, Integer> windowCounts = new HashMap<Character, Integer>();
        int[] ans = {-1, 0, 0};
        while(r<s.length()) {
            char tmp = s.charAt(r);
            int count = windowCounts.getOrDefault(tmp,0);
            windowCounts.put(tmp,count+1);
            if(dictT.containsKey(tmp) && dictT.get(tmp).intValue()==windowCounts.get(tmp).intValue()) {
                formed++;
            }
            while(l<=r && formed==required) {
                tmp = s.charAt(l);
                if(ans[0]==-1 || r-l+1<ans[0]) {
                    ans[0] = r-l+1;
                    ans[1] = l;
                    ans[2] = r;
                }
                count = windowCounts.get(tmp);
                windowCounts.put(tmp,count-1);
                if(dictT.containsKey(tmp) && dictT.get(tmp).intValue()>windowCounts.get(tmp).intValue()) {
                    formed--;
                }
                l++;
            }
            r++;
        }

        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }

    public static void main(String[] args) {
        MinWindow minWindow = new MinWindow();
        minWindow.minWindow("a","a");
    }
}
