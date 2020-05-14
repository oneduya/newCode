package com.leetcode.tanxin;

import java.util.Stack;

/**
 * @ClassName: SmallestSubsequence
 * @Description: 返回字符串 text 中按字典序排列最小的子序列，该子序列包含 text 中所有不同字符一次。
 * @Author: WAHWJ
 * @Date: 2020/5/10 23:22
 * @Version: V0.1
 */
public class SmallestSubsequence {
    public String smallestSubsequence(String text) {
        Stack<Character> stack = new Stack();
        int len = text.length();
        for(int i=0;i<len;i++) {
            Character c = text.charAt(i);
            if(stack.contains(c)) {
                continue;
            }
            while(!stack.isEmpty() && stack.peek()>c && text.indexOf(stack.peek(),i)!=-1) {
                stack.pop();
            }
            stack.push(c);
        }
        StringBuilder sb = new StringBuilder();
        for(Character c:stack) {
            sb.append(c);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        SmallestSubsequence smallestSubsequence = new SmallestSubsequence();
        System.out.println(smallestSubsequence.smallestSubsequence("cdadabcc"));
    }
}
