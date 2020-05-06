package com.wufuqiang.leetcode;
//螺旋矩阵2
public class L59_GenerateMatrix {
	public int[][] generateMatrix(int n) {
		int[][] result = new int[n][n];
		int squ = n*n;
		int row = 0;
		int column = 0;
		int[][] directions = new int[][]{{0,1},{1,0},{0,-1},{-1,0}};
		int d = 0;
		for(int i =1 ;i<=squ;i++){
			result[row][column] = i;
			int nrow = row + directions[d][0];
			int ncolumn = column + directions[d][1];
			if(nrow >= 0 && nrow <n && ncolumn >= 0 && ncolumn < n && result[nrow][ncolumn] == 0){
				row = nrow;
				column = ncolumn;
			}else{
				d = (d+1)%4;
				row = row + directions[d][0];
				column = column + directions[d][1];
			}


		}
		return result;
	}
}
