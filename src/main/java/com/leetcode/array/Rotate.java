package com.leetcode.array;

/**
 * @ClassName: Rotate
 * @Description: 给定一个 n × n 的二维矩阵表示一个图像。
 *
 *              将图像顺时针旋转 90 度。
 * @Author: WAHWJ
 * @Date: 2020/7/16 21:54
 * @Version: V0.1
 */
public class Rotate {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		//相当于分成四块
		for (int i = 0; i < (n+1) / 2; i ++) {
			for (int j = 0; j < n / 2; j++) {
				int temp = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - 1 - i][n - j - 1];
				matrix[n - 1 - i][n - j - 1] = matrix[j][n - 1 -i];
				matrix[j][n - 1 - i] = matrix[i][j];
				matrix[i][j] = temp;
			}
		}
	}
}
