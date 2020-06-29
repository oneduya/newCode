package com.leetcode.hash;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName: FindSubstring
 * @Description: 给定一个字符串 s 和一些长度相同的单词 words。找出 s 中恰好可以由 words 中所有单词串联形成的子串的起始位置。
 *
 * 注意子串要与 words 中的单词完全匹配，中间不能有其他字符，但不需要考虑 words 中单词串联的顺序。
 * https://leetcode-cn.com/problems/substring-with-concatenation-of-all-words/solution/xiang-xi-tong-su-de-si-lu-fen-xi-duo-jie-fa-by-w-6/
 * @Author: WAHWJ
 * @Date: 2020/5/16 22:10
 * @Version: V0.1
 */
public class FindSubstring {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        HashMap<String,Integer> map = new HashMap<>();
        int slen = s.length();
        int wordlen = words[0].length();
        int wordNum = words.length;
        for(String word : words) {
            map.put(word,map.getOrDefault(word,0)+1);
        }
        for(int j=0;j<wordlen;j++) {
            HashMap<String, Integer> hasWords = new HashMap<String, Integer>();
            int num = 0; //记录当前 HashMap2（这里的 hasWords 变量）中有多少个单词
            //每次移动一个单词长度
            for(int i=j;i<slen-wordlen*wordNum+1;i+=wordlen) {
                boolean hasRemoved = false;
                while(num<wordNum) {
                    String word = s.substring(i+num*wordlen,i+num*wordlen+wordlen);
                    if(map.containsKey(word)) {
                        hasWords.put(word,hasWords.getOrDefault(word,0)+1);
                        //如果hasWords中的该单词数量比需要的多，则移除前面的直到满足条件数目
                        if(hasWords.get(word)>map.get(word)) {
                            hasRemoved = true;
                            int removeNum = 0;
                            while(hasWords.get(word)>map.get(word)) {
                                String removedWord = s.substring(i + removeNum * wordlen, i + removeNum*wordlen+wordlen);
                                hasWords.put(removedWord,hasWords.get(removedWord)-1);
                                removeNum++;
                            }
                            num = num - removeNum + 1; //加 1 是因为我们把当前单词加入到了 HashMap 2 中
                            i = i + (removeNum - 1) * wordlen; //这里依旧是考虑到了最外层的 for 循环，看情况二的解释
                            break;
                        }
                    }
                    //出现情况二，遇到了不匹配的单词，直接将 i 移动到该单词的后边（但其实这里
                    //只是移动到了出现问题单词的地方，因为最外层有 for 循环， i 还会移动一个单词
                    //然后刚好就移动到了单词后边）
                    else{
                        hasWords.clear();
                        i = i + num * wordlen;
                        num = 0;
                        break;
                    }
                    num++;
                }
                //判断是否满足了条件
                if(num==wordNum) {
                    result.add(i);
                }
                //如果一开始就匹配那移除前面的一个单词
                if(num>0 && !hasRemoved) {
                    String firstWord = s.substring(i, i + wordlen);
                    int v = hasWords.get(firstWord);
                    hasWords.put(firstWord, v - 1);
                    num = num - 1;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        FindSubstring findSubstring = new FindSubstring();
        System.out.println(findSubstring.findSubstring("wordwordgoodbest", new String[]{"word"}));
    }
}
