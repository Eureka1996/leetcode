package com.wufuqiang.leetcode;

public class L1020_NumEnclaves {
	private int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
	public int numEnclaves(int[][] A) {
		int result = 0;
		if(A==null || A.length == 0) return result;
		int n = A.length;
		int m = A[0].length;
		for(int i = 0 ; i < n;i++){
			if(A[i][0] == 1) dfs(A,n,m,i,0);
			if(A[i][m-1] == 1) dfs(A,n,m,i,m-1);
		}
		for(int i = 0;i<m;i++){
			if(A[0][i] == 1) dfs(A,n,m,0,i);
			if(A[n-1][i] == 1) dfs(A,n,m,n-1,i);
		}
		for (int i = 1;i<n;i++){
			for(int j = 1;j<m;j++){
				if(A[i][j] == 1) result+=1;
			}
		}

		return result;
	}

	public void dfs(int[][] grid,int n,int m ,int i , int j){
		grid[i][j] = 0;
		for(int[] d:directions){
			int nrow = i+d[0];
			int ncolumn = j+d[1];
			if(nrow>=0 && nrow < n &&
			   ncolumn >= 0 && ncolumn < m
			   && grid[nrow][ncolumn] == 1){
				dfs(grid,n,m,nrow,ncolumn);
			}
		}
	}
}
