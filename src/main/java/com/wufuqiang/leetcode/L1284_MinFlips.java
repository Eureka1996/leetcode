package com.wufuqiang.leetcode;
//全零矩阵
public class L1284_MinFlips {
	private static int[][] directions = {{0,0},{0,1},{0,-1},{1,0},{-1,0}};
	private int ans = (int)1e9+7;
	public int minFlips(int[][] mat) {
		int row = mat.length;
		if(row == 0) return 0;
		int column = mat[0].length;
		dfs(mat,row,column,0,0);
		return this.ans == (int)1e9+7?-1:this.ans;
	}

	public void dfs(int[][] mat,int n,int m,int pos,int flitCnt){
		if(pos == n*m){
			boolean flag = true;
			for(int i = 0;i<m;i++){
				if(mat[n-1][i] == 1){
					flag = false;
					break;
				}
			}
			if(flag) this.ans = Math.min(ans,flitCnt);
			return;
		}

		int i = pos/m;
		int j = pos%m;
		if(i == 0){
			dfs(mat,n,m,pos+1,flitCnt);
			convert(mat,n,m,i,j);
			dfs(mat,n,m,pos+1,flitCnt+1);
			convert(mat,n,m,i,j);

		}else{
			if(mat[i-1][j] == 1){
				convert(mat,n,m,i,j);
				dfs(mat,n,m,pos+1,flitCnt+1);
				convert(mat,n,m,i,j);
			}else{
				dfs(mat,n,m,pos+1,flitCnt);
			}
		}

	}


	public void convert(int[][] mat,int n,int m,int i,int j){
		for(int[] d:directions){
			int ni= i + d[0];
			int nj= j+d[1];
			if(ni>=0 && ni<n &&
			   nj>=0 && nj<m ){
				mat[ni][nj] = mat[ni][nj] ^ 1;
			}
		}
	}
}
