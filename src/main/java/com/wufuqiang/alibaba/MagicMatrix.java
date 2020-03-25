package com.wufuqiang.alibaba;

import java.util.Scanner;

public class MagicMatrix {
	private static Scanner scanner = new Scanner(System.in);
	public static void main(String[] args) {
		int n = scanner.nextInt();
		int[][] matrix = getMatrix(n);
		int[][] tmp = new int[3][n];
		for(int i = 0 ; i<3;i++){
			tmp[i][0] = 0;
		}
		for(int i = 1;i<n;i++){
			for(int j = 0 ; j < 3 ; j++){
				int n1 = Math.abs(matrix[j][i] - matrix[0][i-1])+tmp[0][i-1];
				int n2 = Math.abs(matrix[j][i] - matrix[1][i-1])+tmp[1][i-1];
				int n3 = Math.abs(matrix[j][i] - matrix[2][i-1])+tmp[2][i-1];
				tmp[j][i] = Math.min(Math.min(n1,n2),n3);
			}
		}

		System.out.println(Math.min(Math.min(tmp[0][n-1],tmp[1][n-1]),tmp[2][n-1]));
	}


	public static int[][] getMatrix(int n){

		int[][] matrix = new int[3][n];
		for(int i = 0 ;i < 3;i++){
			for(int j = 0 ; j < n ;j++){
				matrix[i][j] = scanner.nextInt();
			}
		}
		return matrix;
	}
}
