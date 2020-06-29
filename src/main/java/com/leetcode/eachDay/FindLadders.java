package com.leetcode.eachDay;

import java.util.*;

/**
 * @ClassName: FindLadders
 * @Description: 给定两个单词（beginWord 和 endWord）和一个字典 wordList，找出所有从 beginWord 到 endWord 的最短转换序列。转换需遵循如下规则：
 *
 * 每次转换只能改变一个字母。
 * 转换过程中的中间单词必须是字典中的单词。
 * 说明:
 *
 * 如果不存在这样的转换序列，返回一个空列表。
 * 所有单词具有相同的长度。
 * 所有单词只由小写字母组成。
 * 字典中不存在重复的单词。
 * 你可以假设 beginWord 和 endWord 是非空的，且二者不相同。
 *
 * @Author: WAHWJ
 * @Date: 2020/6/7 23:23
 * @Version: V0.1
 */
public class FindLadders {
    HashMap<String,Integer> wordId = new HashMap<>();
    ArrayList<String> idWord = new ArrayList<>();
    ArrayList<Integer>[] lines;
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        int size = wordList.size();
        for (int i = 0; i < size; i++) {
            String word = wordList.get(i);
            wordId.put(word,i);
            idWord.add(word);
        }
        if(!wordList.contains(endWord)) {
            return new ArrayList<>();
        }
        //如果不包含初始字符串则加入
        if (!wordId.containsKey(beginWord)) {
            wordId.put(beginWord, size);
            idWord.add(beginWord);
        }

        //初始化图的边集合
        lines = new ArrayList[size+1];
        for (int i = 0; i < lines.length; i++) {
            lines[i] = new ArrayList<Integer>();
        }

        //添加边
        for (int i = 0; i < idWord.size(); i++) {
            //注意这里i1是从i+1开始
            for (int i1 = i+1; i1 < idWord.size(); i1++) {
                // 若两者可以通过转换得到 则在它们间建一条无向边
                if (transformCheck(idWord.get(i), idWord.get(i1))) {
                    lines[i].add(i1);
                    lines[i1].add(i);
                }
            }
        }

        //目的id
        int dest = wordId.get(endWord);
        List<List<String>> result = new ArrayList<>();
        //初始化代价数组
        int[] cost = new int[size+1];
        for (int i = 0; i < cost.length; i++) {
            cost[i] = Integer.MAX_VALUE;
        }

        //在队列中存放所有当前结果集合，也就是可能用到的word集合
        Queue<ArrayList<Integer>> queue = new LinkedList<>();
        //放入第一个word并且把代价置为0
        ArrayList<Integer> beginTmp = new ArrayList<>();
        beginTmp.add(wordId.get(beginWord));
        queue.add(beginTmp);
        cost[wordId.get(beginWord)] = 0;

        while(!queue.isEmpty()) {
            List<Integer> now = queue.poll();
            //查看最后一个是不是endWord，如果是则直接加入结果集
            int last = now.get(now.size()-1);
            if(last==dest) {
                List<String> resultTmp = new ArrayList<>();
                //根据索引找字符串
                for (int i = 0; i < now.size(); i++) {
                    resultTmp.add(idWord.get(now.get(i)));
                }
                result.add(resultTmp);
            }
            //不是终点继续搜索
            else {
                for (int i = 0; i < lines[last].size(); i++) {
                    int to = lines[last].get(i);
                    // 此处<=目的在于把代价相同的不同路径全部保留下来
                    if (cost[last] + 1 <= cost[to]) {
                        cost[to] = cost[last] + 1;
                        // 把to加入路径中
                        ArrayList<Integer> tmp = new ArrayList<>(now);
                        tmp.add(to);
                        // 把这个路径加入队列
                        queue.add(tmp);
                    }
                }
            }
        }
        return result;
    }

    /**
     * @Author WAHWJ
     * @Description //判断两个字符串是否可以通过修改一个字符相等
     * @Date 23:31 2020/6/7
     * @Param [a, b]
     * @return boolean
     **/
    public boolean transformCheck(String a, String b) {
        int differences = 0;
        int len = a.length();
        for (int i = 0; i < len; i++) {
            if(a.charAt(i)!=b.charAt(i)) {
                differences++;
            }
        }
        return differences==1;
    }

    public static void main(String[] args) {
        FindLadders findLadders = new FindLadders();
        List<String> wordList = new ArrayList<>();
        wordList.add("hot");
        wordList.add("dot");
        wordList.add("dog");
        wordList.add("lot");
        wordList.add("log");
        wordList.add("cog");
        System.out.println(findLadders.findLadders("hit", "cog", wordList));
    }
}
