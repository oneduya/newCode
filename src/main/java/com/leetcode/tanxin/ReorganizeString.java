package com.leetcode.tanxin;

import com.sun.org.apache.xpath.internal.operations.Mult;

import java.util.PriorityQueue;

/**
 * @ClassName: reorganizeString
 * @Description: 给定一个字符串S，检查是否能重新排布其中的字母，使得两相邻的字符不同。若可行，输出任意可行的结果。若不可行，返回空字符串。
 * @Author: WAHWJ
 * @Date: 2020/5/6 13:29
 * @Version: V0.1
 */
class MultiChar {
    int count;
    char letter;

    MultiChar(int count, char letter) {
        this.count = count;
        this.letter = letter;
    }
}
public class ReorganizeString {
    public String reorganizeString(String S) {
        int counts[] = new int[26];
        int length = S.length();
        for(int i=0;i<length;i++) {
            counts[S.charAt(i)-'a'] += 1;
        }
        PriorityQueue<MultiChar> queue = new PriorityQueue<MultiChar>((a,b)->
        a.count==b.count ? a.letter-b.letter:b.count-a.count);
        for(int i=0;i<26;i++) {
            if (counts[i] > (length + 1) / 2) return "";
            queue.add(new MultiChar(counts[i],(char)('a'+i)));
        }
        StringBuilder sb = new StringBuilder("");
        while(queue.size()>=2) {
            MultiChar mc1 = queue.poll();
            MultiChar mc2 = queue.poll();
            sb.append(mc1.letter);
            sb.append(mc2.letter);
            if(--mc1.count >0 )queue.add(mc1);
            if(--mc2.count >0 )queue.add(mc2);
        }
        if (queue.size() > 0) sb.append(queue.poll().letter);
        return sb.toString();
    }
}
