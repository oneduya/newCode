package com.leetcode;


import com.leetcode.list.ListNode;
import com.leetcode.tree.TreeNode;
import jdk.nashorn.internal.ir.CallNode;

import java.lang.reflect.Array;
import java.util.*;

public class Test {

    int[] dx = {1, -1, 0, 0};
    int[] dy = {0, 0, 1, -1};
    public int islandPerimeter(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    grid[i][j] = 0;
                    return helper(grid, i, j, 4);
                }
            }
        }
        return 0;
    }

    public int helper(int[][] grid, int x, int y, int res) {
        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];
            if (nx>=0 && nx<grid.length && ny>=0 && ny<grid[0].length && grid[nx][ny]==1) {
                grid[nx][ny] = 0;
                helper(grid, nx, ny, res-1+3);
            }
        }
        return res;
    }


    public static void main(String[] args) {

        int[][] grid = {{0,1,0,0},{1,1,1,0},{0,1,0,0},{1,1,0,0}};
        Test test = new Test();
        System.out.println(test.islandPerimeter(grid));
    }

    public static double myPow(double x, int n) {
        if (x == 0.0f) {
            return 0.0d;
        }
        long b = n;
        double res = 1.0;
        if (b < 0) {
            x = 1 / x;
            b = -b;
        }
        while (b > 0) {
            if ((b & 1) == 1) {
                res = (res * x) % 1000000007;
            }
            x = (x * x) % 1000000007;
            b >>= 1;
        }
        return res;
    }


}