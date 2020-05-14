package com.leetcode.huadongchuangkou;

import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicStampedReference;
import java.util.concurrent.atomic.LongAdder;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @ClassName: BalancedString
 * @Description: 有一个只含有 'Q', 'W', 'E', 'R' 四种字符，且长度为 n 的字符串。
 *
 * 假如在该字符串中，这四个字符都恰好出现 n/4 次，那么它就是一个「平衡字符串」。
 * 给你一个这样的字符串 s，请通过「替换一个子串」的方式，使原字符串 s 变成一个「平衡字符串」。
 *
 * 你可以用和「待替换子串」长度相同的 任何 其他字符串来完成替换。
 *
 * 请返回待替换子串的最小可能长度。
 *
 * 如果原字符串自身就是一个平衡字符串，则返回 0。
 * @Author: WAHWJ
 * @Date: 2020/5/9 11:05
 * @Version: V0.1
 */
public class BalancedString {
    volatile int abc = 1;
    public int balancedString(String s) {
        int len = s.length();
        int need = len/4;
        int[] target = new int[26];
        for(int i=0;i<len;i++) {
            char c = s.charAt(i);
            target[c-'A']++;
        }
        for(Character c : new char[]{'Q','W','E','R'}) {
            target[c-'A'] -= need;
        }
        int[] tmp = new int[26];
        if(match(target,tmp)){
            return 0;
        }
        int l=0,r=0;
        int result = len;
        while(r<len) {
            tmp[s.charAt(r)-'A']++;
            while(match(target,tmp) && l<=r){
                result = Math.min(result,r-l+1);
                tmp[s.charAt(l++)-'A']--;
            }
            r++;
        }
        return result;
    }

    public boolean match(int[] array1, int[] array2) {
        for(int i=0;i<array1.length;i++) {
            if(array1[i]>0 && array1[i]>array2[i]){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        BalancedString balancedString = new BalancedString();
        balancedString.balancedString("WWEQERQWQWWRWWERQWEQ");
        LongAdder longAdder = new LongAdder();
    }
}
