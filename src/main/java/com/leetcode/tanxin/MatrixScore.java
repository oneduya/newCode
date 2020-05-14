package com.leetcode.tanxin;

import java.util.concurrent.ThreadPoolExecutor;

/**
 * @ClassName: MatrixScore
 * @Description: 有一个二维矩阵 A 其中每个元素的值为 0 或 1 。
 *
 * 移动是指选择任一行或列，并转换该行或列中的每一个值：将所有 0 都更改为 1，将所有 1 都更改为 0。
 *
 * 在做出任意次数的移动后，将该矩阵的每一行都按照二进制数来解释，矩阵的得分就是这些数字的总和。
 *
 * 返回尽可能高的分数。
 * @Author: WAHWJ
 * @Date: 2020/5/6 23:51
 * @Version: V0.1
 */
public class MatrixScore {
    /**
     * @Author WAHWJ
     * @Description //首先A[r][c] ^ A[r][0]让第一列所有值都变为0，并
     * 且统计每一列中跟当前行首位相同或者不相同的数量，这样可以先对除第一列所在的列进行改变，然后再转变每一行
     * 保证第一列全为1，其余的列都能有最大数目的1
     * @Date 10:03 2020/5/7
     * @Param [A]
     * @return int
     **/
    public int matrixScore(int[][] A) {
        int R = A.length, C = A[0].length;
        int ans = 0;
        for (int c = 0; c < C; ++c) {
            int col = 0;
            for (int r = 0; r < R; ++r)
                col += A[r][c] ^ A[r][0];
            ans += Math.max(col, R - col) * (1 << (C-1-c));
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(1^1);
    }
}
