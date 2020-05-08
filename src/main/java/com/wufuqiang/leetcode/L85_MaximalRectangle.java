package com.wufuqiang.leetcode;

public class L85_MaximalRectangle {
	public int maximalRectangle(char[][] matrix) {
		int max = 0;
		if(matrix == null || matrix.length == 0) return max;
		int row = matrix.length;
		int column = matrix[0].length;
		for(int i = 0;i<row;i++){
			for(int j =0;j<column;j++){
				if(matrix[i][j] == '1'){
					char up = i == 0?'0':matrix[i-1][j];
					char left = j == 0?'0':matrix[i][j-1];
					char upLeft = j == 0 || i==0?'0':matrix[i-1][j-1];
					char min = (char)Math.min(Math.min(up,left),upLeft);
					if(min != '0'){

					}
				}
			}
		}
		return 0;
	}
}
