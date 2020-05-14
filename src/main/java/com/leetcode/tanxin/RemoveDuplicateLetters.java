package com.leetcode.tanxin;

import org.springframework.beans.factory.SmartInitializingSingleton;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Stack;

/**
 * @ClassName: RemoveDuplicateLetters
 * @Description: 给你一个仅包含小写字母的字符串，请你去除字符串中重复的字母，使得每个字母只出现一次。需保证返回结果的字典序最小（要求不能打乱其他字符的相对位置）。
 * @Author: WAHWJ
 * @Date: 2020/5/7 12:04
 * @Version: V0.1
 */
public class RemoveDuplicateLetters {
    public String removeDuplicateLetters(String s) {
        Stack<Character> stack = new Stack();
        HashSet<Character> seen = new HashSet<>();
        HashMap<Character,Integer> lastApperenceMap = new HashMap<>();
        int len = s.length();
        for(int i=0;i<len;i++) {
            lastApperenceMap.put(s.charAt(i),i);
        }
        for(int i=0;i<s.length();i++) {
            char tmp = s.charAt(i);
            if(!seen.contains(tmp)) {
                while(!stack.isEmpty() && stack.peek()>tmp && lastApperenceMap.get(stack.peek())>i) {
                    seen.remove(stack.pop());
                }
                seen.add(tmp);
                stack.push(tmp);
            }
        }
        StringBuilder sb = new StringBuilder(stack.size());
        for(Character c : stack) {
            sb.append(c.charValue());
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        RemoveDuplicateLetters removeDuplicateLetters = new RemoveDuplicateLetters();
        removeDuplicateLetters.removeDuplicateLetters("ababc");
    }
}
