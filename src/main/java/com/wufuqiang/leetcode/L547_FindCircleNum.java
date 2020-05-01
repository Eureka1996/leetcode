package com.wufuqiang.leetcode;

//朋友圈
public class L547_FindCircleNum {
	private int[][] directions = {{-1,0},{1,0},{0,1},{0,-1}};
	public int findCircleNum(int[][] M) {
		int result = 0;
		if(M==null || M.length == 0) return result;
		int n = M.length;
		int[] visited = new int[n];
		for(int i = 0;i<n;i++){
			if(visited[i] == 0){
				result+=1;
				dfs(M,visited,i);
			}
		}

		return result;
	}

	public void dfs(int[][] grid,int[] visited,int i){
		for(int j = 0;j<grid.length;j++){
			if(grid[i][j] == 1 && visited[j] == 0){
				visited[j] = 1;
				dfs(grid,visited,j);
			}
		}
	}
}

