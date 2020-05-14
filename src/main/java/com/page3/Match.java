package com.page3;

public class Match {
    /*public boolean match(char[] str, char[] pattern)
    {
        if(str==null || pattern==null){
            return false;
        }
        boolean[][] dp = new boolean[str.length+1][pattern.length+1];
        dp[str.length][pattern.length]=true;
        for (int i = str.length; i >= 0; i--) {//外循环：从空串开始匹配
            for (int j = pattern.length - 1; j >= 0; j--) {//内循环：从最后一个字符开始匹配
                if(j < pattern.length - 1 && pattern[j + 1] == '*') {
                    //1.1：当前相等
                    if(i < str.length && (str[i] == pattern[j] || pattern[j] == '.'))
                        dp[i][j] = dp[i][j + 2] || dp[i + 1][j];
                    else//1.2当前不等
                        dp[i][j] = dp[i][j + 2];
                }else {//若不是"*",看当前是否相等
                    if(i != str.length && (str[i] == pattern[j] || pattern[j] == '.')) {//当前相等
                        dp[i][j] = dp[i + 1][j + 1];
                    }
                }
            }
        }
        return dp[0][0];
    }*/

    public boolean match(char[] str, char[] pattern)
    {
        if(str==null || pattern==null){
            return false;
        }
        int strIndex = 0;
        int patternIndex = 0;
        return matchCore(str, strIndex, pattern, patternIndex);
    }

    public boolean matchCore(char[] str, int strIndex, char[] pattern, int patternIndex){
        if(patternIndex==pattern.length){
            return str.length == strIndex;
        }
        if(patternIndex<pattern.length-1 && pattern[patternIndex+1]=='*'){
            if(str.length!=strIndex &&
                    (str[strIndex]==pattern[patternIndex] || pattern[patternIndex]=='.')){
                return matchCore(str,strIndex,pattern,patternIndex+2) ||
                        matchCore(str,strIndex+1,pattern,patternIndex);
            }else{
                return matchCore(str,strIndex,pattern,patternIndex+2);
            }
        }
        if(str.length!=strIndex &&
                (str[strIndex]==pattern[patternIndex] || pattern[patternIndex]=='.')){
            matchCore(str,strIndex+1,pattern,patternIndex+1);
        }
        return false;
    }

    public static void main(String[] args) {
        Match match = new Match();
        char[] a = "a".toCharArray();
        char[] b = ".".toCharArray();
        System.out.println(match.match(a,b));
    }
}
