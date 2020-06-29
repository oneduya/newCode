package com.leetcode.rollback;

/**
 * @ClassName: SolveSudoku
 * @Description: 编写一个程序，通过已填充的空格来解决数独问题。
 *
 * 一个数独的解法需遵循如下规则：
 *
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。
 * 空白格用 '.' 表示。
 * @Author: WAHWJ
 * @Date: 2020/5/14 13:04
 * @Version: V0.1
 */
public class SolveSudoku {
    int n=3,N=n*n;
    boolean hasResult = false;//是否已有答案
    boolean[][] rows = new boolean[N][N];//行是否可放矩阵
    boolean[][] cols = new boolean[N][N];//列是否可放矩阵
    boolean[][] boxes = new boolean[N][N];//3*3格子是否可放矩阵
    char[][] board;
    public void solveSudoku(char[][] board) {
        this.board = board;
        //首先根据数组中已有的数字将判断条件填充
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                char c = board[i][j];
                if (c != '.') {
                    place(i, j, c);
                }
            }
        }
        trackback(0,0);
        board = this.board;
    }

    /**
     * @Author WAHWJ
     * @Description //判断是否可以放置c这个数字
     * @Date 23:36 2020/5/14
     * @Param [row, col, c]
     * @return boolean
     **/
    public boolean canPlace(int row,int col,char c) {
        int idx = (row / n ) * n + col / n;
        //如果判断数组中该位置为true也就是同行或者同列或者同块已经存在该数字
        //则返回false
        if(rows[row][c-'1'] || cols[col][c-'1'] || boxes[idx][c-'1']) {
            return false;
        }
        return true;
    }

    /**
     * @Author WAHWJ
     * @Description //放置字符在row,col位置并且将判断数组置位
     * @Date 21:56 2020/5/14
     * @Param [board, row, col, c]
     * @return void
     **/
    public void place(int row,int col,char c) {
        int idx = (row / n ) * n + col / n;
        rows[row][c-'1'] = true;
        cols[col][c-'1'] = true;
        boxes[idx][c-'1'] = true;
        board[row][col] = c;
    }

    /**
     * @Author WAHWJ
     * @Description //移除字符并且将判断数组置位
     * @Date 21:56 2020/5/14
     * @Param [board, row, col, c]
     * @return void
     **/
    public void remove(int row,int col,char c) {
        int idx = (row / n ) * n + col / n;
        rows[row][c-'1'] = false;
        cols[col][c-'1'] = false;
        boxes[idx][c-'1'] = false;
        board[row][col] = '.';
    }

    /**
     * @Author WAHWJ
     * @Description //继续放下一个格子
     * @Date 23:35 2020/5/14
     * @Param [row, col]
     * @return void
     **/
    public void placeNextNumbers(int row, int col) {
        //如果当前已经放置了最后一个格子，则表明答案满足条件直接返回
        if ((col == N - 1) && (row == N - 1)) {
            hasResult = true;
        }
        else {
            //从上到下从左到右开始填充
            if (col == N - 1) trackback(row + 1, 0);
            else trackback(row, col + 1);
        }
    }

    /**
     * @Author WAHWJ
     * @Description //***重要：回溯算法，用于填充数字和回溯
     * @Date 23:39 2020/5/14
     * @Param [row, col]
     * @return void
     **/
    public void trackback(int row, int col) {
        //如果当前位置不为'.'则直接跳过
        if(board[row][col] != '.') {
            placeNextNumbers(row,col);
        }else{
            //从1开始放，如果可以放进去就进入递归
            for(char i='1';i<='9';i++) {
                if(canPlace(row,col,i)) {
                    place(row,col,i);
                    //放置下一个
                    placeNextNumbers(row,col);
                    //如果目前没有答案，则拿出来，再继续循环
                    if(!hasResult) {
                        remove(row,col,i);
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        SolveSudoku solveSudoku = new SolveSudoku();
        char[][] board = new char[][]{{'5','3','.','.','7','.','.','.','.'},{'6','.','.','1','9','5','.','.','.'},{'.','9','8','.','.','.','.','6','.'},{'8','.','.','.','6','.','.','.','3'},{'4','.','.','8','.','3','.','.','1'},{'7','.','.','.','2','.','.','.','6'},{'.','6','.','.','.','.','2','8','.'},{'.','.','.','4','1','9','.','.','5'},{'.','.','.','.','8','.','.','7','9'}};
        solveSudoku.solveSudoku(board);
    }
}
