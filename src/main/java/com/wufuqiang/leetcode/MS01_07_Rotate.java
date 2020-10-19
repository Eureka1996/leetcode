package com.wufuqiang.leetcode;
//旋转矩阵，顺时针90度
// 给定 matrix =
//[
//  [ 5, 1, 9,11],
//  [ 2, 4, 8,10],
//  [13, 3, 6, 7],
//  [15,14,12,16]
//],
//
//原地旋转输入矩阵，使其变为:
//[
//  [15,13, 2, 5],
//  [14, 3, 4, 1],
//  [12, 6, 8, 9],
//  [16, 7,10,11]
//]
public class MS01_07_Rotate {

	public static void main(String[] args) {
		int[][] grid = {{15, 13, 2, 5,1},
				        {14,  3, 4, 1,1},
				        {12,  6, 8, 9,1},
				        {16,  7,10,11,1},
						{1,   1, 1, 1,1}};

		MS01_07_Rotate ms = new MS01_07_Rotate();
		ms.rotate(grid);
	}

	public void rotate(int[][] matrix) {
		//矩阵长度
		int n = matrix.length;
		if(n==0) return;
        //要旋转的行数
		int row1 = n/2-1;
		//要旋转的列数
		int column1 = (n-1)/2;
		for(int i = 0;i<=row1;i++){
			for(int j = 0;j<=column1;j++){
				System.out.println("i="+i+",j="+j);
				//(i,j) (j,n-i-1)
				swap(matrix,i,j,j,n-i-1);
				//(i,j) (n-i-1,n-j-1)
				swap(matrix,i,j,n-i-1,n-j-1);
				//(i,j) (n-j-1,i)
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
