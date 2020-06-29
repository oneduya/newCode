package com.leetcode.rollback;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: SolveNQueens
 * @Description: n 皇后问题研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * 皇后，是国际象棋中的棋子，意味着国王的妻子。皇后只做一件事，那就是“吃子”。
 * 当她遇见可以吃的棋子时，就迅速冲上去吃掉棋子。当然，她横、竖、斜都可走一到七步，可进可退。

 * @Author: WAHWJ
 * @Date: 2020/5/17 21:52
 * @Version: V0.1
 */
public class SolveNQueens {
    //使用一个二维数组来维护棋盘信息
    int[][] flag;
    List<List<String>> result;
    //用来存放每一行中queen的位置
    int[] tempres;
    public List<List<String>> solveNQueens(int n) {
        result = new ArrayList<>();
        flag = new int[n][n];
        tempres = new int[n];
        trackback(0,n);
        return result;
    }

    /**
     * @Author WAHWJ
     * @Description //向x，y位置放置皇后
     * @Date 22:15 2020/5/17
     * @Param [x, y]
     * @return void
     **/
    public void putQueen(int x, int y) {
        for(int i=0;i<flag.length;i++) {
            //更新行和列
            flag[x][i]++;
            flag[i][y]++;
            //更新对角线
            if(x+i<flag.length && y+i<flag.length) {
                flag[x+i][y+i]++;
            }
            if(x+i<flag.length && y-i>=0) {
                flag[x+i][y-i]++;
            }
            if(x-i>=0 && y+i<flag.length) {
                flag[x-i][y+i]++;
            }
            if(x-i>=0 && y-i>=0) {
                flag[x-i][y-i]++;
            }
        }
    }

    /**
     * @Author WAHWJ
     * @Description //移除x，y上的皇后
     * @Date 22:16 2020/5/17
     * @Param [x, y]
     * @return void
     **/
    public void removeQueen(int x, int y) {
        for(int i=0;i<flag.length;i++) {
            //更新行和列
            flag[x][i]--;
            flag[i][y]--;
            //更新对角线
            if(x+i<flag.length && y+i<flag.length) {
                flag[x+i][y+i]--;
            }
            if(x+i<flag.length && y-i>=0) {
                flag[x+i][y-i]--;
            }
            if(x-i>=0 && y+i<flag.length) {
                flag[x-i][y+i]--;
            }
            if(x-i>=0 && y-i>=0) {
                flag[x-i][y-i]--;
            }
        }
    }
    /**
     * @Author WAHWJ
     * @Description //回溯算法，比较正常的
     * @Date 23:00 2020/5/17
     * @Param [x, n]
     * @return void
     **/
    public void trackback(int x, int n) {
        if(x == n) {
            List<String> list = new ArrayList();
            for(int i=0;i<n;i++) {
                StringBuilder sb = new StringBuilder();
                for(int j=0;j<n;j++) {
                    if(tempres[i]==j) {
                        sb.append("Q");
                    }else{
                        sb.append(".");
                    }
                }
                list.add(sb.toString());
            }
            result.add(list);
            return;
        }
        for(int i=0;i<n;i++) {
            if(flag[x][i]==0) {
                StringBuilder sb = new StringBuilder();
                tempres[x] = i;
                putQueen(x,i);
                trackback(x+1,n);
                removeQueen(x,i);
            }
        }
    }


    public static void main(String[] args) {
        SolveNQueens solveNQueens = new SolveNQueens();
        System.out.println(solveNQueens.solveNQueens(4));
    }
}
