package com.wufuqiang.leetcode;

public class L980_UniquePathsIII {
	private int pathNum = 0;
	private int zeroNum = 0;
	public int uniquePathsIII(int[][] grid) {
		if(grid == null || grid.length == 0) return 0;
		int row = grid.length;
		int column = grid[0].length;
		int x = 0;
		int y = 0;
		for(int i = 0;i<row;i++){
			for(int j = 0;j<column;j++){
				if(grid[i][j] == 0) zeroNum+=1;
				if(grid[i][j] == 1){
					x=i;
					y=j;
				}
			}
		}
		backtrack(grid,x,y,row,column,-1);
		return pathNum;

	}

	private void backtrack(int[][] grid, int x, int y, int row, int column, int zeroNumTmp) {
		if(x<0 || y < 0 || x >= row || y>=column) return;
		if(grid[x][y] == -1) return;
		if(grid[x][y] == 2 && zeroNum != zeroNumTmp) return;
		if(grid[x][y] == 2 && zeroNum == zeroNumTmp){
			pathNum+=1;
			return;
		}
		int tmp = grid[x][y];
		grid[x][y] = -1;
		backtrack(grid,x,y+1,row,column,zeroNumTmp+1);
		backtrack(grid,x,y-1,row,column,zeroNumTmp+1);
		backtrack(grid,x+1,y,row,column,zeroNumTmp+1);
		backtrack(grid,x-1,y,row,column,zeroNumTmp+1);
		grid[x][y] = tmp;

	}

	public static void main(String[] args) {
		L980_UniquePathsIII l980 = new L980_UniquePathsIII();
		int i = l980.uniquePathsIII(new int[][]{{1, 0, 0, 0}, {0, 0, 0, 0}, {0, 0, 2, -1}});
		System.out.println(i);
	}
}
