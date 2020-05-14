package com.leetcode.DinamicProgramming;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName: minimumTotal
 * @Description: 给定一个三角形，找出自顶向下的最小路径和。每一步只能移动到下一行中相邻的结点上。
 * @Author: WAHWJ
 * @Date: 2020/5/12 22:30
 * @Version: V0.1
 */
public class MinimumTotal {
    public int minimumTotal(List<List<Integer>> triangle) {
        if(triangle==null || triangle.size()==0) {
            return 0;
        }
        int size = triangle.size();
        int dp[] = new int[size];//用于存放之前行和当前行的对应位置的最短路径

        int prev=0;
        int cur;
        //不断更新dp[j],用prev来表示更新前的dp[j-1],用cur来表示更新前上一层的dp[j]，
        // 更新之后的dp[j]只与这两个有关
        for(int i=0;i<size;i++) {
            List<Integer> row = triangle.get(i);
            for(int j=0;j<=i;j++) {
                cur = dp[j];//cur赋值还是上一层的dp[j]
                if(j==0) {
                    dp[j] = row.get(0)+cur;
                }
                else if(j==i) {
                    dp[j] = row.get(i)+prev;
                }
                else{
                    dp[j] = row.get(j) + Math.min(cur,prev);
                }
                prev = cur;//prev赋值后在下一次循环时就变成了上一层的dp[j-1]
            }
        }
        int result = Integer.MAX_VALUE;
        //遍历dp数组找到最后一层中最小的和
        for(int value : dp) {
            result = Math.min(result,value);
        }
        return result;
    }

    /**
     * @Author WAHWJ
     * @Description //这个方法更巧妙，是自底向上的方法来构建动态数组，
     * 每次根据下一层的最小和来构建当前层的最小和
     * @Date 23:05 2020/5/12
     * @Param [triangle]
     * @return int
     **/
    public int minimumTotal2(List<List<Integer>> triangle) {
        int row = triangle.size();
        int[] minlen = new int[row+1];
        for (int level = row-1;level>=0;level--){
            for (int i = 0;i<=level;i++){   //第i行有i+1个数字
                minlen[i] = Math.min(minlen[i], minlen[i+1]) + triangle.get(level).get(i);
            }
        }
        return minlen[0];
    }

}
