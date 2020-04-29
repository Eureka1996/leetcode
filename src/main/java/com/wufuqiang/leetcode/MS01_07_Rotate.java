package com.wufuqiang.leetcode;
//旋转矩阵
public class MS01_07_Rotate {
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		if(n==0) return;
		int row1 = n/2-1;
		int column1 = (n-1)/2;
		for(int i = 0;i<=row1;i++){
			for(int j = 0;j<=column1;j++){
				swap(matrix,i,j,j,n-i-1);
				swap(matrix,i,j,n-i-1,n-j-1);
				swap(matrix,i,j,n-j-1,i);
			}
		}

	}

	public void swap(int[][] matrix,int i,int j,int k,int z){
		int tmp = matrix[i][j];
		matrix[i][j] = matrix[k][z];
		matrix[k][z] = tmp;
	}
}
