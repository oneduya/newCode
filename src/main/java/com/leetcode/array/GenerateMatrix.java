package com.leetcode.array;

import java.util.Arrays;

/**
 * @ClassName: generateMatrix
 * @Description: 给定一个正整数 n，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的正方形矩阵。
 * @Author: WAHWJ
 * @Date: 2020/7/7 21:18
 * @Version: V0.1
 */
public class GenerateMatrix {
	public int[][] generateMatrix(int n) {
		int num = 1;
		int left = 0;
		int right = n-1;
		int up = 0;
		int down = n-1;
		int[][] result = new int[n][n];
		while (num<=n*n) {
			for (int i=left; i<=right; i++) {
				result[up][i] = num++;
			}
			up++;
			for (int i=up; i<=down; i++) {
				result[i][right] = num++;
			}
			right--;
			for (int i=right; i>=left; i--) {
				result[down][i] = num++;
			}
			down--;
			for (int i=down; i>=up; i--) {
				result[i][left] = num++;
			}
			left++;
		}
		return result;
	}

	public static void main(String[] args) {
		GenerateMatrix generateMatrix = new GenerateMatrix();
		System.out.println(Arrays.toString(generateMatrix.generateMatrix(3)));
	}
}
