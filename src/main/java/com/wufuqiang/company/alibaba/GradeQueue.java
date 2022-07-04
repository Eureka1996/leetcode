package com.wufuqiang.company.alibaba;

import java.util.Scanner;

public class GradeQueue {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		int n = scanner.nextInt();
		int m = scanner.nextInt();
		int q = scanner.nextInt();
		int[][] matrix = new int[n][m];
		for(int i = 0 ;i < n ;i++){
			for(int j = 0 ;j< m ; j++){
				matrix[i][j] = scanner.nextInt();
			}
		}
		solutionMatrix(matrix);
		for(int i = 0 ; i < q ;i++){
			for(int j = 0;j < 2;j++){
				int x = scanner.nextInt()-1;
				int y = scanner.nextInt()-1;
				if(x<0 || x > matrix.length || y < 0 || y > matrix[0].length || matrix[x][y] == 0){
					System.out.println("Unknown");
				}else{
					System.out.println(matrix[x][y]);
				}

			}
		}

	}

	public static void solutionMatrix(int[][] matrix){
		int row = matrix.length;
		int column = matrix[0].length;
		for(int i = 0 ; i < row ;i++){
			int start = 0;
			int end = 0;

			int startIndex = 0;
			int endIndex = 0;
			int step = 0;

			boolean flag = true;

			for(int j = 0 ;j<column;j++){
				if(matrix[i][j] != 0){
					if(flag){
						start = matrix[i][j];
						startIndex = j;
						flag = false;
					}else{
						end = matrix[i][j];
						endIndex = j;
						flag = true;
					}
				}
				if(endIndex>startIndex){
					step = (end-start)/(endIndex-startIndex);
					for(int z = startIndex+1 ; z < column;z++){
						matrix[i][z] = matrix[i][z-1]+step;
					}
					for(int z = endIndex-1;z>=0;z--){
						matrix[i][z] = matrix[i][z+1] -step;
					}
				}
			}


		}

		for(int i = 0 ; i < column ;i++){
			int start = 0;
			int end = 0;

			int startIndex = 0;
			int endIndex = 0;
			int step = 0;

			boolean flag = true;

			for(int j = 0 ;j<row;j++){
				if(matrix[j][i] != 0){
					if(flag){
						start = matrix[j][i];
						startIndex = j;
						flag = false;
					}else{
						end = matrix[j][i];
						endIndex = j;
						flag = true;
					}
				}
				if(endIndex>startIndex){
					step = (end-start)/(endIndex-startIndex);
					for(int z = startIndex+1 ; z < row;z++){
						matrix[z][i] = matrix[z-1][i]+step;
					}
					for(int z = endIndex-1;z>=0;z--){
						matrix[z][i] = matrix[z+1][i] -step;
					}
				}
			}

		}
	}
}
