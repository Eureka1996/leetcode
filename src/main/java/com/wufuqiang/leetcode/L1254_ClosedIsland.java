package com.wufuqiang.leetcode;
//封闭岛屿数目 dfs
public class L1254_ClosedIsland {
	private int[][] directions = {{0,1},{0,-1},{1,0},{-1,0}};
	private boolean flag = true;
	public int closedIsland(int[][] grid) {
		int result = 0;
		if(grid == null || grid.length == 0) return result;
		int row = grid.length;
		int column = grid[0].length;
		for(int i = 0 ;i<row;i++){
			for(int j = 0;j<column;j++){
				if(grid[i][j] == 0){
					this.flag = true;
					dfs(grid,row,column,i,j);
					if(this.flag) result+=1;
				}
			}
		}

		return result;
	}

	public void dfs(int[][] grid,int row,int column,int i,int j){
		if(i==0 || i==row-1 || j == 0 || j ==column-1) this.flag = false;
		grid[i][j] = 1;
		for(int[] d : directions){
			int nr = i+d[0];
			int nc = j+d[1];
			if(nr>=0 && nr < row && nc >= 0 && nc < column && grid[nr][nc] == 0){
				dfs(grid,row,column,nr,nc);
			}
		}
	}
}

//[     [0,0,1,1,0,1,0,0,1,0],
//		[1,1,0,1,1,0,1,1,1,0],
//		[1,0,1,1,1,0,0,1,1,0],
//		[0,1,1,0,0,0,0,1,0,1],
//		[0,0,0,0,0,0,1,1,1,0],
//		[0,1,0,1,0,1,0,1,1,1],
//		[1,0,1,0,1,1,0,0,0,1],
//		[1,1,1,1,1,1,0,0,0,0],
//		[1,1,1,0,0,1,0,1,0,1],
//		[1,1,1,0,1,1,0,1,1,0]]