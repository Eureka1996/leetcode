package com.wufuqiang.leetcode;
//最大正方形 动态规划
public class L221_MaximalSquare {
	public int maximalSquare(char[][] matrix) {
		int max = 0;
		if(matrix == null || matrix.length == 0) return max;
		int row = matrix.length;
		int column = matrix[0].length;

		for(int i = 0;i<row;i++){
			for(int j = 0;j<column;j++){
				if(matrix[i][j] == 1 +'0'){
					char up = i == 0?'0':matrix[i-1][j];
					char left = j == 0?'0':matrix[i][j-1];
					char upLeft = i == 0 || j == 0?'0':matrix[i-1][j-1];
					char min = 0;
					if(up <= left && up <= upLeft) min = up;
					else if(left <= up && left <= upLeft) min = left;
					else min = upLeft;
					matrix[i][j] = (char)(min+1);
					if(max<matrix[i][j]) max = matrix[i][j];
				}
			}
		}
		if(max == 0) return max;
		else return (max-'0')*(max-'0');
	}
}
