package com.leetcode.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description: 给定一个无向、连通的树。树中有 N 个标记为 0...N-1 的节点以及 N-1 条边 。
 * 第 i 条边连接节点 edges[i][0] 和 edges[i][1] 。
 * 返回一个表示节点 i 与其他所有节点距离之和的列表 ans。
 * @ClassName: SumOfDistancesInTree
 * @author: WAHWJ
 * @version: 1.0.0
 * @createTime: 2020-10-06 09:01
 */
public class SumOfDistancesInTree {

    public int dfs(int start, int end, int[][] distance, int res, boolean[] arrived) {
        if (distance[start][end] != 0) {
            return distance[start][end];
        }
        if(start == end) {
            return res;
        }
        int tmp = Integer.MAX_VALUE;
        for (int i = 0; i < distance[start].length; i++) {
            if (!arrived[i] && distance[start][i] != 0) {
                arrived[i] = true;
                tmp = Math.min(dfs(i, end, distance, res+distance[start][i],arrived),tmp);
                arrived[i] = false;
            }
        }
        return tmp;
    }
}
